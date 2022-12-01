package tv.lostin.service;

import tv.lostin.entity.FileEntity;

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
    public void asyncSave(FileEntity file);
}
