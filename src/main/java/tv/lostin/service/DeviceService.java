package tv.lostin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import tv.lostin.entity.DeviceEntity;
import tv.lostin.request.DeviceDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description
 *
 * @author veapon
 * @date 2022/1/8
 */
@Service
public interface DeviceService extends IService<DeviceEntity> {

    DeviceEntity create(DeviceDTO dto);
    DeviceEntity update(Long id, DeviceDTO dto);
    boolean delete(Long id);
    DeviceEntity info(Long id);
    List<DeviceEntity> all();
}
