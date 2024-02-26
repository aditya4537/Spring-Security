package com.example.secureApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.secureApp.config.UserPrincipal;
import com.example.secureApp.entity.User;
import com.example.secureApp.repository.UserRepo;

@Service
public class UserService implements UserDetailsService, UserInterface{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new UserPrincipal(user);
	}

	@Override
	public void addUser(User user) {
		User u = user;
		
		String password = new BCryptPasswordEncoder().encode(user.getPassword());
		u.setPassword(password);
		
		userRepo.save(u);
		
	}

	@Override
	public String findUser() {
		return null;
	}
	
	

}
