package com.diegofabbrii.authentication.domain.services.impl.auth;

import com.diegofabbrii.authentication.domain.exceptions.auth.AuthenticationFailedException;
import com.diegofabbrii.authentication.infra.data.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	private final UserRepository _userRepository;
	
	public CustomUserDetailsService(UserRepository userRepository) {
		_userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		return _userRepository.findByUsername(username)
			.orElseThrow(AuthenticationFailedException::new);
	}
	
}
