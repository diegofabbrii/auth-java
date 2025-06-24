package com.diegofabbrii.authentication.infra.exceptionHandler;

import com.diegofabbrii.authentication.domain.dtos.errors.ErrorMessageDTO;
import com.diegofabbrii.authentication.domain.exceptions.auth.AccountNotRegisteredException;
import com.diegofabbrii.authentication.domain.exceptions.auth.AuthenticationFailedException;
import com.diegofabbrii.authentication.domain.exceptions.auth.UserAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<?> userAlreadyExistsHandler(UserAlreadyExistsException exception) {
		ErrorMessageDTO responseError = new ErrorMessageDTO(
			400,
			exception.getMessage()
		);
		
		return ResponseEntity
			.status(HttpStatus.BAD_REQUEST)
			.body(responseError);
	}

	@ExceptionHandler(AuthenticationFailedException.class)
	public ResponseEntity<?> authenticationFailedHandler(AuthenticationFailedException exception) {
		ErrorMessageDTO responseError = new ErrorMessageDTO(
			400,
			exception.getMessage()
		);
		
		return ResponseEntity
			.status(HttpStatus.BAD_REQUEST)
			.body(responseError);
	}

	@ExceptionHandler(AccountNotRegisteredException.class)
	public ResponseEntity<?> accountNotRegisteredHandler(AccountNotRegisteredException exception) {
		ErrorMessageDTO responseError = new ErrorMessageDTO(
			400,
			exception.getMessage()
		);
		
		return ResponseEntity
			.status(HttpStatus.BAD_REQUEST)
			.body(responseError);
	}
	
}
