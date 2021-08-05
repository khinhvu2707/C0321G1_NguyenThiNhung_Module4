package com.example.controller;

import com.example.dto.EmployeeDto;
import com.example.model.entity.*;
import com.example.model.repository.division.IDivisionRepository;
import com.example.model.repository.educationDegree.IEducationDegreeRepository;
import com.example.model.repository.position.IPositionRepository;
import com.example.model.service.employee.IEmployeeService;
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
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IDivisionRepository divisionRepository;

    @Autowired
    private IEducationDegreeRepository educationDegreeRepository;

    @Autowired
    private IPositionRepository positionRepository;

    @ModelAttribute("divisionList")
    public List<Division> divisionList() {
        return divisionRepository.findAll();
    }

    @ModelAttribute("educationDegreeList")
    public List<EducationDegree> educationDegreeList() {
        return educationDegreeRepository.findAll();
    }

    @ModelAttribute("positionList")
    public List<Position> positionList() {
        return positionRepository.findAll();
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());
        return "/employee/create";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute EmployeeDto employeeDto, BindingResult bindingResult, Model model,
                       RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("employeeDto", employeeDto);
            return "/employee/create";
        } else {
            String newstring = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").format(new Date(System.currentTimeMillis()));
            employeeDto.setEmployeeBirthday(newstring);
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto,employee);
            employeeService.save(employee);
            redirectAttributes.addFlashAttribute("message", "New employee created successfully");
            return "redirect:/employee";
        }
    }

    @GetMapping
    public String list(@PageableDefault(value = 5) Pageable pageable,
                       @RequestParam Optional<String> search, Model model) {
        String keyword = "";
        if (search.isPresent()) {
            keyword = search.get();
        }
        Page<Employee> employees = employeeService.findAllByEmployeeNameContaining(pageable, keyword);
        model.addAttribute("employees", employees);
        model.addAttribute("keyword", keyword);
        return "/employee/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Employee employee = employeeService.findByEmployeeId(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee,employeeDto);
        model.addAttribute("employeeDto", employeeDto);
        return "/employee/edit";
    }

    @PostMapping("/edit")
    public String update(@Valid @ModelAttribute EmployeeDto employeeDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasFieldErrors()){
            return "/employee/edit";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "employee updated successfully");
        return "redirect:/employee";
    }

    @GetMapping("/delete")
    public String showDeleteForm(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        employeeService.delete(id);
        redirectAttributes.addFlashAttribute("message", "employee deleted successfully");
        return "redirect:/employee";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("employee",employeeService.findByEmployeeId(id));
        return "/employee/view";
    }
}
