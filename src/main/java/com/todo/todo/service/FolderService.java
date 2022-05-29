package com.todo.todo.service;

import com.todo.todo.model.Folder;
import com.todo.todo.repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class FolderService {

    //Provide typical CRUD operations, Create, Delete, Read and UPDATE.
    @Autowired
    private FolderRepository foldersRepository;


    public List<Folder> findAll() {
        return (List<Folder>) foldersRepository.findAll();
    }

    public Folder findById(Integer id) {
        return foldersRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    //Save and update are same thing.
    public Folder save(Folder folder) {
        return foldersRepository.save(folder);
    }

    public void deleteById(Integer id) {
        foldersRepository.deleteById(id);
    }
}