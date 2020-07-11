package com.prep.crudrest.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.prep.crudrest.model.Player;
import com.prep.crudrest.service.crudService;

@RestController
public class controller {
	@Autowired
	private crudService service;
	
@RequestMapping(value="/players",method=RequestMethod.POST)
public ResponseEntity<Player> createPlayer(@Valid@RequestBody Player player) {
	Player created = service.createsplayer(player);
	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(created.getPlayerId()).toUri();
	return ResponseEntity.created(location).build();
}
@RequestMapping(value="/players",method=RequestMethod.GET)
public ResponseEntity<Object> getAllPlayers(Player ply){
		List<Player> returned = service.retrieveallplayers(ply);
	if(returned.isEmpty()||returned==null) {
		return ResponseEntity.noContent().build();
	    
	}
	return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(returned);
	}

@RequestMapping(value="/players/{name}",method=RequestMethod.GET)
public ResponseEntity<List<Player>> getallByName(@PathVariable String name){
	List<Player> list= new ArrayList<>();
	Player plyr=new Player();
	list.add(plyr);
	List<Player> returns=service.retrieveallplayerByName(name);

return new ResponseEntity<List<Player>>(returns, HttpStatus.OK);

}
@RequestMapping(value="/players/{name}/{department}",method=RequestMethod.GET)
public ResponseEntity<List<Player>> getallByNameandDepAartment(@PathVariable String name,@PathVariable String department){
	List<Player> lit= new ArrayList<>();
	Player rply=new Player();
	lit.add(rply);
	List<Player> returns=service.retrieveallplayerByNameAndByDepartment(name, department);
return new ResponseEntity<List<Player>>(returns, HttpStatus.OK);
}
@RequestMapping(value="/players/name/department",method=RequestMethod.POST)
public ResponseEntity<List<Player>> getallByNameandDepAartment1(@RequestBody List<Player> player){
	Player play=new Player();
	List<Player> list=new ArrayList<>();
	list.add(play);
	list=service.retrieveallplayerByNameAndByDepartment(player.get(0).getName(),player.get(0).getDepartment());
return new ResponseEntity<>(list, HttpStatus.OK);
}
@RequestMapping(value="/players/{id}",method=RequestMethod.DELETE)
public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
	try {
		service.deleteById(id);
		  return ResponseEntity.noContent().build();
		 } catch (Exception e) {
		  return ResponseEntity.notFound().build();
		 }
}
@RequestMapping(value="/players/name",method=RequestMethod.DELETE)
public ResponseEntity<Void> deleteByName(@RequestParam(value="name")String  name) {
	try {
		service.deleteByName(name);
		  return ResponseEntity.noContent().build();
		 } catch (Exception e) {
		  return ResponseEntity.notFound().build();
		 }
}

	@RequestMapping(value="/players",method=RequestMethod.PUT
			)
	public ResponseEntity<Player> updateArticle(@RequestBody Player Plyr) {
		service.update(Plyr);
		return new ResponseEntity<Player>(Plyr, HttpStatus.OK);
	}
}