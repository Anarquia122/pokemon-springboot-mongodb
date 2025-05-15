package com.italo.pokemonmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.italo.pokemonmongo.domain.Pokemon;
import com.italo.pokemonmongo.repositories.PokemonRepository;

@Service
public class PokemonService {

	@Autowired
	private PokemonRepository repo;
	
	public List<Pokemon> findAll() {
		return repo.findAll();
	}
}
