package com.zayzou.tacos.controller;

import com.zayzou.tacos.data.OrderRepository;
import com.zayzou.tacos.entity.TacoOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    OrderRepository orderRepository;
    OrderController(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

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
        orderRepository.save(tacoOrder);
        System.out.println(orderRepository.findAll());
        return "redirect:/design";
    }

    @GetMapping("/all")
    @ResponseBody
    public Iterable<TacoOrder> all(){
        return orderRepository.findAll();
    }

    @GetMapping("/{zip}")
    @ResponseBody
    public List<TacoOrder> findByDeliveryZip(@PathVariable String zip){
        return orderRepository.findByDeliveryZip(zip);
    }

}
