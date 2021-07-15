package com.example.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepositoryImpl implements DictionaryRepository {
    @Override
    public String translate(String text) {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("happy", "Hạnh phúc");
        dictionary.put("bye", "Tạm biệt");
        String result = dictionary.get(text.toLowerCase());
        String error = "Không có từ này trong từ điển!";
        if (result != null) {
            return result;
        } else {
            return error;
        }
    }
}
