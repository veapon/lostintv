package tv.lostin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import tv.lostin.entity.Album;
import com.baomidou.mybatisplus.extension.service.IService;
import tv.lostin.request.AlbumDTO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author veapon
 * @since 2022-12-02
 */
public interface AlbumService extends IService<Album> {
    Album create(AlbumDTO dto);
    Album update(Long id, AlbumDTO dto);
    boolean delete(Long id);
    Album info(Long id);
    Page<Album> query(AlbumDTO dto);
}
