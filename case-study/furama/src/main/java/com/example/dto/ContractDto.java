package com.example.dto;

import com.example.model.entity.Customer;
import com.example.model.entity.Employee;
import com.example.model.entity.Services;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ContractDto {
    private Long contractId;
    @NotBlank(message = "Không được để trống")
    private String contractStartDate;
    @NotBlank(message = "Không được để trống")
    private String contractEndDate;
    @NotNull(message = "Không được để trống")
    @Min(0)
    private double contractDeposit;
    @NotNull(message = "Không được để trống")
    @Min(0)
    private double contractTotalMoney;
    private Employee employee;
    private Customer customer;
    private Services services;

    public ContractDto() {
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

}
