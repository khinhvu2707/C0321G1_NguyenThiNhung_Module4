package com.example.controller;

import com.example.service.CaculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
    @Autowired
    private CaculatorService caculatorService;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/calculate")
    public String save(@RequestParam String firstOperand, @RequestParam String secondOperand, @RequestParam String operator, Model model) {
        Float firstNumber = Float.parseFloat(firstOperand);
        Float secondNumber = Float.parseFloat(secondOperand);
        model.addAttribute("result", caculatorService.Calculate(firstNumber, secondNumber, operator));
        return "index";
    }
}
