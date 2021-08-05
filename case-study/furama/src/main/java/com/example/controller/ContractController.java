package com.example.controller;

import com.example.dto.ContractDto;
import com.example.model.entity.*;
import com.example.model.service.contract.IContractService;
import com.example.model.service.customer.ICustomerService;
import com.example.model.service.employee.IEmployeeService;
import com.example.model.service.service.IServiceService;
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
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IServiceService serviceService;

    @Autowired
    private IEmployeeService employeeService;

    @ModelAttribute("customerList")
    public List<Customer> customerList() {
        return customerService.findAll();
    }

    @ModelAttribute("serviceList")
    public List<Services> serviceList() {
        return serviceService.findAll();
    }

    @ModelAttribute("employeeList")
    public List<Employee> employeeList() {
        return employeeService.findAll();
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("contractDto", new ContractDto());
        return "/contract/create";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute ContractDto contractDto, BindingResult bindingResult, Model model,
                       RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("contractDto", contractDto);
            return "/contract/create";
        } else {
            String newstring = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").format(new Date(System.currentTimeMillis()));
            contractDto.setContractStartDate(newstring);
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto,contract);
            contractService.save(contract);
            redirectAttributes.addFlashAttribute("message", "New contract created successfully");
            return "redirect:/contract";
        }
    }

    @GetMapping
    public String list(@PageableDefault(value = 5) Pageable pageable,
                       @RequestParam Optional<String> search, Model model) {
        String keyword = "";
        if (search.isPresent()) {
            keyword = search.get();
        }
        Page<Contract> contracts = contractService.findAllByEmployeeName(pageable, keyword);
        model.addAttribute("contracts", contracts);
        model.addAttribute("keyword", keyword);
        return "/contract/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Contract contract = contractService.findByContractId(id);
        ContractDto contractDto = new ContractDto();
        BeanUtils.copyProperties(contract,contractDto);
        model.addAttribute("contractDto", contractDto);
        return "/contract/edit";
    }

    @PostMapping("/edit")
    public String update(@Valid @ModelAttribute ContractDto contractDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if(bindingResult.hasFieldErrors()){
            return "/contract/edit";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto,contract);
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("message", "contract updated successfully");
        return "redirect:/contract";
    }

    @GetMapping("/delete")
    public String showDeleteForm(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        contractService.delete(id);
        redirectAttributes.addFlashAttribute("message", "contract deleted successfully");
        return "redirect:/contract";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("contract",contractService.findByContractId(id));
        return "/contract/view";
    }
}
