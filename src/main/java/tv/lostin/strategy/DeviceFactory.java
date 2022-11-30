package tv.lostin.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Description
 *
 * @author veapon
 * @date 2022/9/30
 */
@Component
public class DeviceFactory {
    @Autowired
    private Map<String, DeviceStrategy> strategies;

    public DeviceStrategy getStrategy(String type) throws Exception{
        DeviceStrategy strategy = strategies.get(type.concat("Device"));
        if(strategy == null) {
            throw new RuntimeException("不支持的设备类型：" + type);
        }
        return strategy;
    }
}
