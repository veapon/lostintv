package tv.lostin.entity;

/**
 * Description
 *
 * @author veapon
 * @date 2022/7/9
 */

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("artist")
public class ArtistEntity extends BaseEntity{
    private String name;
    private String region;
    private String genre;
    private String musicbrainzId;
    private String cover;
}
