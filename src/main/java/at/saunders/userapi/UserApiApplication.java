package at.saunders.userapi;

import at.saunders.userapi.user.User;
import at.saunders.userapi.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class UserApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApiApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserService userService) {
		return args -> {
			Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
				User user = new User(name.toLowerCase(), name, name.toLowerCase() + "@domain.com");
				userService.save(user);
			});
			userService.findAll().forEach(System.out::println);
		};
	}

}
