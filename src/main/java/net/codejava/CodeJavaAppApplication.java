package net.codejava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class CodeJavaAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(CodeJavaAppApplication.class, args);
	}

}
