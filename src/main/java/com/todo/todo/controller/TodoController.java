package com.todo.todo.controller;

import com.todo.todo.model.Item;
import com.todo.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    @Autowired
    private TodoService toDoService;

    @CrossOrigin(origins = "*")
    @GetMapping
    public List<Item> findAll(){
        return toDoService.findAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public Item findById(@PathVariable Integer id){
        return toDoService.findById(id);
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public Item create(@RequestBody Item item){
        return toDoService.save(item);
    }

    @CrossOrigin(origins = "*")
    @PutMapping
    public Item update(@RequestBody Item item){
        Item gettedItem = toDoService.findById(item.getId());
        gettedItem.setName(item.getName());
        return toDoService.save(gettedItem);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping
    public void deleteById(@PathVariable Integer id){
        toDoService.deleteById(id);
    }
}
