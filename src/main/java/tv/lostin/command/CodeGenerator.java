package tv.lostin.command;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import tv.lostin.entity.BaseEntity;

/**
 * Description
 *
 * @author veapon
 * @date 2022/12/2
 */
public class CodeGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:sqlite::resource:db/lostintv.db", null, null)
                .globalConfig(builder -> {
                    builder.outputDir(System.getProperty("user.dir").concat("/temp"))
                            .author("veapon")
                            .build();
                })
                .packageConfig(builder -> {
                    builder.parent("tv.lostin")
                            .build();
                })
                .strategyConfig(builder -> {
                    builder.entityBuilder()
                            .enableLombok()
                            .superClass(BaseEntity.class)
                            .controllerBuilder()
                            .enableRestStyle()
                            .mapperBuilder()
                            .enableMapperAnnotation();

                })
                .execute();
    }
}
