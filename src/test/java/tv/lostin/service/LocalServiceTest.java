package tv.lostin.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Description
 *
 * @author veapon
 * @date 2022/8/2
 */
@SpringBootTest
public class LocalServiceTest {

    @Autowired
    private LocalService localService;

    @Test
    public void testLs() {
        localService.ls("/Users/veapon/Music/tmp");
    }
}
