package com.codeclan.example.FileSystem.controller;

import com.codeclan.example.FileSystem.models.File;
import com.codeclan.example.FileSystem.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FileController {
    @Autowired
    FileRepository fileRepository;

    @GetMapping(value = "/files")
    public ResponseEntity<List<File>> getAllFiles(){
        return new ResponseEntity<>(fileRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/files/{id}")
    public ResponseEntity<Optional<File>> getFile(@PathVariable Long id){
        Optional<File> payload = fileRepository.findById(id);
        if(payload.isPresent()){
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(payload, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/files")
    public ResponseEntity<File> postFile(@RequestBody File file){
        fileRepository.save(file);
        return new ResponseEntity<>(file, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/files/{id}")
    public ResponseEntity<String> deleteFile(@PathVariable Long id){
        fileRepository.deleteById(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

    @PutMapping(value = "/files/{id}")
    public ResponseEntity<File> updateFile(@PathVariable Long id, @RequestBody File file){
        Optional<File> fileToFind = fileRepository.findById(id);
        if (fileToFind.isPresent()){
            File fileToUpdate = fileToFind.get();
            fileToUpdate.setName(file.getName());
            fileRepository.save(fileToUpdate);
            return new ResponseEntity<>(fileToUpdate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }
}
