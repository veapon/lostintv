package tv.lostin.strategy.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import tv.lostin.entity.FileEntity;
import tv.lostin.entity.FolderEntity;
import tv.lostin.mapper.FileMapper;
import tv.lostin.strategy.DeviceStrategy;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Description
 *
 * @author veapon
 * @date 2022/9/30
 */
@Service
@Slf4j
@AllArgsConstructor
public class LocalDevice implements DeviceStrategy {
    @Autowired
    private final FileMapper fileMapper;

    @Override
    public void scan(FolderEntity folder) {
        String path = folder.getPath();

        try {
            Files.walk(Paths.get(path))
                    .filter(Files::isRegularFile)
                    .forEach(e -> {
                        File file = e.toFile();
                        log.info("file found: " + file.getPath());
                        if (!this.isValidExtension(FilenameUtils.getExtension(file.getPath()))) {
                            log.info("invalid extension: " + FilenameUtils.getExtension(file.getPath()));
                            return;
                        }
                        FileEntity fileEntity = new FileEntity();
                        fileEntity.setName(file.getName());
                        fileEntity.setPath(file.getPath().replace(path, ""));
                        fileEntity.setExtension(FilenameUtils.getExtension(file.getPath()));
                        fileEntity.setFolderId(folder.getId());
                        fileEntity.setDeviceId(folder.getDeviceId());
                        fileMapper.insert(fileEntity);
                    });
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
