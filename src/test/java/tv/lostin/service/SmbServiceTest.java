package tv.lostin.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tv.lostin.executor.FileScanExecutor;

/**
 * Description
 *
 * @author veapon
 * @date 2022/6/25
 */
@SpringBootTest
public class SmbServiceTest {

    @Autowired
    private FileScanExecutor fileScanExecutor;

    @Test
    public void testLs() {
        for (int i = 0; i < 20; i++) {
            fileScanExecutor.test("index = " + i);
        }
    }
}
