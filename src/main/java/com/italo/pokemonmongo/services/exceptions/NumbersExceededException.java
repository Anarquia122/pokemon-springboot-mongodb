package com.italo.pokemonmongo.services.exceptions;

public class NumbersExceededException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NumbersExceededException(String msg) {
		super(msg);
	}
}
