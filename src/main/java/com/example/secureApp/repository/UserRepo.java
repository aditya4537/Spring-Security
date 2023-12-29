package com.example.secureApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.secureApp.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
