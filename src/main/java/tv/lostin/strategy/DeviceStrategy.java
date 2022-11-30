package tv.lostin.strategy;

import org.springframework.stereotype.Service;
import tv.lostin.entity.FolderEntity;

import java.util.Arrays;

/**
 * Description
 *
 * @author veapon
 * @date 2022/9/30
 */
@Service
public interface DeviceStrategy {
    public void scan(FolderEntity folder);

    default Boolean isValidExtension(String extension) {
        return Arrays.asList("mp3","flac","ape","wav","cue").contains(extension);
    }
}
