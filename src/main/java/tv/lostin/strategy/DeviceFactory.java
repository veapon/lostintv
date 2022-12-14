package tv.lostin.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * Description
 *
 * @author veapon
 * @date 2022/9/30
 */
@Component
public class DeviceFactory {

    private final Map<String, DeviceStrategy> strategies;

    public DeviceFactory(@Lazy Map<String, DeviceStrategy> strategies) {
        this.strategies = strategies;
    }

    public DeviceStrategy getStrategy(String type) {
        DeviceStrategy strategy = strategies.get(type.concat("Device"));
        if(strategy == null) {
            throw new RuntimeException("Unsupported device type：" + type);
        }
        return strategy;
    }
}
