package tv.lostin.service;

import java.io.IOException;
import java.io.InvalidClassException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tv.lostin.constant.DeviceTypeConstant;
import tv.lostin.entity.DeviceEntity;
import tv.lostin.entity.FolderEntity;
import tv.lostin.request.DeviceDTO;
import tv.lostin.request.FolderDTO;

/**
 * Description
 *
 * @author veapon
 * @date 2022/1/28
 */
@SpringBootTest
public class FolderServiceTest {

    @Autowired
    private FolderService folderService;

    @Test
    public void testAdd() {
        FolderDTO dto = new FolderDTO();
        dto.setType("Music");
        dto.setPath("/Users/veapon/Music/tmp");
        dto.setDeviceId(1L);
        dto.setMountPoint("/Music");
        FolderEntity entity = folderService.add(dto);
        System.out.println(entity);
        Assertions.assertNotNull(entity);
    }

    @Test
    public void testAddNotExistsDevice() {
        FolderDTO dto = new FolderDTO();
        dto.setType("Music");
        dto.setPath("/Users/veapon/Music/tmp");
        dto.setDeviceId(-1L);
        dto.setMountPoint("/Music");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            folderService.add(dto);
        });
    }

    @Test
    void info() {
        Long id = 2L;
        FolderEntity info = folderService.info(id);
        System.out.println(info);
        Assertions.assertEquals(info.getId(), id);
    }

    @Test
    void all() {
        List<FolderEntity> list = folderService.all();
        System.out.println(list);
        Assertions.assertNotNull(list);
    }

    @Test
    void delete() {
        Long id = 2L;
        folderService.delete(id);
        FolderEntity info = folderService.info(id);
        System.out.println(info);
        Assertions.assertNull(info);
    }

    @Test
    void scan() throws Exception {
        folderService.scan(2L);
    }
}
