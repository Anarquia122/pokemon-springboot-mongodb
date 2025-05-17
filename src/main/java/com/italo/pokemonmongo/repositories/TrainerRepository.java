package com.italo.pokemonmongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.italo.pokemonmongo.domain.Trainer;

@Repository
public interface TrainerRepository extends MongoRepository<Trainer, String> {

	@Query("{ 'name': { $regex: ?0, $options: 'i' } }")
	List<Trainer> fullSearch(String text);
}
