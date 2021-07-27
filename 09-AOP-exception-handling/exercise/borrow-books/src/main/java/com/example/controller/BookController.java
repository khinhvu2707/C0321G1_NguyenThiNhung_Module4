package com.example.controller;

import com.example.exception.NotBorrowException;
import com.example.exception.NotFoundException;
import com.example.model.entity.Book;
import com.example.model.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private IBookService iBookService;

    @GetMapping("/")
    public String showBook(Model model) {
        List<Book> list = iBookService.findAll();
        model.addAttribute("books", list);
        return "library/book";
    }

    @GetMapping("/borrow/{id}")
    public String borrowBook(@PathVariable Long id, Model model) {
        Book book = iBookService.findById(id);
        model.addAttribute("book", book);
        return "library/borrow";
    }

    @GetMapping("/borrow-book/{id}")
    public String borrow(@PathVariable Long id, RedirectAttributes redirectAttributes) throws NotBorrowException {
        Book book = iBookService.findById(id);
        int amount = book.getAmount();
        if (amount == 0) {
            throw new NotBorrowException();
        }
        book.setAmount(amount - 1);
        iBookService.save(book);
        redirectAttributes.addFlashAttribute("message", "You have successfully borrowed the " + book.getName());
        return "redirect:/";
    }

    @PostMapping("/pay")
    public String payBook(@RequestParam String book, Model model) throws NotFoundException {
        Book payBook = iBookService.findByCode(book);
        if (payBook == null) {
            throw new NotFoundException();
        }
        model.addAttribute("books", payBook);
        return "library/pay";
    }

    @GetMapping("/pay-book/{id}")
    public String pay(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        Book payBook = iBookService.findById(id);
        int amount = payBook.getAmount() + 1;
        payBook.setAmount(amount);
        iBookService.save(payBook);
        redirectAttributes.addFlashAttribute("message", "You have successfully returned the " + payBook.getName());
        return "redirect:/";
    }

    @ExceptionHandler(NotFoundException.class)
    public ModelAndView showNotFound() {
        return new ModelAndView("library/notFound");
    }

    @ExceptionHandler(NotBorrowException.class)
    public ModelAndView showNotBorrow() {
        return new ModelAndView("library/notBorrow");
    }
}
