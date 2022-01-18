package com.codeclan.example.FileSystem.controller;

import com.codeclan.example.FileSystem.models.Folder;
import com.codeclan.example.FileSystem.repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FolderController {
    @Autowired
    FolderRepository folderRepository;

    @GetMapping(value = "/folders")
    public ResponseEntity<List<Folder>> getAllFolders(){
        return new ResponseEntity<>(folderRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/folders/{id}")
    public ResponseEntity<Optional<Folder>> getFolder(@PathVariable Long id){
        Optional<Folder> payload = folderRepository.findById(id);
        if(payload.isPresent()){
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(payload, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/folders")
    public ResponseEntity<Folder> postFolder(@RequestBody Folder folder){
        folderRepository.save(folder);
        return new ResponseEntity<>(folder, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/folders/{id}")
    public ResponseEntity<String> deleteFolder(@PathVariable Long id){
        folderRepository.deleteById(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

    @PutMapping(value = "/folders/{id}")
    public ResponseEntity<Folder> updateFolder(@PathVariable Long id, @RequestBody Folder folder){
        Optional<Folder> folderToFind = folderRepository.findById(id);
        if (folderToFind.isPresent()){
            Folder folderToUpdate = folderToFind.get();
            folderToUpdate.setTitle(folder.getTitle());
            folderRepository.save(folderToUpdate);
            return new ResponseEntity<>(folderToUpdate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

}
