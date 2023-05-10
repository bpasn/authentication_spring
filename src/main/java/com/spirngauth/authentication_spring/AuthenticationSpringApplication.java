package com.spirngauth.authentication_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthenticationSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationSpringApplication.class, args);
	}


	//Create role
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
