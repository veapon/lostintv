package tv.lostin.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.AllArgsConstructor;
import org.springframework.util.Assert;
import tv.lostin.entity.DeviceEntity;
import tv.lostin.entity.FolderEntity;
import tv.lostin.mapper.FolderMapper;
import tv.lostin.request.FolderDTO;
import tv.lostin.service.DeviceService;
import tv.lostin.service.FolderService;
import tv.lostin.strategy.DeviceFactory;
import tv.lostin.strategy.DeviceStrategy;

/**
 * Description
 *
 * @author veapon
 * @date 2022/1/8
 */
@Service
@AllArgsConstructor
@Slf4j
public class FolderServiceImpl extends ServiceImpl<FolderMapper, FolderEntity> implements FolderService {

    private final FolderMapper folderMapper;
    private final DeviceService deviceService;
    @Autowired
    private DeviceFactory deviceFactory;

    @Override
    public FolderEntity add(FolderDTO dto) {
        FolderEntity folderEntity = new FolderEntity();
        folderEntity.setType(dto.getType());
        folderEntity.setPath(dto.getPath());
        folderEntity.setMountPoint(dto.getMountPoint());
        folderEntity.setDeviceId(dto.getDeviceId());
        folderMapper.insert(folderEntity);
        return folderEntity;
    }

    @Override
    public FolderEntity update(Long id, FolderDTO dto) {
        FolderEntity entity = this.getById(id);
        Assert.notNull(entity, "找不到该文件夹");
        entity.setType(dto.getType());
        entity.setPath(dto.getPath());
        entity.setMountPoint(dto.getMountPoint());
        entity.setDeviceId(dto.getDeviceId());
        return entity;
    }

    @Override
    public FolderEntity delete(Long id) {
        FolderEntity entity = this.getById(id);
        Assert.notNull(entity, "找不到该文件夹");
        entity.setDeletedAt(new Date());
        folderMapper.updateById(entity);
        return entity;
    }

    @Override
    public FolderEntity info(Long id) {
        return folderMapper.selectOne(
                new QueryWrapper<FolderEntity>()
                    .eq("id", id)
                    .isNull("deleted_at")
        );
    }

    @Override
    public List<FolderEntity> all() {
        return folderMapper.selectList(
                new QueryWrapper<FolderEntity>()
                    .isNull("deleted_at")
        );
    }

    @Override
    public void scan(Long id) {
        FolderEntity folder = this.getById(id);
        Assert.notNull(folder, "找不到该文件夹");

        DeviceEntity device = deviceService.info(folder.getDeviceId());
        try {
            DeviceStrategy strategy = deviceFactory.getStrategy(device.getType());
            strategy.scan(folder);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }

    }
}
