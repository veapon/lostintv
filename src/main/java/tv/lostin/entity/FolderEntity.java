package tv.lostin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Description
 *
 * @author veapon
 * @date 2022/1/28
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("folder")
public class FolderEntity extends BaseEntity {
    private Long deviceId;
    private String path;
    private String mountPoint;
    private String type;
}
