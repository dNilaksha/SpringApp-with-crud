package com.dilshan.springdemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dilshan.springdemo.Modal.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
