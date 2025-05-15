package com.italo.pokemonmongo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.italo.pokemonmongo.dto.CapturedDTO;

@Document(collection = "trainer")
public class Trainer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String name;
	private Integer age;
	
	private List<CapturedDTO> team = new ArrayList<>();
	
	public Trainer() {}
	public Trainer(String id, String name, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public List<CapturedDTO> getTeam() {
		return team;
	}
	public void setTeam(List<CapturedDTO> team) {
		this.team = team;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trainer other = (Trainer) obj;
		return Objects.equals(id, other.id);
	}
}
