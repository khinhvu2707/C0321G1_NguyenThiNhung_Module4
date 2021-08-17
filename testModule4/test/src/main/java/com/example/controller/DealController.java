package com.example.controller;

import com.example.dto.DealDto;
import com.example.model.entity.Customer;
import com.example.model.entity.Deal;
import com.example.model.entity.Services;
import com.example.model.repository.ICustomerRepository;
import com.example.model.service.ICustomerService;
import com.example.model.service.IDealService;
import com.example.model.service.IServicesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping({"/", "/deal"})
public class DealController {

    @Autowired
    private IDealService dealService;

    @Autowired
    private ICustomerService customerService;


    @Autowired
    private IServicesService servicesService;

    @ModelAttribute("customerList")
    public List<Customer> customerList() {
        return customerService.findAll();
    }

    @ModelAttribute("servicesList")
    public List<Services> servicesList() {
        return servicesService.findAll();
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("dealDto", new DealDto());
        return "/create";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute DealDto dealDto, BindingResult bindingResult, Model model,
                       RedirectAttributes redirectAttributes) {
        try {
            new DealDto().validate(dealDto, bindingResult);
            if (bindingResult.hasFieldErrors()) {
                model.addAttribute("dealDto", dealDto);
                return "/create";
            } else {
                String startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
                dealDto.setDateTime(startDate);
                dealDto.setFlag(1);
                Deal deal = new Deal();
                BeanUtils.copyProperties(dealDto, deal);
                dealService.save(deal);
                redirectAttributes.addFlashAttribute("message", "New deal created successfully");
                return "redirect:/deal";
            }
        } catch (Exception e) {
            model.addAttribute("messageCode", "Code duplicated");
            model.addAttribute("dealDto", dealDto);
            return "/create";
        }
    }

    @GetMapping
    public String list(@PageableDefault(value = 1) Pageable pageable,
                       @RequestParam Optional<String> service, @RequestParam Optional<String> name, Model model) {
        String keywordService = "";
        String keywordName = "";
        if (service.isPresent()) {
            keywordService = service.get();
        }
        if (name.isPresent()) {
            keywordName = name.get();
        }
        Page<Deal> deals = dealService.findAll(pageable, keywordService, keywordName);
        model.addAttribute("deals", deals);
        model.addAttribute("keywordService", keywordService);
        model.addAttribute("keywordName", keywordName);
        if (deals.isEmpty()) {
            model.addAttribute("message", "No content");
        }
        return "/list";
    }

    @GetMapping("/delete")
    public String showDeleteForm(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        Deal deal = dealService.findById(id);
        deal.setFlag(0);
        dealService.save(deal);
        redirectAttributes.addFlashAttribute("message", "deal deleted successfully");
        return "redirect:/deal";
    }


    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("deal", dealService.findById(id));
        return "/view";
    }
}
