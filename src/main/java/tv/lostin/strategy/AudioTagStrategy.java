package tv.lostin.strategy;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import tv.lostin.entity.Folder;

/**
 * Description
 *
 * @author veapon
 * @date 2022/9/30
 */
@Service
public interface AudioTagStrategy {
    default Boolean isValidExtension(String extension) {
        return Arrays.asList("mp3","m4a", "flac","ape","wav").contains(extension);
    }
}
