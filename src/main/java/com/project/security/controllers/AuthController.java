package com.project.security.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.security.dto.request.LoginRequest;
import com.project.security.dto.request.RegisterUserRequest;
import com.project.security.dto.response.LoginResponse;
import com.project.security.dto.response.RegisterUserResponse;
import com.project.security.entities.User;
import com.project.security.repository.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
	private final UserRepository userRepository;
	
	public AuthController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request){
		return null;
	}
	
	public ResponseEntity<RegisterUserResponse> register(@Valid @RequestBody RegisterUserRequest request){
		User newUser = new User();
		
		newUser.setPassword(request.password());
		newUser.setEmail(request.email());
		newUser.setName(request.name());
		
		userRepository.save(newUser);
		
		return ResponseEntity.ok(new RegisterUserResponse(newUser.getName(), newUser.getEmail()))
	}
}
