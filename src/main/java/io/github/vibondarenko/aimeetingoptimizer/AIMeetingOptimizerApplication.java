package io.github.vibondarenko.aimeetingoptimizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class AIMeetingOptimizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AIMeetingOptimizerApplication.class, args);
	}

}
