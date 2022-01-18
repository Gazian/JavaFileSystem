package com.codeclan.example.FileSystem.repository;

import com.codeclan.example.FileSystem.models.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
