package com.globant.players.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "players")
public class PlayerEntity {

	@Id
	private Long id;

	@NotEmpty(message = "must not be empty")
	@NotNull(message = "must not be null")
	private String fullname;

	@NotNull(message = "must not be null")
	private int age;

	@NotEmpty(message = "must not be empty")
	@NotNull(message = "must not be null")
	private String nationality;

	private String team;

	public PlayerEntity() {
		super();
	}

	public PlayerEntity(Long id, String fullname, int age, String nationality, String team) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.age = age;
		this.nationality = nationality;
		this.team = team;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

}
