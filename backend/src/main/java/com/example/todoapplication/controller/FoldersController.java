package com.example.todoapplication.controller;

import com.example.todoapplication.model.Folder;
import com.example.todoapplication.service.FoldersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class FoldersController {

    @Autowired
    private FoldersService foldersService;

    @CrossOrigin(origins = "*")
    @GetMapping("/folders")

    public List<Folder> findAll(){
        return foldersService.findAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/folders/{id}")
    public Folder findById(@PathVariable Integer id){
        return foldersService.findById(id);
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/folders")
    public Folder create(@RequestBody Folder folder){
        return foldersService.save(folder);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/folders/{id}")
    public Folder update(@RequestBody Folder folder){
        return foldersService.save(folder);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/folders/{id}")
    public void deleteById(@PathVariable Integer id){
        foldersService.deleteById(id);
    }
}
