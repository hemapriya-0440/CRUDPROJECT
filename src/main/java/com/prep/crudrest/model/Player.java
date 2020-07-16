package com.prep.crudrest.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Player {
	@Id
	@GeneratedValue
	private Integer playerId;
	public Player() {
	
	}
	@Size(min = 5,message = "should be valid")
	@Size(min=3)
	private String name;
	@Size(min = 5,message = "should be valid")
	private String department;
	@OneToMany(mappedBy = "player")
	private List<Sports> sports;
	public Integer getPlayerId() {
		return playerId;
	}
	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Player(Integer playerId, String name, String department) {
		super();
		this.playerId = playerId;
		this.name = name;
		this.department = department;
	}
	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", name=" + name + ", department=" + department + ", sports=" + sports
				+ "]";
	}

}
