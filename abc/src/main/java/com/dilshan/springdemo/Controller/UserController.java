package com.dilshan.springdemo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dilshan.springdemo.Modal.User;
import com.dilshan.springdemo.Service.UserService;

@RestController
@RequestMapping("/all")
public class UserController {
	
	@Autowired
	UserService serviceImpl;

	@GetMapping("/user")
	public List<User> name() {
		
		return serviceImpl.findAllUser();
	}
	@PostMapping("/add")
	public User saveUsers(@RequestBody User userdata) {
		
		return serviceImpl.saveUser(userdata);
	}
	@PutMapping("/update/{id}")
	public User updateUser(@PathVariable Integer id,@RequestBody User newUserData) {
		return serviceImpl.updateUser(id,newUserData);
		
	}
	@GetMapping("/find/{id}")
	public User getUserById(@PathVariable Integer id) {
		
		return serviceImpl.findById(id);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable Integer id) {
		
		serviceImpl.deleteId(id);
	}
	@DeleteMapping("/deleteall")
	public void deleteAllUsers() {
		
		serviceImpl.deleteAllUsers();
	}

}
