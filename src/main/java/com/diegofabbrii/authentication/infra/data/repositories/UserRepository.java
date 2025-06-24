package com.diegofabbrii.authentication.infra.data.repositories;

import com.diegofabbrii.authentication.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
	
	Optional<User> findByEmail(String email);
	Optional<User> findByUsername(String username);
	
}
