package com.example.service;

import com.example.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Autowired
    private DictionaryRepository dictionaryRepository;
    @Override
    public String translate(String text) {
        return dictionaryRepository.translate(text);
    }
}
