package com.docker.hello;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@CrossOrigin
public class controller {
    @GetMapping("/message")
    public Hello getMessage()
    {
        Hello dto = new Hello();
        dto.setHello("hello world, I am running");
        return dto;
    }

    
}
