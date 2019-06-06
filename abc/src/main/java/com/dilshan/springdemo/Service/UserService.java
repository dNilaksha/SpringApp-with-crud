package com.dilshan.springdemo.Service;

import java.util.List;
import java.util.Optional;

import com.dilshan.springdemo.Modal.User;

public interface UserService {
	
List<User> findAllUser();

User saveUser(User userdata);

User updateUser(Integer id,User newUserData);

User findById(Integer id);

void deleteId(Integer id);

void deleteAllUsers();


}
