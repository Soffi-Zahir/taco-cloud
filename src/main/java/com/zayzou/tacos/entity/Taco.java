package com.zayzou.tacos.entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Taco {

    @NotBlank
    @Size(min = 1,message = "Name at least be 5 characters")
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date createdAt = new Date();


    @Size(min = 1)
    @ManyToMany
    private List<Ingredient> ingredients;
}
