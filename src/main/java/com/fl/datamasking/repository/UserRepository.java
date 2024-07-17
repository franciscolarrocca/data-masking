package com.fl.datamasking.repository;

import com.fl.datamasking.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}