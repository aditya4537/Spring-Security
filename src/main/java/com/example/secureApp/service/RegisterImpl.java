package com.example.secureApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.secureApp.entity.User;
import com.example.secureApp.repository.UserRepo;

@Service
public class RegisterImpl implements UserInterface {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public void addUser(User user) {
		User u = user;
		
		String password = new BCryptPasswordEncoder().encode(user.getPassword());
		u.setPassword(password);
		
		userRepo.save(u);
	}
	
}
