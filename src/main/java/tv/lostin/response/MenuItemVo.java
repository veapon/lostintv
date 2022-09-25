package tv.lostin.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

/**
 * Description
 *
 * @author veapon
 * @date 2022/8/22
 */
@Data
@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class MenuItemVo {
    private String id;

    private String name;

    private String path;

    private String locationType;

    private String serverId;

    private String type;

    private String collectionType;

    private Boolean isFolder;

    private Boolean enableMediaSourceDisplay;
}
