package tv.lostin.strategy.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tv.lostin.entity.File;
import tv.lostin.entity.Folder;
import tv.lostin.service.FileService;
import tv.lostin.strategy.DeviceStrategy;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Description
 *
 * @author veapon
 * @date 2022/9/30
 */
@Component
@Slf4j
@AllArgsConstructor
public class LocalDevice implements DeviceStrategy {

    private final FileService fileService;

    @Override
    public void scan(Folder folder) {
        String path = folder.getPath();

        try {
            long s = System.currentTimeMillis();
            Files.walk(Paths.get(path))
                    .filter(Files::isRegularFile)
                    .forEach(e -> {
                        java.io.File file = e.toFile();
                        log.info("file found: " + file.getPath());
                        if (!this.isValidExtension(FilenameUtils.getExtension(file.getPath()))) {
                            log.info("skip extension: " + FilenameUtils.getExtension(file.getPath()));
                            return;
                        }
                        File fileEntity = new File();
                        fileEntity.setName(file.getName());
                        fileEntity.setPath(file.getPath().replace(path, ""));
                        fileEntity.setExtension(FilenameUtils.getExtension(file.getPath()));
                        fileEntity.setFolderId(folder.getId());
                        fileEntity.setDeviceId(folder.getDeviceId());
                        fileService.add(fileEntity);
                    });
            log.info("scan finished, elapsed time: " + (System.currentTimeMillis() - s) + " ms");
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
