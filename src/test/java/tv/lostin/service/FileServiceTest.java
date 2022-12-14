package tv.lostin.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tv.lostin.entity.File;

/**
 * Description
 *
 * @author veapon
 * @date 2022/12/14
 */
@SpringBootTest
public class FileServiceTest {
    @Autowired
    private FileService fileService;

    @Test
    public void testGetMetadata() {
        File file = fileService.getById(7);
        fileService.getMetadata(file);
    }
}
