package tv.lostin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.IService;

import tv.lostin.entity.DeviceEntity;
import tv.lostin.entity.FolderEntity;
import tv.lostin.request.DeviceDTO;
import tv.lostin.request.FolderDTO;

/**
 * Description
 *
 * @author veapon
 * @date 2022/1/8
 */
@Service
public interface FolderService extends IService<FolderEntity> {

    FolderEntity add(FolderDTO dto);
    FolderEntity update(Long id, FolderDTO dto);
    FolderEntity delete(Long id);
    FolderEntity info(Long id);
    List<FolderEntity> all();
}
