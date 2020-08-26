package com.codecool.seriesapp.repository;

import com.codecool.seriesapp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
