package com.example.controller;

import com.example.dto.TicketDto;
import com.example.exception.TicketException;
import com.example.model.entity.Movie;
import com.example.model.entity.Ticket;
import com.example.model.repository.IMovieRepository;
import com.example.model.service.ITicketService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Controller
@RequestMapping({"/","/ticket"})
public class TicketController {
    @Autowired
    private ITicketService ticketService;

    @Autowired
    private IMovieRepository movieRepository;

    @ModelAttribute("movieList")
    public List<Movie> movieList() {
        return movieRepository.findAll();
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("ticketDto", new TicketDto());
        return "/create";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute TicketDto ticketDto, BindingResult bindingResult, Model model,
                       RedirectAttributes redirectAttributes) {
       try {
           new TicketDto().validate(ticketDto, bindingResult);
           if (bindingResult.hasFieldErrors()) {
               model.addAttribute("ticketDto", ticketDto);
               return "/create";
           } else {
               ticketDto.setFlag(1);
               Ticket ticket = new Ticket();
               BeanUtils.copyProperties(ticketDto, ticket);
               ticketService.save(ticket);
               redirectAttributes.addFlashAttribute("message", "New ticket created successfully");
               return "redirect:/ticket";
           }
       }catch (Exception e){
           model.addAttribute("messageCode", "Code duplicated");
           model.addAttribute("ticketDto", ticketDto);
           return "/create";
       }
    }

    @GetMapping
    public String list(@PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<Ticket> questions = ticketService.findAll(pageable);
        model.addAttribute("tickets", questions);
        return "/list";
    }

    @GetMapping("/delete")
    public String showDeleteForm(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        Ticket ticket = ticketService.findById(id);
        ticket.setFlag(0);
        ticketService.save(ticket);
        redirectAttributes.addFlashAttribute("message", "ticket deleted successfully");
        return "redirect:/ticket";
    }

    @ExceptionHandler(TicketException.class)
    public ModelAndView showException(){
        return new ModelAndView("/error");
    }

}
