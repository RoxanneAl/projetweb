package com.meteo.projet_meteo;

import com.meteo.model.User;
import com.meteo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetMeteoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjetMeteoApplication.class, args);

	}


	@Autowired
	IUserService userService;
	@Override
	public void run(String... args) throws Exception {
		User user = new User("admin","password");
		userService.addUser(user);
	}

}
