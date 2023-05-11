package com.spirngauth.authentication_spring;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.spirngauth.authentication_spring.models.ERole;
import com.spirngauth.authentication_spring.models.RoleModel;
import com.spirngauth.authentication_spring.repository.RoleRepository;

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
