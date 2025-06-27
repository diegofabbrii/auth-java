package com.diegofabbrii.authentication.domain.dtos.auth;

import com.diegofabbrii.authentication.domain.dtos.user.UserDTO;

public record SignInResponseDTO(String access_token, UserDTO user) {
}
