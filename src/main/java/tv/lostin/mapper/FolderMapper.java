package tv.lostin.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import tv.lostin.entity.DeviceEntity;
import tv.lostin.entity.FolderEntity;

/**
 * Description
 *
 * @author veapon
 * @date 2022/1/10
 */
@Mapper
public interface FolderMapper extends BaseMapper<FolderEntity> {
}
