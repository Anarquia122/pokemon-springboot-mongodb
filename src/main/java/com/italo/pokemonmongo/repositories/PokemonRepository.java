package com.italo.pokemonmongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.italo.pokemonmongo.domain.Pokemon;

@Repository
public interface PokemonRepository extends MongoRepository<Pokemon, String> {

	@Query("{ $or: [ { 'name': { $regex: ?0, $options: 'i' } }, { 'types': { $regex: ?0, $options: 'i' } } ] }")
	List<Pokemon> fullSearch(String text);
}
