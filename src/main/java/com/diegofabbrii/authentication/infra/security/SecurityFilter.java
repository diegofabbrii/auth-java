package com.diegofabbrii.authentication.infra.security;

import com.diegofabbrii.authentication.infra.data.repositories.UserRepository;
import com.diegofabbrii.authentication.infra.jwt.JwtTokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {
	
	private final JwtTokenService _jwtTokenService;
	private final UserRepository _userRepository;
	
	public SecurityFilter(
		JwtTokenService jwtTokenService,
		UserRepository userRepository
	) {
		_jwtTokenService = jwtTokenService;
		_userRepository = userRepository;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		String token = this.recoveryToken(request);
		
		if (token != null) {
			String subject = _jwtTokenService.validateToken(token);
			
			UserDetails user = _userRepository.findByUsername(subject).get();
			
			var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		
		filterChain.doFilter(request, response);
	}
	
	private String recoveryToken(HttpServletRequest request) {
		String authHeader = request.getHeader("Authorization");
		
		if (authHeader == null) return null;
		
		return authHeader.replace("Bearer ", "");
	}
	
}
