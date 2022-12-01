package tv.lostin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import tv.lostin.entity.FileEntity;
import tv.lostin.mapper.FileMapper;
import tv.lostin.service.FileService;

/**
 * Description
 *
 * @author veapon
 * @date 2022/8/31
 */
@Service
@AllArgsConstructor
@Slf4j
public class FileServiceImpl extends ServiceImpl<FileMapper, FileEntity> implements FileService {

    @Override
    @Async("asyncTaskExecutor")
    public void asyncSave(FileEntity file) {
        boolean exists = lambdaQuery().eq(FileEntity::getDeviceId, file.getDeviceId())
                .eq(FileEntity::getFolderId, file.getFolderId())
                .eq(FileEntity::getPath, file.getPath())
                .exists();
        if (exists) {
            log.info("file exists: " + file.getPath());
            return;
        }

        log.info("inserting new file: " + file.getPath());
        getBaseMapper().insert(file);
    }
}
