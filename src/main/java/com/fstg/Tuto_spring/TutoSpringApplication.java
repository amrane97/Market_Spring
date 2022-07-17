package com.fstg.Tuto_spring;

import com.fstg.Tuto_spring.models.ClientEntity;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TutoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutoSpringApplication.class, args);

		// constructeurs, getters et setters generer par lombok
		//ClientEntity client1 = new ClientEntity();
	}
	@Bean // cette methode retourne un bean qui est gerer par spring il suffit juste de l'injecter dans l'endroit ou on desir 'utilisé
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
