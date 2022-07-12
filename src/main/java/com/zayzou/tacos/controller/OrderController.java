package com.zayzou.tacos.controller;

import com.zayzou.tacos.entity.TacoOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    @GetMapping("/current")
    public String showCurrent(){
        System.out.println("Calling Current order route");
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder tacoOrder, Errors errors, SessionStatus sessionStatus){
        if (errors.hasErrors()) {
            return "orderForm";
        }
        sessionStatus.setComplete();
        log.info("Processing order {}",tacoOrder);
        tacoOrder.getTacos().stream().forEach(taco -> {
            System.out.println("taco name : "+taco.getName());
            System.out.println("ingredient : ");
            taco.getIngredients().stream().forEach(ingredient -> {
                System.out.println(ingredient.getName());
            });
        });
        return "redirect:/design";
    }
}
