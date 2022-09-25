package tv.lostin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
}