package com.example.controller;

import com.example.dto.ServiceDto;
import com.example.model.entity.*;
import com.example.model.repository.rentType.IRentTypeRepository;
import com.example.model.repository.serviceType.IServiceTypeRepository;
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
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/services")
public class ServiceController {
    @Autowired
    private IServiceService serviceService;

    @Autowired
    private IRentTypeRepository rentTypeRepository;

    @Autowired
    private IServiceTypeRepository serviceTypeRepository;

    @ModelAttribute("rentTypeList")
    public List<RentType> rentTypeList() {
        return rentTypeRepository.findAll();
    }

    @ModelAttribute("serviceTypeList")
    public List<ServiceType> serviceTypeList() {
        return serviceTypeRepository.findAll();
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("serviceDto", new ServiceDto());
        return "/service/create";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute ServiceDto serviceDto, BindingResult bindingResult, Model model,
                       RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("serviceDto", serviceDto);
            return "/service/create";
        } else {
            serviceDto.setFlag(1);
            Services services = new Services();
            BeanUtils.copyProperties(serviceDto, services);
            serviceService.save(services);
            redirectAttributes.addFlashAttribute("message", "New service created successfully");
            return "redirect:/services";
        }
    }

    @GetMapping
    public String list(@PageableDefault(value = 5) Pageable pageable,
                       @RequestParam Optional<String> search, Model model) {
        String keyword = "";
        if (search.isPresent()) {
            keyword = search.get();
        }
        Page<Services> services = serviceService.findAllByServiceNameContaining(pageable, keyword);
        model.addAttribute("services", services);
        model.addAttribute("keyword", keyword);
        if(services.isEmpty()){
            model.addAttribute("message", "No content");
        }
        return "/service/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Services services = serviceService.findByServiceId(id);
        ServiceDto serviceDto = new ServiceDto();
        BeanUtils.copyProperties(services, serviceDto);
        model.addAttribute("serviceDto", serviceDto);
        return "/service/edit";
    }

    @PostMapping("/edit")
    public String update(@Valid @ModelAttribute ServiceDto serviceDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "/service/edit";
        }
        Services services = new Services();
        BeanUtils.copyProperties(serviceDto, services);
        serviceService.save(services);
        redirectAttributes.addFlashAttribute("message", "service updated successfully");
        return "redirect:/services";
    }

    @GetMapping("/delete")
    public String showDeleteForm(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        Services services = serviceService.findByServiceId(id);
        services.setFlag(0);
        serviceService.save(services);
        redirectAttributes.addFlashAttribute("message", "service deleted successfully");
        return "redirect:/services";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("service", serviceService.findByServiceId(id));
        return "/service/view";
    }
}
