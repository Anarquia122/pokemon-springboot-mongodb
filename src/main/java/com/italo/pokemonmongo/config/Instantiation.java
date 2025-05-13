package com.italo.pokemonmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.italo.pokemonmongo.domain.Trainer;
import com.italo.pokemonmongo.repositories.TrainerRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private TrainerRepository trainerRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		trainerRepo.deleteAll();
		
		Trainer t1 = new Trainer(null, "Ash", 10);
		Trainer t2 = new Trainer(null, "Misty", 10);
		Trainer t3 = new Trainer(null, "Brock", 13);
		
		trainerRepo.saveAll(Arrays.asList(t1, t2, t3));

	}

}
