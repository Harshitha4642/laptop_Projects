package com.demo.operator.Controller;

import java.util.Random;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.operator.DTO.UserRequest;

@RestController
@RequestMapping("operator")
public class OperatorController {

    @PostMapping("/generate")
    public String generateUPC(@RequestBody UserRequest userRequest)
    {
        Random random = new Random();
        int upc = random.nextInt(90000) + 10000;
        String result = Integer.toString(upc);
        return result;
    }
    
}
