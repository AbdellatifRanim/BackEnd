package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.User;


public interface UserIService {
	public List<User> getUsers();
	public User addUser(User user);
	public Optional<User> getUserBymailandpwd(String mail,String pwd);
	public User updateUser(Long idUSer,User updatedUser);
	
}
