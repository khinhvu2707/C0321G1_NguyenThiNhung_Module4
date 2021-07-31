package com.example.controller;

import com.example.model.bean.Blog;
import com.example.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/blog/api")
public class BlogRestController {

    @Autowired
    private IBlogService blogService;

    @GetMapping
    public ResponseEntity<Page<Blog>> listBlog(@PageableDefault(value = 3) Pageable pageable,@RequestParam Optional<String> title) {
        String keywordTitle = "";
        if (title.isPresent()) {
            keywordTitle = title.get();
        }
        Page<Blog> blogList = blogService.findAllByTitleContaining(pageable,keywordTitle);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }


//    @GetMapping("/search")
//    public ResponseEntity<List<Blog>> listBlog(@RequestParam Optional<String> title) {
//
//        String keywordTitle = "";
//        if (title.isPresent()) {
//            keywordTitle = title.get();
//        }
//        List<Blog> blogList = blogService.findAllByTitleContaining(keywordTitle);
//        if (blogList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(blogList, HttpStatus.OK);
//    }
}

