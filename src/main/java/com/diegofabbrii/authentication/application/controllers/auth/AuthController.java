package com.diegofabbrii.authentication.application.controllers.auth;

import com.diegofabbrii.authentication.domain.dtos.auth.SignUpRequestDTO;
import com.diegofabbrii.authentication.domain.dtos.success.SuccessMessageDTO;
import com.diegofabbrii.authentication.domain.services.interfaces.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthController {
	private final AuthService _authService;
	
	public AuthController(AuthService authService) {
		_authService = authService;
	}
	
	@PostMapping("sign-up")
	public ResponseEntity<?> signUp(@RequestBody SignUpRequestDTO body) {
		_authService.signUp(body);
		
		return ResponseEntity
			.ok()
			.body(new SuccessMessageDTO("Usuário criado!"));
	}
}
