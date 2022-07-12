package com.zayzou.tacos.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
public class Taco {

    @NotBlank
    @Size(min = 1,message = "Name at least be 5 characters")
    private String name;

    private Long id;
    private Date createdAt = new Date();


    @Size(min = 1)
    private List<Ingredient> ingredients;
}
