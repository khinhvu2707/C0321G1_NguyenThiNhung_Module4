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

    @GetMapping("/list")
    public String showList(){
        return "/crud/list";
    }

    @GetMapping("/create")
    public String showCreate(){
        return "/crud/create";
    }

    @GetMapping("/edit")
    public String showEdit(){
        return "crud/editHome";
    }

    @GetMapping("/contract-edit")
    public String showEditContract(){
        return "contract/edit";
    }
}
