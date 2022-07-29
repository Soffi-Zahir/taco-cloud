package com.zayzou.tacos.entity;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Table
public class TacoOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private Date placedAt;

    @NotBlank
    private String deliveryName;
    private String deliveryStreet;
    @NotBlank
    private String deliveryCity;
    @NotBlank
    private String deliveryState;
    @NotBlank
    private String deliveryZip;

    @NotBlank
    @CreditCardNumber
    private String ccNumber;
    @NotBlank
    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\\\/])([2-9][0-9])$") //MM/YY
    private String ccExpiration;
    @NotBlank
    @Digits(integer = 3,fraction = 0)
    private String ccCVV;

    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }
}
