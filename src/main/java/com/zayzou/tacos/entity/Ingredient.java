package com.zayzou.tacos.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
//@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)

public class Ingredient {
    @Id
    private  String id;
    private  String name;
    private  Type type;


    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
