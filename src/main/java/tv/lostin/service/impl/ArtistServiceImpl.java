package tv.lostin.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import tv.lostin.entity.Artist;
import tv.lostin.mapper.ArtistMapper;
import tv.lostin.request.ArtistDTO;
import tv.lostin.service.ArtistService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author veapon
 * @since 2022-12-02
 */
@Service
@AllArgsConstructor
public class ArtistServiceImpl extends ServiceImpl<ArtistMapper, Artist> implements ArtistService {

    @Override
    public Artist add(ArtistDTO dto) {
        Artist artist = new Artist();
        artist.setDeletedAt(null);
        artist.setName(dto.getName());
        artist.setPoster(dto.getPoster());
        artist.setRegion(dto.getRegion());
        saveOrUpdate(artist, lambdaUpdate().eq(Artist::getName, dto.getName()));
        return artist;
    }

    @Override
    public Artist info(Long id) {
        return getById(id);
    }

    @Override
    public List<Artist> query(ArtistDTO dto) {
        return null;
    }
}
