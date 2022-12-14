package tv.lostin.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.houbb.opencc4j.util.ZhConverterUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import tv.lostin.constant.FileTypeConstant;
import tv.lostin.entity.*;
import tv.lostin.exception.DeviceTypeException;
import tv.lostin.mapper.FileMapper;
import tv.lostin.service.*;

/**
 * Description
 *
 * @author veapon
 * @date 2022/8/31
 */
@Service
@Slf4j
@AllArgsConstructor
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {

    private final FolderService folderService;
    private final DeviceService deviceService;
    private final ArtistService artistService;
    private final AlbumService albumService;
    private final TrackService trackService;

    @Override
    @Async("asyncTaskExecutor")
    public void add(File file) {
        boolean exists = lambdaQuery().eq(File::getDeviceId, file.getDeviceId())
                .eq(File::getFolderId, file.getFolderId())
                .eq(File::getPath, file.getPath())
                .exists();
        if (exists) {
            log.info("file exists: " + file.getPath());
            return;
        }

        log.info("inserting new file: " + file.getPath());
        getBaseMapper().insert(file);
    }

    @Override
//    @Async("asyncTaskExecutor")
    public void getMetadata(File file) {
        if (!FileTypeConstant.getMusicFileTypes().contains(file.getExtension())) {
            log.warn("getMetadata skipped, unsupported file extension: " + file.getExtension());
            return;
        }
        Folder folder = folderService.info(file.getFolderId());
        Assert.notNull(folder, "folder does not exists or has been deleted: " + file);

        Device device = deviceService.info(folder.getDeviceId());
        Assert.notNull(device, "device does not exists or has been deleted: " + file);

        if (!device.getType().equals("local")) {
            throw new DeviceTypeException("read metadata failed, unsupported device type: " + device.getType());
        }

        String path = String.format("%s/%s",
                StringUtils.trimTrailingCharacter(folder.getPath(), '/'),
                StringUtils.trimLeadingCharacter(file.getPath(), '/')
        );

        java.io.File fileIO  = new java.io.File(path);
        try {
            // todo
            // 1、应用路径规则生成artist/album
            // 2、从musicbrainz抓数据
            AudioFile audioFile = AudioFileIO.read(fileIO);
            Tag tag = audioFile.getTag();
            log.info(String.format("metadata: %s", tag.toString()));

            String artist = ZhConverterUtil.toSimple(tag.getFirst(FieldKey.ARTIST));
            String album = ZhConverterUtil.toSimple(tag.getFirst(FieldKey.ALBUM));
            String discNo = tag.getFirst(FieldKey.DISC_NO);
            String title = ZhConverterUtil.toSimple(tag.getFirst(FieldKey.TITLE));

            Artist artistEntry = new Artist();
            artistEntry.setName(artist);
            artistEntry.setDeletedAt(null);
            UpdateWrapper<Artist> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("name", artist);
            artistService.saveOrUpdate(artistEntry, updateWrapper);
            Long artistId = artistEntry.getId();

            Album albumEntry = new Album();
            albumEntry.setArtistId(artistId);
            albumEntry.setName(album);
            albumEntry.setDeletedAt(null);
            albumService.saveOrUpdate( albumEntry,
                    albumService.lambdaUpdate().getWrapper()
                            .eq(Album::getName, album)
                            .eq(Album::getArtistId, artistId)
            );

            Track track = new Track();
            track.setFileId(file.getId());
            track.setArtistId(artistId);
            track.setArtist(artist);
            track.setDiscNo(discNo);
            track.setTitle(title);
            track.setAlbum(album);
            track.setAlbumId(albumEntry.getId());
            track.setDeletedAt(null);
            trackService.saveOrUpdate(
                    track,
                    trackService.lambdaUpdate().getWrapper()
                            .eq(Track::getAlbumId, albumEntry.getId())
                            .eq(Track::getTitle, title)
            );

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
