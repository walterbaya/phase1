package com.todo.todo.repository;

import com.todo.todo.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<Item, Integer> {
}

