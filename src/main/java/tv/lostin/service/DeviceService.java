package tv.lostin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import tv.lostin.entity.Device;
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
public interface DeviceService extends IService<Device> {

    Device create(DeviceDTO dto);
    Device update(Long id, DeviceDTO dto);
    boolean delete(Long id);
    Device info(Long id);
    List<Device> all();
}
