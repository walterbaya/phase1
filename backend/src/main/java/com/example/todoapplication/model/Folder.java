package com.example.todoapplication.model;

import jakarta.persistence. *;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Entity
@Data
@Table(name= "folder")
public class Folder {

    public Folder() {

    }

    public Folder(String name, Boolean completed){
        this.name = name;
        this.completed = completed;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private Boolean completed;

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }
}
