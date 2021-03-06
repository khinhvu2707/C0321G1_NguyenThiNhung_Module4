package com.example.controller;

import com.example.service.ConvertCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertCurrencyController {
    @Autowired
    private ConvertCurrencyService convertCurrency;

    @GetMapping("/")
    public String showInput() {
        return "/input";
    }

    @PostMapping("/convert")
    public String greeting(@RequestParam String usd,@RequestParam String rate, Model model) {
        float inputUSD = Float.parseFloat(usd);
        float inputRate = Float.parseFloat(rate);
        model.addAttribute("result", convertCurrency.convert(inputUSD, inputRate));
        return "/result";
    }
}
