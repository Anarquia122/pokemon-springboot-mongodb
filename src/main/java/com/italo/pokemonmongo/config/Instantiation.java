package com.italo.pokemonmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.italo.pokemonmongo.domain.Pokemon;
import com.italo.pokemonmongo.domain.Trainer;
import com.italo.pokemonmongo.dto.CapturedDTO;
import com.italo.pokemonmongo.dto.TrainerDTO;
import com.italo.pokemonmongo.repositories.PokemonRepository;
import com.italo.pokemonmongo.repositories.TrainerRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private TrainerRepository trainerRepo;
	
	@Autowired
	private PokemonRepository pokemonRepo;
	
	@Override
	public void run(String... args) throws Exception {
		/*
		trainerRepo.deleteAll();
		pokemonRepo.deleteAll();
		
		Pokemon p1 = new Pokemon(null, 6, "Charizard", Arrays.asList("Fire", "Flying"),
				Arrays.asList("Flame Trhower", "Thunder Claw"),
				Arrays.asList("Water"),
				Arrays.asList("Grass"));
		Pokemon p2 = new Pokemon(null, 3, "Venusaur", Arrays.asList("Grass", "Poison"),
				Arrays.asList("Solar Beam", "Vine Whip"),
				Arrays.asList("Fire"),
				Arrays.asList("Water"));
		Pokemon p3 = new Pokemon(null, 9, "Blastoise", Arrays.asList("Water"),
				Arrays.asList("Water Gun", "Flash Cannon"),
				Arrays.asList("Grass"),
				Arrays.asList("Fire"));
		Pokemon p4 = new Pokemon(null, 25, "Pikachu", Arrays.asList("Eletric"),
				Arrays.asList("Thunder Bolt", "Iron Tail"),
				Arrays.asList("Ground"),
				Arrays.asList("Flying", "Steel", "Eletric"));
		
		pokemonRepo.saveAll(Arrays.asList(p1, p2, p3, p4));
		
		Trainer t1 = new Trainer(null, "Ash", 10);
		Trainer t2 = new Trainer(null, "Misty", 10);
		Trainer t3 = new Trainer(null, "Brock", 13);
		
		CapturedDTO captured1 = new CapturedDTO(p1, new TrainerDTO(t1));
		CapturedDTO captured2 = new CapturedDTO(p3, new TrainerDTO(t2));
		CapturedDTO captured3 = new CapturedDTO(p2, new TrainerDTO(t3));
		CapturedDTO captured4 = new CapturedDTO(p4, new TrainerDTO(t1));

		t1.getTeam().addAll(Arrays.asList(captured1, captured4));
		t2.getTeam().addAll(Arrays.asList(captured2));
		t3.getTeam().addAll(Arrays.asList(captured3));

		trainerRepo.saveAll(Arrays.asList(t1, t2, t3));
		*/
	}

}
