package com.italo.pokemonmongo.resources;

import java.net.URI;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.italo.pokemonmongo.domain.Pokemon;
import com.italo.pokemonmongo.resources.util.URL;
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
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pokemon> findById(@PathVariable String id) {
		Pokemon obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Pokemon> insert(@RequestBody Pokemon obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	// /pokemons/fullsearch?text=pikachu
	@GetMapping("/fullsearch")
	public ResponseEntity<List<Pokemon>> fullSearch(@RequestParam(value = "text", defaultValue = "") String text) {
		text = URL.decodeParam(text);
		List<Pokemon> list = service.fullSearch(text);
		return ResponseEntity.ok().body(list);
	}
}
