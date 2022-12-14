package tv.lostin.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import tv.lostin.entity.Track;
import tv.lostin.mapper.TrackMapper;
import tv.lostin.request.ArtistDTO;
import tv.lostin.service.TrackService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author veapon
 * @since 2022-12-02
 */
@Service
public class TrackServiceImpl extends ServiceImpl<TrackMapper, Track> implements TrackService {

    @Override
    public Track update(Long id) {
        return null;
    }

    @Override
    public Page<Track> query(ArtistDTO dto) {
        return null;
    }
}
