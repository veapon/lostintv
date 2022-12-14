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
public class Artist extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String name;

    private String type;

    private String region;

    private Integer poster;


}
