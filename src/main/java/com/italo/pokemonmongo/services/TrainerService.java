package com.italo.pokemonmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.italo.pokemonmongo.domain.Trainer;
import com.italo.pokemonmongo.dto.CapturedDTO;
import com.italo.pokemonmongo.repositories.TrainerRepository;
import com.italo.pokemonmongo.services.exceptions.NumbersExceededException;
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
		return obj.orElseThrow(() -> new ObjectNotFoundException("Treinador não encontrado."));
	}
	
	public Trainer insert(Trainer obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public Trainer update(Trainer obj) {
		Trainer newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Trainer newObj, Trainer obj) {
		newObj.setName(obj.getName());
		newObj.setAge(obj.getAge());
	}
	
	public Trainer addToTeam(Trainer obj, CapturedDTO objDto) {
		obj.getTeam().add(objDto);
		if (obj.getTeam().size() > 6) {
			throw new NumbersExceededException("Trainer can't have more than 6 pokemons in the team");
		}
		return repo.save(obj);
	}
	
	public Trainer removeFromTeam(String id, String name) {
		Trainer obj = findById(id);
		List<CapturedDTO> list = obj.getTeam();
		removeByName(list, name);
		obj.setTeam(list);
		return repo.save(obj);
	}

	private void removeByName(List<CapturedDTO> list, String name) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equalsIgnoreCase(name)) {
				list.remove(i);
			}
		}
	}
}
