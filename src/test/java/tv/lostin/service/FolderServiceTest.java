package tv.lostin.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tv.lostin.entity.Folder;
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
        Folder entity = folderService.add(dto);
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
        Folder info = folderService.info(id);
        System.out.println(info);
        Assertions.assertEquals(info.getId(), id);
    }

    @Test
    void all() {
        List<Folder> list = folderService.all();
        System.out.println(list);
        Assertions.assertNotNull(list);
    }

    @Test
    void delete() {
        Long id = 2L;
        folderService.delete(id);
        Folder info = folderService.info(id);
        System.out.println(info);
        Assertions.assertNull(info);
    }

    @Test
    void scan() throws Exception {
        folderService.scan(2L);
    }
}
