package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class ConvertCurrencyImpl implements ConvertCurrencyService{
    @Override
    public float convert(float a, float b) {
        return a*b;
    }
}
