package com.diegofabbrii.authentication.domain.services.impl;

import com.diegofabbrii.authentication.domain.dtos.auth.SignInRequestDTO;
import com.diegofabbrii.authentication.domain.dtos.auth.SignInResponseDTO;
import com.diegofabbrii.authentication.domain.dtos.auth.SignUpRequestDTO;
import com.diegofabbrii.authentication.domain.dtos.user.UserDTO;
import com.diegofabbrii.authentication.domain.enums.UserRoleEnum;
import com.diegofabbrii.authentication.domain.exceptions.auth.UserAlreadyExistsException;
import com.diegofabbrii.authentication.domain.models.User;
import com.diegofabbrii.authentication.domain.services.interfaces.AuthService;
import com.diegofabbrii.authentication.infra.data.repositories.UserRepository;
import com.diegofabbrii.authentication.infra.jwt.JwtTokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

	private final UserRepository _userRepository;
	private final AuthenticationManager _authenticationManager;
	private final JwtTokenService _jwtTokenService;

	public AuthServiceImpl(
			UserRepository userRepository,
			AuthenticationManager authenticationManager,
			JwtTokenService jwtTokenService
	) {
		_userRepository = userRepository;
		_authenticationManager = authenticationManager;
		_jwtTokenService = jwtTokenService;
	}

	@Override
	public void signUp(SignUpRequestDTO signUpRequestDTO) {
    Optional<User> existedUsername = _userRepository.findByUsername(signUpRequestDTO.username());
		
		if (existedUsername.isPresent())
			throw new UserAlreadyExistsException();

		Optional<User> existedEmail = _userRepository.findByEmail(signUpRequestDTO.email());

		if (existedEmail.isPresent())
			throw new UserAlreadyExistsException();
			
		String passwordHash = new BCryptPasswordEncoder()
			.encode(signUpRequestDTO.password());
		
		User createdUser = new User();
		
		createdUser.setUsername(signUpRequestDTO.username());
		createdUser.setEmail(signUpRequestDTO.email());
		createdUser.setPassword(passwordHash);
		createdUser.setRole(UserRoleEnum.USER);
		
		_userRepository.save(createdUser);
	}
	
	@Override
	public SignInResponseDTO signIn(SignInRequestDTO signInRequestDTO) {
		var usernamePassowrd = new UsernamePasswordAuthenticationToken(
			signInRequestDTO.username(),
			signInRequestDTO.password()
		);
		
		var auth = _authenticationManager.authenticate(usernamePassowrd);
		
		String token = _jwtTokenService.generatetoken((User) auth.getPrincipal());
		
		SignInResponseDTO response = new SignInResponseDTO(
			token,
			new UserDTO(
				((User) auth.getPrincipal()).getId(),
				((User) auth.getPrincipal()).getUsername(),
				((User) auth.getPrincipal()).getEmail(),
				((User) auth.getPrincipal()).getRole()
		  )
		);
		
		return response;
	}
	
}
