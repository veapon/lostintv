package tv.lostin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("system_file")
public class SystemFile extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String originName;

    private String path;

    private String size;


}
