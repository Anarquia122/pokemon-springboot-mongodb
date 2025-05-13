package com.italo.pokemonmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.italo.pokemonmongo.domain.Trainer;
import com.italo.pokemonmongo.repositories.TrainerRepository;
import com.italo.pokemonmongo.services.exceptions.ObjectNotFoundException;

@Service
public class TrainerService {

	@Autowired
	private TrainerRepository repo;
	
	public List<Trainer> findAll() {
		return repo.findAll();
	}
	
	public Trainer findById(String id) {
		Optional<Trainer> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado."));
	}
	
	public Trainer insert(Trainer obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
}
