package codluck.training.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class TrainingDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingDemoApplication.class, args);
	}

}
