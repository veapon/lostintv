package tv.lostin.request;

import lombok.Data;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

/**
 * Description
 *
 * @author veapon
 * @date 2022/1/8
 */
@Data
public class DeviceDTO {
    private Long id;
    private String alias;
    private String type;
    private String host;
    private String port;
    private String user;
    private String password;
}
