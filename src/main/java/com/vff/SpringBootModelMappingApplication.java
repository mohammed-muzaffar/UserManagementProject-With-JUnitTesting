package com.vff;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot Rest API Documentation",
				description = "Spring Boot Restful Application",
				version = "v1.0",
				contact = @Contact(
						name="Mohammed Muzaffar",
						email = "mohammedmuzaffar294@gmail.com",
						url="https://viewfullform.com"
				)
		)
)
public class SpringBootModelMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootModelMappingApplication.class, args);
	}

}
