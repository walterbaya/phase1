package com.todo.todo.repository;

import com.todo.todo.model.Folder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends CrudRepository<Folder, Integer> {

}
