package com.prep.crudrest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prep.crudrest.model.Player;
import com.prep.crudrest.model.Sports;
import com.prep.crudrest.repository.SportRepository;
import com.prep.crudrest.repository.playerRepo;

@Service
public class crudService {
@Autowired 
private playerRepo repository;
@Autowired 
private SportRepository repository2 ;
public Player createsplayer(Player player) {
	repository.save(player);
	return player;
	
}
public List<Player> retrieveallplayers(Player plyr) {
	
	List<Player> findAll = (List<Player>) repository.findAll();

	if (!findAll.iterator().hasNext()) {
		return null;
	}
	List<Player> returned=new ArrayList<>();
	for(Player ply:returned) {
		returned.add(ply);
		
	}
	return findAll;

}
public List<Player> retrieveallplayerByName(String name) {
	Player findbyname=repository.getAllPlayersByName(name).get(0);
	List<Player> list=new ArrayList<>();
	list.add(findbyname);
	return list;
	
	
	}

public List<Player> retrieveallplayerByNameAndByDepartment(String name,String department) {
	List<Player> list =new ArrayList<>();
	List<Player> findbynameanddepartment=repository.findByNameAndDepartment(name, department);
	
	  findbynameanddepartment.forEach(player ->{
		  Player plyr= new Player();
	  BeanUtils.copyProperties(player,plyr);
	  list.add(plyr);
	  });
	  
	return findbynameanddepartment;
	
	
	}
public void deleteById(Integer id) {
	if(id==null) {
		return;
	}
	repository.deleteById(id);
}

public void deleteByName(String name) {
	if(name==null) {
		return;
	}
	repository.deleteByName(name);
}

public void update(Player plyr) {

       repository.save(plyr);
}
public Optional<Player> findById(int id){
Optional<Player> list	=repository.findById(id);
	return list;
	
}
}