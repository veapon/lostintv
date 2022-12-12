package tv.lostin.service;

import tv.lostin.entity.File;

/**
 * Description
 *
 * @author veapon
 * @date 2022/8/31
 */
public interface FileService {

    /**
     *
     * @param file
     */
    void add(File file);

    void getMetadata(File file);
}
