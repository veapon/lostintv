package tv.lostin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import tv.lostin.entity.DeviceEntity;
import tv.lostin.entity.FolderEntity;
import tv.lostin.mapper.DeviceMapper;
import tv.lostin.mapper.FolderMapper;
import tv.lostin.request.DeviceDTO;
import tv.lostin.service.DeviceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Description
 *
 * @author veapon
 * @date 2022/1/8
 */
@Service
@AllArgsConstructor
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, DeviceEntity> implements DeviceService {

    private final DeviceMapper deviceMapper;
    private final FolderMapper folderMapper;

    @Override
    public DeviceEntity create(DeviceDTO dto) {
        String alias = Optional.ofNullable(dto.getAlias()).orElse(dto.getHost());
        DeviceEntity deviceEntity = new DeviceEntity();
        deviceEntity.setAlias(alias);
        deviceEntity.setHost(dto.getHost());
        deviceEntity.setPort(dto.getPort());
        deviceEntity.setUser(dto.getUser());
        deviceEntity.setPassword(dto.getPassword());
        deviceEntity.setType(dto.getType());
        deviceMapper.insert(deviceEntity);
        return deviceEntity;
    }

    @Override
    public DeviceEntity update(Long id, DeviceDTO dto) {
        DeviceEntity entity = this.info(id);
        Assert.notNull(entity, "找不到相关设备");
        entity.setAlias(dto.getAlias());
        entity.setHost(dto.getHost());
        entity.setPort(dto.getPort());
        entity.setUser(dto.getUser());
        entity.setPassword(dto.getPassword());
        deviceMapper.updateById(entity);
        return entity;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(Long id) {
        DeviceEntity entity = this.info(id);
        Assert.notNull(entity, "找不到相关设备");
        entity.setDeletedAt(new Date());
        deviceMapper.updateById(entity);
        LambdaUpdateWrapper<FolderEntity> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(FolderEntity::getDeviceId, id).set(FolderEntity::getDeletedAt, new Date());
        return true;
    }

    @Override
    public DeviceEntity info(Long id) {
        return deviceMapper.selectOne(new QueryWrapper<DeviceEntity>().eq("id", id).isNull("deleted_at"));
    }

    @Override
    public List<DeviceEntity> all() {
        return deviceMapper.selectList(new QueryWrapper<DeviceEntity>().isNull("deleted_at"));
    }
}
