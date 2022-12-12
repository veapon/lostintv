package tv.lostin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Description
 *
 * @author veapon
 * @date 2022/1/28
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("folder")
@ToString(callSuper = true)
public class Folder extends BaseEntity {
    private Long deviceId;
    private String path;
    private String mountPoint;
    private String type;
}
