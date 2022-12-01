package tv.lostin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author veapon
 */
@SpringBootApplication
@EnableAsync
public class MainApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
	}

}
