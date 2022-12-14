package tv.lostin.service;

import tv.lostin.constant.DeviceTypeConstant;
import tv.lostin.entity.Device;
import tv.lostin.request.DeviceDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Description
 *
 * @author veapon
 * @date 2022/1/28
 */
@SpringBootTest
public class DeviceServiceTest {

    @Autowired
    private DeviceService deviceService;

    @Test
    public void testAdd() {
        DeviceDTO deviceDTO = new DeviceDTO();
        deviceDTO.setType(DeviceTypeConstant.TYPE_LOCAL);
        Device deviceEntity = deviceService.create(deviceDTO);
//        System.out.println(deviceEntity);
        Assertions.assertNotEquals(null, deviceEntity.getId());
        Assertions.assertEquals(deviceDTO.getHost(), deviceEntity.getAlias());
    }

    @Test
    void info() {
        Long id = 1L;
        Device info = deviceService.info(id);
        Assertions.assertNotNull(info);
        Assertions.assertEquals(info.getId(), id);
    }

    @Test
    void all() {
        List<Device> list = deviceService.all();
        Assertions.assertNotNull(list);
        Assertions.assertNotNull(list);
    }

    @Test
    void delete() {
        Long id = 2L;
        deviceService.delete(id);
        Device info = deviceService.info(id);
        System.out.println(info);
        Assertions.assertNull(info);
    }
}
