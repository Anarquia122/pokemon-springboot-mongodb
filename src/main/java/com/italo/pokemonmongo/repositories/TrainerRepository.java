package com.italo.pokemonmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.italo.pokemonmongo.domain.Trainer;

@Repository
public interface TrainerRepository extends MongoRepository<Trainer, String> {

}
