package com.example.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Override
    public String translate(String text) {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");
        String result = dictionary.get(text);
        String error = "Không có từ này trong từ điển!";
        if(result != null){
            return result;
        } else {
            return error;
        }
    }
}
