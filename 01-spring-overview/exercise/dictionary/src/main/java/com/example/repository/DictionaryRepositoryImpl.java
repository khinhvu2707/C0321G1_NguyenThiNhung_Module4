package com.example.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class DictionaryRepositoryImpl implements DictionaryRepository{
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
