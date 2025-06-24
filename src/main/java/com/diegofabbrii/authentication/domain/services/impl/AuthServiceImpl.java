package com.diegofabbrii.authentication.domain.services.impl;

import com.diegofabbrii.authentication.domain.dtos.auth.SignUpRequestDTO;
import com.diegofabbrii.authentication.domain.exceptions.auth.UserAlreadyExistsException;
import com.diegofabbrii.authentication.domain.models.User;
import com.diegofabbrii.authentication.domain.services.interfaces.AuthService;
import com.diegofabbrii.authentication.infra.data.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

	private UserRepository _userRepository;

	public AuthServiceImpl(UserRepository userRepository) {
		_userRepository = userRepository;
	}

	public void signUp(SignUpRequestDTO signUpRequestDTO) {
    Optional<User> existedUsername = _userRepository.findByUsername(signUpRequestDTO.username());
		
		if (existedUsername.isPresent())
			throw new UserAlreadyExistsException();

		Optional<User> existedEmail = _userRepository.findByEmail(signUpRequestDTO.email());

		if (existedEmail.isPresent())
			throw new UserAlreadyExistsException();
			
		User createdUser = new User();
		
		createdUser.setUsername(signUpRequestDTO.username());
		createdUser.setEmail(signUpRequestDTO.email());
		createdUser.setPassword(signUpRequestDTO.password());
		
		_userRepository.save(createdUser);
	}

}
