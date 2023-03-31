package com.cdcb.pruebatecnica1_softlond.exceptions;

public class AccountNotFound extends RuntimeException {
	public AccountNotFound(String message) {
		super(message);
	}
}