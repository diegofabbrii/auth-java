package com.diegofabbrii.authentication.domain.exceptions.auth;

public class UserAlreadyExistsException extends RuntimeException{

	public UserAlreadyExistsException() {
		super("Nome de usuário ou e-mail já cadastrados!");
	}

	public UserAlreadyExistsException(String message) {
		super(message);
	}

}
