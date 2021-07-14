package com.example.controller;

import com.example.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;
    @GetMapping("/")
    public String showInput() {
        return "/input";
    }
    @PostMapping("/result")
    public String greeting(@RequestParam String english, Model model) {
        model.addAttribute("result", dictionaryService.translate(english));
        return "/input";
    }
}
