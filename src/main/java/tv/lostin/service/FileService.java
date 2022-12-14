package tv.lostin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import tv.lostin.entity.File;
import tv.lostin.entity.Track;

/**
 * Description
 *
 * @author veapon
 * @date 2022/8/31
 */
public interface FileService extends IService<File> {

    /**
     *
     * @param file
     */
    void add(File file);

    void getMetadata(File file);
}
