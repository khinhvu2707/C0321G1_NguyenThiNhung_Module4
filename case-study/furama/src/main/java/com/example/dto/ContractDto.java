package com.example.dto;

import com.example.model.entity.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ContractDto {
    private Long contractId;
    private String contractStartDate;
    private String contractEndDate;
    @NotNull(message = "Please fill out the form")
    @Min(0)
    private double contractDeposit;
    @NotNull(message = "Please fill out the form")
    @Min(0)
    private double contractTotalMoney;
    private Employee employee;
    private Customer customer;
    private Services services;
    private List<ContractDetail> contractDetailList;
    private int flag;
    private String listAttachService;

    public ContractDto() {
    }

    public ContractDto(Long contractId, String contractStartDate, String contractEndDate, @NotNull(message = "Please fill out the form") @Min(0) double contractDeposit, @NotNull(message = "Please fill out the form") @Min(0) double contractTotalMoney, Employee employee, Customer customer, Services services, List<ContractDetail> contractDetailList, int flag, String listAttachService) {
        this.contractId = contractId;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
        this.employee = employee;
        this.customer = customer;
        this.services = services;
        this.contractDetailList = contractDetailList;
        this.flag = flag;
        this.listAttachService = listAttachService;
    }

    public ContractDto(Long contractId, String contractStartDate, String contractEndDate, double contractDeposit, double contractTotalMoney, Employee employee, Customer customer, Services services) {
        this.contractId = contractId;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
        this.employee = employee;
        this.customer = customer;
        this.services = services;
    }

    public ContractDto(Long contractId, String contractStartDate, String contractEndDate, double contractDeposit, double contractTotalMoney, Employee employee, Customer customer, Services services, int flag,String listAttachService) {
        this.contractId = contractId;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
        this.employee = employee;
        this.customer = customer;
        this.services = services;
        this.flag = flag;
        this.listAttachService = listAttachService;
    }

    public String getListAttachService() {
        return listAttachService;
    }

    public void setListAttachService(String listAttachService) {
        this.listAttachService = listAttachService;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public double getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(double contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public List<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(List<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }
}
