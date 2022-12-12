package tv.lostin.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * Description
 *
 * @author veapon
 * @date 2022/1/8
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AlbumDTO extends PageDTO{
    private Long id;
    private Long artistId;
    private String name;
    private Date releaseDate;
    private String genres;
    private Integer poster;
    private String musicBrainzId;
    private String doubanId;
}
