package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.model.entity.Customer;
import com.example.model.entity.CustomerType;
import com.example.model.repository.CustomerType.ICustomerTypeRepository;
import com.example.model.service.customer.ICustomerService;
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
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeRepository customerType;

    @ModelAttribute("customerTypeList")
    public List<CustomerType> customerTypeList() {
        return customerType.findAll();
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        return "/customer/create";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute CustomerDto customerDto, BindingResult bindingResult, Model model,
                       RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerDto", customerDto);
            return "/customer/create";
        } else {
            String newstring = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").format(new Date(System.currentTimeMillis()));
            customerDto.setCustomerBirthday(newstring);
            customerDto.setFlag(1);
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto,customer);
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "New customer created successfully");
            return "redirect:/customer";
        }
    }

    @GetMapping
    public String list(@PageableDefault(value = 5) Pageable pageable,
                       @RequestParam Optional<String> search, Model model) {
        String keyword = "";
        if (search.isPresent()) {
            keyword = search.get();
        }
        Page<Customer> customers = customerService.findAllByCustomerNameContaining(pageable, keyword);
        model.addAttribute("customers", customers);
        model.addAttribute("keyword", keyword);
        if(customers.isEmpty()){
            model.addAttribute("message", "No content");
        }
        return "/customer/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Customer customer = customerService.findByCustomerId(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer,customerDto);
        model.addAttribute("customerDto", customerDto);
        return "/customer/edit";
    }

    @PostMapping("/edit")
    public String update(@Valid @ModelAttribute CustomerDto customerDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if(bindingResult.hasFieldErrors()){
            return "/customer/edit";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "customer updated successfully");
        return "redirect:/customer";
    }

    @GetMapping("/delete")
    public String showDeleteForm(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        Customer customer = customerService.findByCustomerId(id);
        customer.setFlag(0);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "customer deleted successfully");
        return "redirect:/customer";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("customer",customerService.findByCustomerId(id));
        return "/customer/view";
    }


    @GetMapping("/money")
    public String listCustomerUseService(@PageableDefault(value = 5) Pageable pageable,
                       @RequestParam Optional<String> search, Model model) {
        String keyword = "";
        if (search.isPresent()) {
            keyword = search.get();
        }
        Page<Customer> customerUseServices = customerService.findAllCustomerUserService(pageable,keyword);
        model.addAttribute("customerMoney", customerUseServices);
        model.addAttribute("keyword", keyword);
        System.out.println(customerUseServices);
        if(customerUseServices.isEmpty()){
            model.addAttribute("message", "No content");
        }
        return "/other/totalMoney";
    }
}
