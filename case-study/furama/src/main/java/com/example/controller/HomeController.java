package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/", "/furama"})
public class HomeController {
    @GetMapping
    public  String showHome(){
        return "/homePage";
    }
}
