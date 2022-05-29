package com.todo.todo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Data
@Table(name= "folder")
public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="folder_id")
    private Integer id;

    @NotNull(message = "name may not be null")
    @Column(nullable = false)
    private String name;

    @JsonManagedReference
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="folder_id")
    private List<Item> items;

}
