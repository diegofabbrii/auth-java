package com.diegofabbrii.authentication.domain.dtos.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public record ErrorMessageDTO(int statusCode, String message) {
}
