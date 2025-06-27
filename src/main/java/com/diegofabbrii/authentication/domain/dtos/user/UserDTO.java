package com.diegofabbrii.authentication.domain.dtos.user;

import com.diegofabbrii.authentication.domain.enums.UserRoleEnum;

public record UserDTO(String id, String username, String email, UserRoleEnum role) {}
