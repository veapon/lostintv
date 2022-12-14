package tv.lostin.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import tv.lostin.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author veapon
 * @since 2022-12-02
 */
@Getter
@Setter
public class Album extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String name;

    private Long artistId;

    private Date releaseDate;

    private Integer poster;

    private String genres;

    private String musicBrainzId;

    private String doubanId;


}
