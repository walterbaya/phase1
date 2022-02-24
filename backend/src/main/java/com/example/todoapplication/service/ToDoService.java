package com.example.todoapplication.service;

import com.example.todoapplication.model.Item;
import com.example.todoapplication.repository.ToDoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ToDoService {

    //Provide typical CRUD operations, Create, Delete, Read and UPDATE.
    @Autowired
    private ToDoRepository toDoRepository;


    public List<Item> findAll(){
        return (List<Item>) toDoRepository.findAll();
    }

    public Item findById(Integer id) {
        return toDoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    //Save and update are same thing.
    public Item save(Item item){
        return toDoRepository.save(item);
    }

    public void deleteById(Integer id){
        toDoRepository.deleteById(id);
    }
}
