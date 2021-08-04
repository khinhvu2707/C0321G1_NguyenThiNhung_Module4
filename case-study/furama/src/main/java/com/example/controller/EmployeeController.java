package com.example.controller;

import com.example.dto.EmployeeDto;
import com.example.model.entity.Employee;
import com.example.model.service.employee.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @GetMapping
    public String showList(Pageable pageable,
                           @RequestParam Optional<String> search, Model model) {
        String keyword = "";
        if (search.isPresent()) {
            keyword = search.get();
        }
        Page<Employee> employees = employeeService.findAllByEmployeeNameContaining(pageable, keyword);
        model.addAttribute("employees", employees);
        return "/employee/list";
    }

    @GetMapping("/create")
    public String showEdit(@ModelAttribute EmployeeDto employeeDto,
                           BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("employeeDto", employeeDto);
            return "/employee/create";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        employeeService.save(employee);
        return "ddlist";

    }
}
