package com.codeclan.example.FileSystem.repository;

import com.codeclan.example.FileSystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
