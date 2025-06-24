package com.diegofabbrii.authentication.domain.exceptions.auth;

public class AuthenticationFailedException extends RuntimeException{

	public AuthenticationFailedException() {
		super("Nome de usuário ou senha inválidos!");
	}

	public AuthenticationFailedException(String message) {
		super(message);
	}

}
