package com.zayzou.tacos.controller;

import com.zayzou.tacos.entity.Subscriber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("subscribe")
@SessionAttributes("subscriber")
public class SubscribeFormController {

    @ModelAttribute("subscriber")
    public Subscriber getSubscriber(){
        return new Subscriber();
    }

    @GetMapping
    public String show(){
        return "subscribe";
    }

    @PostMapping
    public String add(@Valid @ModelAttribute Subscriber subscriber, Errors errors){
        if (errors.hasErrors()){
            log.error(errors.toString());
            return "subscribe";
        }
        log.info("Add Subscriber : {}",subscriber);
        return "redirect:/subscriber";
    }

}
