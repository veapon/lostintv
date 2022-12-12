package tv.lostin.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.IService;

import tv.lostin.entity.Folder;
import tv.lostin.request.FolderDTO;

/**
 * Description
 *
 * @author veapon
 * @date 2022/1/8
 */
@Service
public interface FolderService extends IService<Folder> {

    Folder add(FolderDTO dto);
    Folder update(Long id, FolderDTO dto);
    Folder delete(Long id);
    Folder info(Long id);
    List<Folder> all();
    void scan(Long id) throws IOException, Exception;
}
