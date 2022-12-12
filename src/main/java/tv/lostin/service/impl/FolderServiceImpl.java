package tv.lostin.service.impl;

import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.AllArgsConstructor;
import org.springframework.util.Assert;
import tv.lostin.entity.Device;
import tv.lostin.entity.Folder;
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
@Slf4j
@AllArgsConstructor
public class FolderServiceImpl extends ServiceImpl<FolderMapper, Folder> implements FolderService {

    private final FolderMapper folderMapper;
    private final DeviceService deviceService;
    private final DeviceFactory deviceFactory;

    @Override
    public Folder add(FolderDTO dto) {
        Device device = deviceService.info(dto.getDeviceId());
        Assert.notNull(device, String.format("device not found(id=%s)", dto.getDeviceId()));

        Folder folderEntity = new Folder();
        folderEntity.setType(dto.getType());
        folderEntity.setPath(dto.getPath());
        folderEntity.setMountPoint(dto.getMountPoint());
        folderEntity.setDeviceId(dto.getDeviceId());
        folderMapper.insert(folderEntity);
        return folderEntity;
    }

    @Override
    public Folder update(Long id, FolderDTO dto) {
        Folder entity = this.getById(id);
        Assert.notNull(entity, "找不到该文件夹");
        entity.setType(dto.getType());
        entity.setPath(dto.getPath());
        entity.setMountPoint(dto.getMountPoint());
        entity.setDeviceId(dto.getDeviceId());
        folderMapper.updateById(entity);
        return entity;
    }

    @Override
    public Folder delete(Long id) {
        Folder entity = this.getById(id);
        Assert.notNull(entity, "找不到该文件夹");
        entity.setDeletedAt(new Date());
        folderMapper.updateById(entity);
        return entity;
    }

    @Override
    public Folder info(Long id) {
        return folderMapper.selectOne(
                new QueryWrapper<Folder>()
                    .eq("id", id)
                    .isNull("deleted_at")
        );
    }

    @Override
    public List<Folder> all() {
        return folderMapper.selectList(
                new QueryWrapper<Folder>()
                    .isNull("deleted_at")
        );
    }

    @Override
    public void scan(Long id) {
        Folder folder = this.getById(id);
        Assert.notNull(folder, String.format("folder not found(id=%d)", id));

        Device device = deviceService.info(folder.getDeviceId());
        Assert.notNull(folder, String.format("device not found(id=%d)", folder.getDeviceId()));

        try {
            DeviceStrategy strategy = deviceFactory.getStrategy(device.getType());
            strategy.scan(folder);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }
}
