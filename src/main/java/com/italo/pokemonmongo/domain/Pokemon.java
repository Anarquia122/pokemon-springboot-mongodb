package com.italo.pokemonmongo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.italo.pokemonmongo.services.exceptions.NumbersExceededException;

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
	public void setTypes(List<String> types) {
		this.types = types;
	}
	public List<String> getAttacks() {
		return attacks;
	}
	public void setAttacks(List<String> attacks) {
		this.attacks = attacks;
	}
	public List<String> getWeaks() {
		return weaks;
	}
	public void setWeaks(List<String> weaks) {
		this.weaks = weaks;
	}
	public List<String> getResistences() {
		return resistences;
	}
	public void setResistences(List<String> resistences) {
		this.resistences = resistences;
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
