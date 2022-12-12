package tv.lostin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author veapon
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("file")
public class File extends BaseEntity {
    private String path;
    private String name;
    private Integer directory;
    private Long folderId;
    private Long deviceId;
    private String extension;
    private String size;
    private Date lastScanTime;
}
