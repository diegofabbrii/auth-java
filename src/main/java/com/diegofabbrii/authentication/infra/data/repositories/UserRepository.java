package com.diegofabbrii.authentication.infra.data.repositories;

import com.diegofabbrii.authentication.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
