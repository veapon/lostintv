package tv.lostin.service;

import tv.lostin.entity.Artist;
import com.baomidou.mybatisplus.extension.service.IService;
import tv.lostin.entity.Folder;
import tv.lostin.request.ArtistDTO;
import tv.lostin.request.FolderDTO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author veapon
 * @since 2022-12-02
 */
public interface ArtistService extends IService<Artist> {
    Artist add(ArtistDTO dto);
    Artist info(Long id);
    List<Artist> query(ArtistDTO dto);
}
