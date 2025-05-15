package com.italo.pokemonmongo.resources;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.italo.pokemonmongo.domain.Pokemon;
import com.italo.pokemonmongo.services.PokemonService;

@RestController
@RequestMapping(value = "/pokemons")
public class PokemonResource {

	@Autowired
	private PokemonService service;
	
	@GetMapping
	public ResponseEntity<List<Pokemon>> findAll() {
		List<Pokemon> list = service.findAll();
		List<Pokemon> orderedList = list.stream().sorted(Comparator.comparingInt(Pokemon::getPokedexNumber)).collect(Collectors.toList());
		return ResponseEntity.ok().body(orderedList);
	}
}
