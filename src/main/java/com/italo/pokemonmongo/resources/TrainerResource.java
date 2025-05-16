package com.italo.pokemonmongo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.italo.pokemonmongo.domain.Pokemon;
import com.italo.pokemonmongo.domain.Trainer;
import com.italo.pokemonmongo.dto.CapturedDTO;
import com.italo.pokemonmongo.dto.TrainerDTO;
import com.italo.pokemonmongo.services.PokemonService;
import com.italo.pokemonmongo.services.TrainerService;

@RestController
@RequestMapping(value = "/trainers")
public class TrainerResource {

	@Autowired
	private TrainerService service;
	
	@Autowired
	private PokemonService pokemonService;
	
	@GetMapping
	public ResponseEntity<List<Trainer>> findAll() {
		List<Trainer> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Trainer> findById(@PathVariable String id) {
		Trainer obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Trainer> insert(@RequestBody Trainer obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody Trainer obj) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{id}/team")
	public ResponseEntity<List<CapturedDTO>> findTeam(@PathVariable String id) {
		Trainer obj = service.findById(id);
		return ResponseEntity.ok().body(obj.getTeam());
	}
	
	@PutMapping(value = "/{id}/team")
	public ResponseEntity<Void> addToTeam(@PathVariable String id, @RequestBody Pokemon obj) {
		Trainer trainerObj = service.findById(id);
		CapturedDTO objDto = new CapturedDTO(pokemonService.findById(obj.getId()), new TrainerDTO(trainerObj));
		trainerObj = service.addToTeam(trainerObj, objDto);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}/team/{name}")
	public ResponseEntity<Void> removeFromTeam(@PathVariable String id, @PathVariable String name) {
		Trainer obj = service.findById(id);
		obj = service.removeFromTeam(id, name);
		return ResponseEntity.noContent().build();
	}
}
