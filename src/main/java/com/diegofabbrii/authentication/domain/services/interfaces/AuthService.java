package com.diegofabbrii.authentication.domain.services.interfaces;

import com.diegofabbrii.authentication.domain.dtos.auth.SignInRequestDTO;
import com.diegofabbrii.authentication.domain.dtos.auth.SignInResponseDTO;
import com.diegofabbrii.authentication.domain.dtos.auth.SignUpRequestDTO;

public interface AuthService {

	void signUp(SignUpRequestDTO signUpRequestDTO);
	SignInResponseDTO signIn(SignInRequestDTO signInRequestDTO);
	
}
