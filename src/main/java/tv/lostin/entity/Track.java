package tv.lostin.entity;

import java.io.Serializable;
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
public class Track extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long fileId;

    private String discNo;

    private String title;

    private Long artistId;
    private String artist;

    private Long albumId;
    private String album;

    private String duration;
}
