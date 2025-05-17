package com.italo.pokemonmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.italo.pokemonmongo.domain.Pokemon;
import com.italo.pokemonmongo.repositories.PokemonRepository;
import com.italo.pokemonmongo.services.exceptions.NumbersExceededException;
import com.italo.pokemonmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PokemonService {

	@Autowired
	private PokemonRepository repo;
	
	public List<Pokemon> findAll() {
		return repo.findAll();
	}
	
	public Pokemon findById(String id) {
		Optional<Pokemon> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Pokemon não encontrado."));
	}
	
	public List<Pokemon> fullSearch(String text) {
		return repo.fullSearch(text);
	}
	
	public Pokemon insert(Pokemon obj) {
		testingPokemon(obj);
		return repo.insert(obj);
	}
	
	private void testingPokemon(Pokemon obj) {
		testingTypes(obj.getTypes());
		testingAttacks(obj.getAttacks());
		testingWeaks(obj.getWeaks());
		testingResistences(obj.getResistences());
	}

	private void testingResistences(List<String> list) {
		if (repeatedObjs(list)) {
			throw new IllegalArgumentException("Pokemons can't have two of the same resistence");
		}
	}

	private void testingWeaks(List<String> list) {
		if (repeatedObjs(list)) {
			throw new IllegalArgumentException("Pokemons can't have two of the same weak");
		}
	}

	private void testingAttacks(List<String> list) {
		if (list.size() > 4) {
			throw new NumbersExceededException("Pokemons have at most four different attacks");
		} else if (repeatedObjs(list)) {
			throw new IllegalArgumentException("Pokemons can't have two of the same attack");
		}
	}

	private void testingTypes(List<String> list) {
		if (list.size() > 2) {
			throw new NumbersExceededException("Pokemons have at most two different types");
		} else if (repeatedObjs(list)) {
			throw new IllegalArgumentException("Pokemons can't have two of the same type");
		}
	}

	private boolean repeatedObjs(List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (j != i && list.get(i).equalsIgnoreCase(list.get(j))) {
					return true;
				}
			}
		}
		return false;
	}
}
