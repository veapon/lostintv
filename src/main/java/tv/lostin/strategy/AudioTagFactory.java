package tv.lostin.strategy;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Description
 *
 * @author veapon
 * @date 2022/9/30
 */
@Component
public class AudioTagFactory {
    @Autowired
    private Map<String, AudioTagStrategy> strategies;

    public AudioTagStrategy getStrategy(String type) {
        AudioTagStrategy strategy = strategies.get(type.concat("Tag"));
        if(strategy == null) {
            throw new RuntimeException("Unsupported audio type：" + type);
        }
        return strategy;
    }
}
