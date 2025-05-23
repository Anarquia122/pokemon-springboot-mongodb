package com.italo.pokemonmongo.dto;

import java.io.Serializable;

import com.italo.pokemonmongo.domain.Trainer;

public class TrainerDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	
	public TrainerDTO() {}
	public TrainerDTO(Trainer obj) {
		super();
		id = obj.getId();
		name = obj.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
