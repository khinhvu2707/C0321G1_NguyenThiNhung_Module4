package com.example.controller;

import com.example.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MailController {
    @GetMapping("/update-email")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("email", new Email("English", 10, false, "nhung"));
        modelAndView.addObject("languages", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        modelAndView.addObject("size", new String[]{"5", "10", "15", "25", "50", "100"});
        return modelAndView;
    }

    @PostMapping("/update-email")
    public ModelAndView createEmail(@ModelAttribute Email email) {
        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("email", email);
        return modelAndView;
    }
}
