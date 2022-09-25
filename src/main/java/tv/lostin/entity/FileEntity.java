package tv.lostin.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author veapon
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FileEntity extends BaseEntity {
    private String path;
    private String name;
    private Integer directory;
    private Long folderId;
    private Long deviceId;
    private String extension;
    private String size;
    private String duration;
    private Date lastScanTime;

    public Boolean isDirectory() {
        return directory.equals(1);
    }
}
