package com.zayzou.tacos.controller;

import com.zayzou.tacos.entity.TacoOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

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
    public String processOrder(TacoOrder tacoOrder, SessionStatus sessionStatus){
        sessionStatus.setComplete();
        log.info("Processing order {}",tacoOrder);
        return "redirect:/";
    }
}
