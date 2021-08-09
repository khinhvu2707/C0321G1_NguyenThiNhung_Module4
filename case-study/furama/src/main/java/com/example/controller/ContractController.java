package com.example.controller;

import com.example.dto.ContractDto;
import com.example.model.entity.*;
import com.example.model.service.contract.IContractService;
import com.example.model.service.contractDetail.IContractDetailService;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

    @Autowired
    private IContractDetailService contractDetailService;

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
            String startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
            contractDto.setContractStartDate(startDate);
            Calendar end = Calendar.getInstance();
            if (contractDto.getServices().getRentType().getRentTypeId() == 1) {
                end.add(Calendar.YEAR, 1);
            } else if (contractDto.getServices().getRentType().getRentTypeId() == 2){
                end.add(Calendar.MONTH, 1);
            }else if (contractDto.getServices().getRentType().getRentTypeId() == 3){
                end.add(Calendar.DAY_OF_MONTH, 1);
            }else {
                end.add(Calendar.HOUR_OF_DAY, 1);
            }
            Date dateEnd = end.getTime();
            String endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateEnd);
            contractDto.setContractEndDate(endDate);
            contractDto.setFlag(1);
            contractDto.setContractTotalMoney(contractDto.getServices().getServiceCost());
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto, contract);
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
        Page<Contract> contracts = contractService.findAllByCustomerName(pageable, keyword);
        model.addAttribute("contracts", contracts);
        model.addAttribute("keyword", keyword);
        if (contracts.isEmpty()) {
            model.addAttribute("message", "No content");
        }
        return "/contract/list";
    }
//
//    @GetMapping("/edit")
//    public String showEditForm() {
//        return "/contract/edit";
//    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Contract contract = contractService.findByContractId(id);
        ContractDto contractDto = new ContractDto();
        BeanUtils.copyProperties(contract, contractDto);
        model.addAttribute("contractDto", contractDto);
        return "/contract/edit";
    }

    @PostMapping("/edit")
    public String update(@Valid @ModelAttribute ContractDto contractDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) throws ParseException {
        if (bindingResult.hasFieldErrors()) {
            return "/contract/edit";
        }
        String end = contractDto.getContractStartDate();
        Calendar calendar = Calendar.getInstance();
        Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(end);
        calendar.setTime(date1);
        if (contractDto.getServices().getRentType().getRentTypeId() == 1) {
            calendar.add(Calendar.YEAR, 1);
        } else if (contractDto.getServices().getRentType().getRentTypeId() == 2) {
            calendar.add(Calendar.MONTH, 1);
        } else if (contractDto.getServices().getRentType().getRentTypeId() == 3) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        } else {
            calendar.add(Calendar.HOUR_OF_DAY, 1);
        }
        Date dateEnd = calendar.getTime();
        String endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateEnd);
        contractDto.setContractEndDate(endDate);
        Double totalMoney = 0.0;
        List<ContractDetail> contractDetailList = contractDetailService.findAllByContract_ContractId(contractDto.getContractId());
        for (int i = 0; i < contractDetailList.size(); i++) {
            totalMoney += contractDetailList.get(i).getAttachService().getAttachServiceCost() * contractDetailList.get(i).getQuantity();
        }
        contractDto.setContractTotalMoney(contractDto.getServices().getServiceCost() + totalMoney);
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("message", "contract updated successfully");
        return "redirect:/contract";
    }

    @GetMapping("/delete")
    public String showDeleteForm(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        Contract contract = contractService.findByContractId(id);
        contract.setFlag(0);
        contractService.save(contract);
        List<ContractDetail> contractDetailList = contractDetailService.findAllByContract_ContractId(id);
        for (int i = 0; i < contractDetailList.size(); i++) {
            contractDetailList.get(i).setFlag(0);
            contractDetailService.save(contractDetailList.get(i));
        }
        redirectAttributes.addFlashAttribute("message", "contract deleted successfully");
        return "redirect:/contract";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("contract", contractService.findByContractId(id));
        return "/contract/view";
    }

    @GetMapping("/view-contract/{id}")
    public String viewContract(@PageableDefault(value = 5) Pageable pageable,@PathVariable Long id, Model model) {
        model.addAttribute("contracts", contractService.findByCustomer(pageable,id));
        return "/contract/list";
    }
}
