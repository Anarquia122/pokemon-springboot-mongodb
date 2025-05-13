package com.italo.pokemonmongo.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.italo.pokemonmongo.domain.Trainer;
import com.italo.pokemonmongo.repositories.TrainerRepository;

@Service
public class TrainerService {

	@Autowired
	private TrainerRepository repo;
	
	public List<Trainer> findAll() {
		Trainer t1 = new Trainer("1", "Ash", 10);
		Trainer t2 = new Trainer("2", "Misty", 10);
		Trainer t3 = new Trainer("3", "Brock", 10);

		return Arrays.asList(t1, t2, t3);
	}
}
