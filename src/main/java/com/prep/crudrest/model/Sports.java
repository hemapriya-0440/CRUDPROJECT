package com.prep.crudrest.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Sports {
	@Id 
	@GeneratedValue
private Integer id;
private String name;
@ManyToOne(fetch=FetchType.LAZY)
@JsonIgnore
private Player player;

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

@Override
public String toString() {
	return "Sports [id=" + id + ", name=" + name + "]";
}
public Sports(Integer id, String name, Player player) {
	super();
	this.id = id;
	this.name = name;
	this.player = player;
}

}
