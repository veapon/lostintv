package tv.lostin.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import tv.lostin.entity.Album;
import tv.lostin.mapper.AlbumMapper;
import tv.lostin.request.AlbumDTO;
import tv.lostin.service.AlbumService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author veapon
 * @since 2022-12-02
 */
@Service
public class AlbumServiceImpl extends ServiceImpl<AlbumMapper, Album> implements AlbumService {
    @Override
    public Album create(AlbumDTO dto) {
        Album album = new Album();
        album.setArtistId(dto.getArtistId());
        album.setName(dto.getName());
        album.setReleaseDate(dto.getReleaseDate());
        album.setPoster(dto.getPoster());
        album.setGenres(dto.getGenres());
        album.setMusicBrainzId(dto.getMusicBrainzId());
        album.setDoubanId(dto.getDoubanId());
        album.setDeletedAt(null);
        saveOrUpdate(album,
                lambdaUpdate().eq(Album::getArtistId, dto.getArtistId())
                .eq(Album::getName, dto.getName())
                .eq(Album::getReleaseDate, dto.getReleaseDate())
        );
        return album;
    }

    @Override
    public Album update(Long id, AlbumDTO dto) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        Album album = getById(id);
        Assert.notNull(album, String.format("album not found(id=%d)", id));
        // todo 校验有关联的歌曲，不允许删除

        album.setDeletedAt(new Date());
        return lambdaUpdate().eq(Album::getId, id).update();
    }

    @Override
    public Album info(Long id) {
        return getById(id);
    }

    @Override
    public Page<Album> query(AlbumDTO dto) {
        Page<Album> page = new Page<>(dto.getPage(), dto.getPageSize());
        LambdaQueryChainWrapper<Album> query = lambdaQuery().eq(Album::getDeletedAt, null);
        if (StringUtils.hasLength(dto.getName())) {
            query.like(Album::getName, dto.getName());
        }

        return getBaseMapper().selectPage(page, query);
    }
}
