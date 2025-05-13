package com.italo.pokemonmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.italo.pokemonmongo.domain.Trainer;
import com.italo.pokemonmongo.services.TrainerService;

@RestController
@RequestMapping(value = "/trainers")
public class TrainerResource {

	@Autowired
	private TrainerService service;
	
	@GetMapping
	public ResponseEntity<List<Trainer>> findAll() {
		List<Trainer> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
