package com.learn.restfulwebservices.restful_webservice.user.jpa;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
import com.learn.restfulwebservices.restful_webservice.user.Post;
import com.learn.restfulwebservices.restful_webservice.user.User;
import com.learn.restfulwebservices.restful_webservice.user.UserDao;

@RestController
public class UserJPAController {

	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@GetMapping(path = "/jpa/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@PostMapping(path = "/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User newUser = userRepository.save(user);
		
		URI uri = ServletUriComponentsBuilder.
				fromCurrentRequest().
				path("/{id}").
				buildAndExpand(newUser.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(path = "/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
	}
	
	@GetMapping(path = "/jpa/users/{id}")
	public EntityModel<User> getUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent()) 
			throw new UserNotFoundException(String.format("id-%s", id));
			
		EntityModel<User> resource = EntityModel.of(user.get());
		WebMvcLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).getAllUsers());
		//WebMvcLinkBuilder linkDel = linkTo(methodOn(this.getClass(), getAllUsers()));
		resource.add(linkTo.withRel("all-users"));
		//.add(linkDel.withRel("delete-users"));
		
		
		return resource;
	}
	
	@PostMapping(path = "/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id ,@RequestBody Post post) {
		Optional<User> userOptional = userRepository.findById(id);
		
		if(!userOptional.isPresent()) 
			throw new UserNotFoundException(String.format("id-%s", id));
		
		User user = userOptional.get();
		post.setUser(user);
		
		postRepository.save(post);
		
		URI uri = ServletUriComponentsBuilder.
				fromCurrentRequest().
				path("/{id}").
				buildAndExpand(post.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@GetMapping(path = "/jpa/users/{id}/posts")
	public List<Post> getAllPosts(@PathVariable int id){
		Optional<User> userOptional = userRepository.findById(id);
		if(!userOptional.isPresent())
			throw new UserNotFoundException(String.format("id-%s",id));
		
		return userOptional.get().getPost();
		
	}
}
