package tv.lostin.request;

import lombok.Data;

/**
 * Description
 *
 * @author veapon
 * @date 2022/1/8
 */
@Data
public class FolderDTO {

    private Long deviceId;
    private String type;
    private String path;
    private String mountPoint;
}
