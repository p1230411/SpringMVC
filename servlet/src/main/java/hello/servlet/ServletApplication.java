package hello.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServletApplication {

	public static void main(String[] args) {
		System.out.println('test');
		SpringApplication.run(ServletApplication.class, args);
	}

}
