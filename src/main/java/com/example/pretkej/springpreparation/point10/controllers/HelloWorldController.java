package com.example.pretkej.springpreparation.point10.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
    @RequestMapping("/sayHello")
    @ResponseBody
    public String sayHello() {
        return "Hello world";
    }
}
