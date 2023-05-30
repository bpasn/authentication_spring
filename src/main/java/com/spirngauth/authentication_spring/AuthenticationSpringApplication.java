package com.spirngauth.authentication_spring;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;



@EnableConfigurationProperties

@SpringBootApplication
// @OpenAPIDefinition(
// 		info = @Info(
// 				title = "Hello World",
// 				version = "1.0.0",
// 				description = "This project is only for leaning",
// 				termsOfService = "runcodenow"
// 				// contact = @Contact(
// 				// 		name = "admin",
// 				// 		email = "spring_root@email.com"
// 				// ),
// 				// license = @License(
// 				// 		name = "licence",
// 				// 		url = "runcodenow"
// 				// )
// 		)
// )
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
		SpringApplication.run(AuthenticationSpringApplication.class, args);
	}

	// Create role
	// @Bean
	// public CommandLineRunner commandLineRunner(RoleRepository roleRepository) {
		
	// 	return args -> {
	// 		List<RoleModel> role = List.of(
	// 				new RoleModel(ERole.ROLE_ADMIN),
	// 				new RoleModel(ERole.ROLE_MODERATOR),
	// 				new RoleModel(ERole.ROLE_USER)

	// 		);
	// 		roleRepository.saveAll(role);
	// 	};
	// }
	

}
