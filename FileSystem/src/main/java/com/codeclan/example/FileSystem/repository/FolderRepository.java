package com.codeclan.example.FileSystem.repository;

import com.codeclan.example.FileSystem.models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<Folder, Long> {
}
