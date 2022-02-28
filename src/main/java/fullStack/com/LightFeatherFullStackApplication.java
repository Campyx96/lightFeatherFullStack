package fullStack.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
// Allow the application to run without configuring a local data source 
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

public class LightFeatherFullStackApplication {

	public static void main(String[] args) {
		SpringApplication.run(LightFeatherFullStackApplication.class, args);
	}

}
