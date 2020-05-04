package com.example.wallet.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccountException extends Exception {

	private static final long serialVersionUID = -4005267182579342970L;

	public AccountException() {

	}

	public AccountException(String message) {
		super(message);

	}

	public AccountException(Throwable cause) {
		super(cause);

	}

	public AccountException(String message, Throwable cause) {
		super(message, cause);

	}

	public AccountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
