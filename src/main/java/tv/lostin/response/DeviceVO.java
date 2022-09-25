package tv.lostin.response;

import lombok.Data;

import java.io.Serializable;

/**
 * Description
 *
 * @author veapon
 * @date 2022/1/28
 */
@Data
public class DeviceVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String alias;
    private String type;
    private String host;
    private String port;
}
