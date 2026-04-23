package com.project.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.project.security.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<UserDetails> findUserByEmail(String userEmail);
}
