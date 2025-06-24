package com.diegofabbrii.authentication.domain.exceptions.auth;

public class AccountNotRegisteredException extends RuntimeException {

	public AccountNotRegisteredException() {
		super("Conta não criada!");
	}
	
	public AccountNotRegisteredException(String message) {
		super(message);
	}

}
