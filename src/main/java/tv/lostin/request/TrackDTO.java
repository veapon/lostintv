package tv.lostin.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Description
 *
 * @author veapon
 * @date 2022/1/8
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TrackDTO extends PageDTO{
    private Long id;
    private String name;
    private String type;
    private String region;
    private Integer poster;
}
