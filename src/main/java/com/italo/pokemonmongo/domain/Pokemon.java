package com.italo.pokemonmongo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.italo.pokemonmongo.domain.exceptions.NumbersExceededException;

@Document
public class Pokemon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	@Indexed(direction = IndexDirection.ASCENDING)
	private Integer pokedexNumber;
	private String name;
	private List<String> types = new ArrayList<>();
	private List<String> attacks = new ArrayList<>();
	private List<String> weaks = new ArrayList<>();
	private List<String> resistences = new ArrayList<>();
	
	public Pokemon() {}
	public Pokemon(String id, Integer pokedexNumber, String name, List<String> types, List<String> attacks, List<String> weaks, List<String> resistences) {
		super();
		this.id = id;
		this.pokedexNumber = pokedexNumber;
		this.name = name;
		this.types = types;
		this.attacks = attacks;
		this.weaks = weaks;
		this.resistences = resistences;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getPokedexNumber() {
		return pokedexNumber;
	}
	public void setPokedexNumber(Integer pokedexNumber) {
		this.pokedexNumber = pokedexNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getTypes() {
		return types;
	}
	public List<String> getAttacks() {
		return attacks;
	}
	public List<String> getWeaks() {
		return weaks;
	}
	public List<String> getResistence() {
		return resistences;
	}
	public void addType(List<String> list) {
		if (list.size() > 2) {
			throw new NumbersExceededException("Pokemons have at most two different types");
		} else if (repeatedObjs(list)) {
			throw new IllegalArgumentException("Pokemons can't have two of the same type");
		}
		types.addAll(list);
	}
	public void addAttacks(List<String> list) {
		if (list.size() > 4) {
			throw new NumbersExceededException("Pokemons have at most four different attacks");
		} else if (repeatedObjs(list)) {
			throw new IllegalArgumentException("Pokemons can't have two of the same attack");
		}
		attacks.addAll(list);
	}
	public void addWeaks(List<String> list) {
		if (repeatedObjs(list)) {
			throw new IllegalArgumentException("Pokemons can't have two of the same weak");
		}
		weaks.addAll(list);
	}
	public void addResistence(List<String> list) {
		if (repeatedObjs(list)) {
			throw new IllegalArgumentException("Pokemons can't have two of the same resistence");
		}
		resistences.addAll(list);
	}
	
	private boolean repeatedObjs(List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (j != i && list.get(i) == list.get(j)) {
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, pokedexNumber);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		return Objects.equals(id, other.id) && Objects.equals(pokedexNumber, other.pokedexNumber);
	}
}
