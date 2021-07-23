package com.example.controller;

import com.example.model.bean.Blog;
import com.example.model.bean.Category;
import com.example.model.service.IBlogService;
import com.example.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = {"/", "/blog"})
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/create-blog")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        List<Category> categoryList = categoryService.findAll();
        modelAndView.addObject("categoryList", categoryList);
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public ModelAndView save(@ModelAttribute("blog") Blog blog) {
        String newstring = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").format(new Date(System.currentTimeMillis()));
        blog.setDate(newstring);
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message", "New blog created successfully");
        return modelAndView;
    }

    @GetMapping("/blog")
    public ModelAndView list(@RequestParam(value = "searchByTitle",required = false) Optional<String> search,@RequestParam(value = "searchByCategory",required = false) Long searchByCategory, @PageableDefault(value = 5, sort = "date") Pageable pageable) {
        Page<Blog> blogs = null;
        List<Blog> blogByCategory = null;
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        if (search.isPresent()) {
            blogs = blogService.findAllByTitleContaining(search.get(), pageable);
            modelAndView.addObject("blogs", blogs);
        } else if (searchByCategory != null) {
            blogByCategory = blogService.findAllByCategory_Id(searchByCategory);
            modelAndView.addObject("blogByCategory", blogByCategory);
        } else {
            blogs = blogService.findAll(pageable);
            modelAndView.addObject("blogs", blogs);
        }
        List<Category> categoryList = categoryService.findAll();
        modelAndView.addObject("categoryList", categoryList);
        return modelAndView;
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("/blog/edit");
            modelAndView.addObject("blog", blog);
            List<Category> categoryList = categoryService.findAll();
            modelAndView.addObject("categoryList", categoryList);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-blog")
    public ModelAndView update(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "blog updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("/blog/delete");
            modelAndView.addObject("blog", blog);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-blog")
    public String delete(@ModelAttribute("blog") Blog blog) {
        blogService.delete(blog.getId());
        return "redirect:blog";
    }

    @GetMapping("/view-blog/{id}")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/blog/view";
    }
}

