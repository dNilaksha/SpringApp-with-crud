package com.dilshan.springdemo.Service;

import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.buf.UEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dilshan.springdemo.Modal.User;
import com.dilshan.springdemo.Repository.UserRepository;

@Service
public class ServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> findAllUser() {
		
		return userRepository.findAll();
		//retur
	}

	@Override
	public User saveUser(User userdata) {
	
		return userRepository.save(userdata);
		
	}

	@Override
	public User updateUser(Integer id, User newUserData) {
		Optional<User> op=userRepository.findById(id);
		if(op.isPresent()) {
		 User user=op.get();
		 
			user.setName(newUserData.getName());
			user.setAge(newUserData.getAge());
			user.setEmail(newUserData.getEmail());
			
			return userRepository.save(user);
		}
		return null;
	}

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
	Optional<User> optional = userRepository.findById(id);
	return optional.get();
	}

	@Override
	public void deleteId(Integer id) {
		boolean result=userRepository.existsById(id);
		if(result) {
		userRepository.deleteById(id);
			
		}
		
		

	}

	@Override
	public void deleteAllUsers() {
		List<User> user=userRepository.findAll();
		if(user.isEmpty()) {
			
			System.out.println("No data to delete");
		}else {
			
			userRepository.deleteAll();
		}
		
	}

	

}
