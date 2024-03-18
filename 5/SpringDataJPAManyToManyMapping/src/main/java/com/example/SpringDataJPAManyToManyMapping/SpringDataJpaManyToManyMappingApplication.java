package com.example.SpringDataJPAManyToManyMapping;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.SpringDataJPAManyToManyMapping.entity.Actor;
import com.example.SpringDataJPAManyToManyMapping.entity.Movie;
import com.example.SpringDataJPAManyToManyMapping.service.TheaterService;

@SpringBootApplication
public class SpringDataJpaManyToManyMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaManyToManyMappingApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(TheaterService service) {
		return (args)->{
			try {
				Actor actor1= new Actor("Daniel Radcliffe");
				Actor actor2= new Actor("Rupart Grint");
				
				Movie avengers = new Movie("Harry Potter 1");
				avengers.addActor(actor1);
				avengers.addActor(actor2);
				
				Movie infinityWar = new Movie("Harry Potter 2");
				infinityWar.addActor(actor1);
				infinityWar.addActor(actor2);
				
				service.saveMovie(avengers);
				service.saveMovie(infinityWar);
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
	}

}
