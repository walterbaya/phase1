package com.todo.todo.service;

import com.todo.todo.model.Item;
import com.todo.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class TodoService {
    //Provide typical CRUD operations, Create, Delete, Read and UPDATE.
    @Autowired
    private TodoRepository toDoRepository;


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
