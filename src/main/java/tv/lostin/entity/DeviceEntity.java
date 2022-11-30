package tv.lostin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

/**
 * DeviceEntity
 *
 * @author veapon
 * @date 2022/1/8
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("device")
@ToString(callSuper = true)
public class DeviceEntity extends BaseEntity{
    private String alias;
    private String type;
    private String host;
    private String port;
    private String user;
    private String password;
}
