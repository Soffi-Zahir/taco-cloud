package com.zayzou.tacos.entity;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class Subscriber {

    @NotBlank
    @Size(min = 5)
    String name;
    @NotBlank
    @Email
    String  email;
}
