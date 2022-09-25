package tv.lostin.executor;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import tv.lostin.entity.FileEntity;
import tv.lostin.entity.FolderEntity;
import tv.lostin.service.DeviceTypeService;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 *
 * @author veapon
 * @date 2022/9/1
 */
@Slf4j
@Service
public class FileScanExecutor {

    @Async
    public void scan(FolderEntity folder, DeviceTypeService deviceTypeService) {
        List<FileEntity> list = deviceTypeService.ls(path);
        list.forEach(e -> {
            if (e.isDirectory()) {
                scan(e.getPath());
            } else {
                e.setFolderId(folder.getId());
                e.setDeviceId(folder.getId());
                fileMapper.insert(e);
            }
        });
    }

}
