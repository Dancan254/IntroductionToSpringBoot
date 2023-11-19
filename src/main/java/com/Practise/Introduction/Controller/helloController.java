package com.Practise.Introduction.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {

    @GetMapping("/")
    public String helloWorld(){

        return "Welcome to Ian coding channel. I love java and Devops";
    }
}
