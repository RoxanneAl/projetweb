package com.meteo.projet_meteo;

import com.meteo.projet_meteo.model.Users;
import com.meteo.projet_meteo.output.repository.IUserRepository;
import com.meteo.projet_meteo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public  class ProjetMeteoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjetMeteoApplication.class, args);
		Users malo =  new Users("malo","malo");
		UserService userService1 = new UserService();

		IUserRepository malorep = new IUserRepository() {
			@Override
			public <S extends Users> S save(S entity) {
				return null;
			}

			@Override
			public <S extends Users> Iterable<S> saveAll(Iterable<S> entities) {
				return null;
			}

			@Override
			public Optional<Users> findById(Integer integer) {
				return Optional.empty();
			}

			@Override
			public boolean existsById(Integer integer) {
				return false;
			}

			@Override
			public Iterable<Users> findAll() {
				return null;
			}

			@Override
			public Iterable<Users> findAllById(Iterable<Integer> integers) {
				return null;
			}

			@Override
			public long count() {
				return 0;
			}

			@Override
			public void deleteById(Integer integer) {

			}

			@Override
			public void delete(Users entity) {

			}

			@Override
			public void deleteAllById(Iterable<? extends Integer> integers) {

			}

			@Override
			public void deleteAll(Iterable<? extends Users> entities) {

			}

			@Override
			public void deleteAll() {

			}

			@Override
			public Optional<Users> findByName(String name) {
				return Optional.empty();
			}
		};
		userService1.setUserRepository(malorep);
		userService1.addUser(malo);




	}


	@Autowired
	UserService userService;
	@Override
	public void run(String... args) throws Exception {
	}

}
