package com.prep.crudrest.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prep.crudrest.model.Player;

@Repository
public interface playerRepo extends CrudRepository<Player, Integer> {
	public List<Player> getAllPlayersByName(String name);
	public List<Player> findByNameAndDepartment(String name,String department);
	@Transactional
public void deleteByName(String name);
}
