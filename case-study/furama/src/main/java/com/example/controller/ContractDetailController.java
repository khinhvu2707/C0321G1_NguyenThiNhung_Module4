package com.example.controller;

import com.example.dto.ContractDetailDto;
import com.example.model.entity.AttachService;
import com.example.model.entity.Contract;
import com.example.model.entity.ContractDetail;
import com.example.model.repository.attachServiceRepository.IAttachServiceRepository;
import com.example.model.service.contract.IContractService;
import com.example.model.service.contractDetail.IContractDetailService;
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
import java.util.List;

@Controller
@RequestMapping("/contractDetail")
public class ContractDetailController {
    @Autowired
    private IContractDetailService contractDetailService;

    @Autowired
    private IContractService contractService;

    @Autowired
    private IAttachServiceRepository attachServiceRepository;

    @ModelAttribute("contractList")
    public List<Contract> contractList(){return contractService.findAll(); }

    @ModelAttribute("attachServiceList")
    public List<AttachService> attachServiceList() {
        return attachServiceRepository.findAll();
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("contractDetailDto", new ContractDetailDto());
        return "/contractDetail/create";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute ContractDetailDto contractDetailDto, BindingResult bindingResult, Model model,
                       RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("contractDetailDto", contractDetailDto);
            return "/contractDetail/create";
        } else {
            Contract contract = contractService.findByContractId(contractDetailDto.getContract().getContractId());
            Double newTotalMoney = contract.getContractTotalMoney() + contractDetailDto.getQuantity()*contractDetailDto.getAttachService().getAttachServiceCost();
            contract.setContractTotalMoney(newTotalMoney);
            String listAttachService = "";
            if(contract.getListAttachService().isEmpty()){
                listAttachService = contractDetailDto.getAttachService().getAttachServiceName() +"-Quantity: " +contractDetailDto.getQuantity();
            }
            else {
                listAttachService = contract.getListAttachService()  +" , " + contractDetailDto.getAttachService().getAttachServiceName() +"-Quantity: " +contractDetailDto.getQuantity();
            }
            contract.setListAttachService(listAttachService);
            contractDetailDto.setFlag(1);
            ContractDetail contractDetail = new ContractDetail();
            BeanUtils.copyProperties(contractDetailDto,contractDetail);
            contractDetailService.save(contractDetail);
            redirectAttributes.addFlashAttribute("message", "New Contract Detail created successfully");
            return "redirect:/contractDetail";
        }
    }

    @GetMapping
    public String list(@PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<ContractDetail> contractDetails = contractDetailService.findAll(pageable);
        model.addAttribute("contractDetails", contractDetails);
        if(contractDetails.isEmpty()){
            model.addAttribute("message", "No content");
        }
        return "/contractDetail/list";
    }

    @GetMapping("/edit")
    public String showEditForm() {
        return "/contractDetail/edit";
    }

    @GetMapping("/delete")
    public String showDeleteForm(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        ContractDetail contractDetail = contractDetailService.findByContractDetailId(id);
        contractDetail.setFlag(0);
        contractDetailService.save(contractDetail);
        redirectAttributes.addFlashAttribute("message", "Contract Detail deleted successfully");
        return "redirect:/contractDetail";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("contractDetail",contractDetailService.findByContractDetailId(id));
        return "/contractDetail/view";
    }
}
