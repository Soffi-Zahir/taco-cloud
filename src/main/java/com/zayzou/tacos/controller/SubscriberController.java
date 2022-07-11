package com.zayzou.tacos.controller;

import com.zayzou.tacos.entity.Subscriber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("subscriber")
@SessionAttributes("subscriber")
public class SubscriberController {

    @GetMapping
    public String show(){
        return "subscribe-added";
    }

}
