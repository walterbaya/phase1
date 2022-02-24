package com.example.todoapplication.service;

import com.example.todoapplication.model.Folder;
import com.example.todoapplication.repository.FoldersRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FoldersService {

    //Provide typical CRUD operations, Create, Delete, Read and UPDATE.
    @Autowired
    private FoldersRepository foldersRepository;


    public List<Folder> findAll(){
        return (List<Folder>) foldersRepository.findAll();
    }

        public Folder findById(Integer id) {
        return foldersRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    //Save and update are same thing.
    public Folder save(Folder folder){
        return foldersRepository.save(folder);
    }

    public void deleteById(Integer id){
        foldersRepository.deleteById(id);
    }
}
