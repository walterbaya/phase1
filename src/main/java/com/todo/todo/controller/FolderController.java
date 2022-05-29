package com.todo.todo.controller;


import com.todo.todo.model.Folder;
import com.todo.todo.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class FolderController {

    @Autowired
    private FolderService foldersService;

    @CrossOrigin(origins = "*")
    @GetMapping("/folders")
    public List<Folder> findAll(){
        return foldersService.findAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/folders/{id}")
    public Folder findById(@PathVariable String id){
        return foldersService.findById(Integer.parseInt(id));
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
    public void deleteById(@PathVariable String id){
        foldersService.deleteById(Integer.parseInt(id));
    }
}
