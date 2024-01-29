package com.meteo.projet_meteo;


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


	@Override

	public void run(String... args) throws Exception {



	}
*/
}
