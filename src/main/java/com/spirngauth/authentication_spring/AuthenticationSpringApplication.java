package com.spirngauth.authentication_spring;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.Collections;


@EnableConfigurationProperties

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "My API", version = "v1"))
@SecurityScheme(
    name = "bearerAuth",
    type = SecuritySchemeType.HTTP,
    bearerFormat = "JWT",
    scheme = "bearer"
)
public class AuthenticationSpringApplication {

	@Value("${app.name}")
	private String appName;

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(AuthenticationSpringApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port",8833));
		System.out.println("SERVER START http://localhost:8888");
		app.run();
	}



}
