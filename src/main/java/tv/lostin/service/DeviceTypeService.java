package tv.lostin.service;

import tv.lostin.constant.DeviceTypeConstant;
import tv.lostin.entity.DeviceEntity;
import tv.lostin.entity.FileEntity;
import tv.lostin.exception.DeviceTypeException;
import tv.lostin.service.impl.SmbServiceImpl;

import java.io.IOException;
import java.util.List;

/**
 * Description
 *
 * @author veapon
 * @date 2022/8/31
 */
public abstract class DeviceTypeService {
    public abstract List<FileEntity> ls(String path);

    public static DeviceTypeService getInstance(DeviceEntity device) throws IOException {
        if (device.getType().equals(DeviceTypeConstant.TYPE_SMB)) {
            return new SmbServiceImpl(device.getHost(), device.getUser(), device.getPassword());
        }
//        if (device.getType().equals(DeviceTypeConstant.TYPE_LOCAL)) {
//            return new LocalService();
//        }

        throw new DeviceTypeException("Unsupported device type: " + device.getType());
    }
}
