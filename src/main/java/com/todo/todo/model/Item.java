package com.todo.todo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import javax.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Data
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Boolean completed;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "folder_id")
    private Folder folder;

}