package com.italo.pokemonmongo.dto;

import java.io.Serializable;
import java.util.List;

import com.italo.pokemonmongo.domain.Pokemon;

public class CapturedDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer pokedexNumber;
	private String name;
	private List<String> types;
	private List<String> attacks;
	private TrainerDTO trainer;
	
	public CapturedDTO() {}
	public CapturedDTO(Pokemon obj, TrainerDTO trainer) {
		super();
		pokedexNumber = obj.getPokedexNumber();
		name = obj.getName();
		types = obj.getTypes();
		attacks = obj.getAttacks();
		this.trainer = trainer;
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
}
