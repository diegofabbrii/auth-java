package com.diegofabbrii.authentication.application.controllers.auth;

import com.diegofabbrii.authentication.domain.dtos.auth.SignInRequestDTO;
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
	public ResponseEntity<SuccessMessageDTO> signUp(@RequestBody SignUpRequestDTO body) {
		_authService.signUp(body);
		
		SuccessMessageDTO responseSuccess = new SuccessMessageDTO("Usuário criado!");
		
		return ResponseEntity
			.ok()
			.body(responseSuccess);
	}
	
	@PostMapping("sign-in")
	public ResponseEntity<SuccessMessageDTO> signIn(@RequestBody SignInRequestDTO body) {
		_authService.signIn(body);
		
		SuccessMessageDTO responseSuccess = new SuccessMessageDTO("Usuário fez login!");
		
		return ResponseEntity
			.ok()
			.body(responseSuccess);
	}
}
