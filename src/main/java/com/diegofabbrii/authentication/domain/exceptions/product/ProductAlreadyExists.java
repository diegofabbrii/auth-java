package com.diegofabbrii.authentication.domain.exceptions.product;

public class ProductAlreadyExists extends RuntimeException {
	
	public ProductAlreadyExists() {
		super("Este produto já está cadastrado");
	}
	
	public ProductAlreadyExists(String message) {
		super(message);
	}
	
}
