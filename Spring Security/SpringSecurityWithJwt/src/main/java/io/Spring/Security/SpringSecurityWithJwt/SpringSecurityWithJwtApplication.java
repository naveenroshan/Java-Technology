package io.Spring.Security.SpringSecurityWithJwt;

import io.Spring.Security.SpringSecurityWithJwt.domain.AppUser;
import io.Spring.Security.SpringSecurityWithJwt.domain.UserRole;
import io.Spring.Security.SpringSecurityWithJwt.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityWithJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityWithJwtApplication.class, args);
	}

	// adding the user and roles
	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new UserRole(null,"ROLE_USER"));
			userService.saveRole(new UserRole(null,"ROLE_MANAGER"));
			userService.saveRole(new UserRole(null,"ROLE_ADMIN"));
			userService.saveRole(new UserRole(null,"ROLE_DEVELOPER"));

			userService.saveUser(new AppUser(null,"jhon" ,"jhon","12345", new ArrayList<>()));
			userService.saveUser(new AppUser(null,"Mike" ,"Mike", "12345",new ArrayList<>()));
			userService.saveUser(new AppUser(null,"Jack" ,"Jack","12345", new ArrayList<>()));
			userService.saveUser(new AppUser(null,"Ram" ,"Ram", "12345",new ArrayList<>()));

			userService.addRoleToUser("jhon", "ROLE_USER");
			userService.addRoleToUser("Mike", "ROLE_MANAGER");
			userService.addRoleToUser("Jack", "ROLE_ADMIN");
			userService.addRoleToUser("Ram", "ROLE_DEVELOPER");

		};
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
