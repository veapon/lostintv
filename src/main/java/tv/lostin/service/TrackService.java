package tv.lostin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import tv.lostin.entity.Artist;
import tv.lostin.entity.Track;
import com.baomidou.mybatisplus.extension.service.IService;
import tv.lostin.request.ArtistDTO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author veapon
 * @since 2022-12-02
 */
public interface TrackService extends IService<Track> {
    Track update(Long id);
    Page<Track> query(ArtistDTO dto);
}
