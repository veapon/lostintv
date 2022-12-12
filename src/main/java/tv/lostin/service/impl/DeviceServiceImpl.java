package tv.lostin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import tv.lostin.entity.Device;
import tv.lostin.entity.Folder;
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
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements DeviceService {

    private final DeviceMapper deviceMapper;

    @Override
    public Device create(DeviceDTO dto) {
        String alias = Optional.ofNullable(dto.getAlias()).orElse(dto.getHost());
        Device deviceEntity = new Device();
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
    public Device update(Long id, DeviceDTO dto) {
        Device entity = this.info(id);
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
        Device entity = this.info(id);
        Assert.notNull(entity, "找不到相关设备");
        entity.setDeletedAt(new Date());
        updateById(entity);
        LambdaUpdateWrapper<Folder> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Folder::getDeviceId, id).set(Folder::getDeletedAt, new Date());
        return true;
    }

    @Override
    public Device info(Long id) {
        return deviceMapper.selectOne(new QueryWrapper<Device>().eq("id", id).isNull("deleted_at"));
    }

    @Override
    public List<Device> all() {
        return deviceMapper.selectList(new QueryWrapper<Device>().isNull("deleted_at"));
    }
}
