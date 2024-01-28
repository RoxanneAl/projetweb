package com.meteo.projet_meteo;

import com.meteo.projet_meteo.model.Users;
import com.meteo.projet_meteo.output.repository.IUserRepository;
import com.meteo.projet_meteo.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@SpringBootApplication
public  class ProjetMeteoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetMeteoApplication.class, args);





	}


	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
/*
	@Autowired
	UserService userService;
	@Autowired
	IUserRepository userRepository;

	@Override

	public void run(String... args) throws Exception {

			// Vérifie si l'utilisateur admin existe déjà
			Optional<Users> adminOpt = userRepository.findByName("admin");

			if (adminOpt.isEmpty()) {
				// L'admin n'existe pas, donc on le crée
				Users adminUser = new Users("admin", "admin");
				userService.addUser(adminUser);
				System.out.println("Admin user created.");
			} else {
				// L'admin existe déjà, pas besoin de le créer
				System.out.println("Admin user already exists.");
			}

	}
*/
}
