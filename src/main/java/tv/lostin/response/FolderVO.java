package tv.lostin.response;

import java.io.Serializable;

import lombok.Data;

/**
 * Description
 *
 * @author veapon
 * @date 2022/1/28
 */
@Data
public class FolderVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long deviceId;
    private String type;
    private String path;
    private String mountPoint;
}
