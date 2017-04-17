package hu.me.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.me.entity.UserEntity;
import hu.me.exception.AdminUserNotAllow;
import hu.me.model.User;
import hu.me.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping(path="", produces=MediaType.APPLICATION_JSON_VALUE)
	Iterable<UserEntity> list() {
		return userService.listAllUser();
	}
	
	@PostMapping(path="", consumes=MediaType.APPLICATION_JSON_VALUE)
	void createNew(@RequestBody UserEntity newUser) {
		if(newUser.getFirstname().toUpperCase().equals("ADMIN")) {
			throw new AdminUserNotAllow();
		}
		userService.newUser(newUser);
	}
	
	@PutMapping(path="", consumes=MediaType.APPLICATION_JSON_VALUE)
	void updateExisting(@RequestBody UserEntity newUser) {
		if(newUser.getFirstname().toUpperCase().equals("ADMIN")) {
			throw new AdminUserNotAllow();
		}
		userService.updateUser(newUser);
	}
	
	@GetMapping(path="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public UserEntity getById(@PathVariable("id") long id) {
		return userService.getById(id);
	}
	
	@DeleteMapping(path="/{id}")
	void deleteExisting(@PathVariable("id") long id) {
		userService.deleteUser(id);
	}
}
