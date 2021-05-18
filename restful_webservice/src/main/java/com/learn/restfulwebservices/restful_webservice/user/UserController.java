package com.learn.restfulwebservices.restful_webservice.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.learn.restfulwebservices.restful_webservice.exception.UserIdNotFoundException;
import com.learn.restfulwebservices.restful_webservice.exception.UserNotFoundException;

@RestController
public class UserController {

	
	@Autowired
	private UserDao userDao;
	
	
	@GetMapping(path = "/users")
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
	
	@PostMapping(path = "/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User newUser = userDao.createUser(user);
		
		URI uri = ServletUriComponentsBuilder.
				fromCurrentRequest().
				path("/{id}").
				buildAndExpand(newUser.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(path = "/users/{id}")
	public int deleteUser(@PathVariable int id) {
		int returnValue = userDao.deleteUser(id);
		if(returnValue == -1)
			throw new UserIdNotFoundException(String.format("id-%s", id));
		return returnValue;
	}
	
	@GetMapping(path = "/users/{id}")
	public EntityModel<User> getUser(@PathVariable int id) {
		User user = userDao.getUserDetails(id);
		if(user==null) 
			throw new UserNotFoundException(String.format("id-%s", id));
			
		EntityModel<User> resource = EntityModel.of(user);
		WebMvcLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).getAllUsers());
		//WebMvcLinkBuilder linkDel = linkTo(methodOn(this.getClass(), getAllUsers()));
		resource.add(linkTo.withRel("all-users"));
		//.add(linkDel.withRel("delete-users"));
		
		
		return resource;
	}
}
