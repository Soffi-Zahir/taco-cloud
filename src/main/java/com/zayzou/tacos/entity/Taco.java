package com.zayzou.tacos.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Table
public class Taco {

    @NotBlank
    @Size(min = 1,message = "Name at least be 5 characters")
    private String name;

    @Id
    private Long id;
    private Date createdAt = new Date();


    @Size(min = 1)
    private List<Ingredient> ingredients;
}
