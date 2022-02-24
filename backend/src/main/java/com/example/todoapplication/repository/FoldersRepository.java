package com.example.todoapplication.repository;

import com.example.todoapplication.model.Folder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoldersRepository extends CrudRepository<Folder, Integer> {

}
