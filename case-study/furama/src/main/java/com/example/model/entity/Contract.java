package com.example.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contractId;
    @Column(columnDefinition = "DATE")
    private String contractStartDate;
    @Column(columnDefinition = "DATE")
    private String contractEndDate;
    private double contractDeposit;
    private double contractTotalMoney;
    @JsonManagedReference
    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "employee_id",referencedColumnName = "employeeId")
    private Employee employee;
    @JsonManagedReference
    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customer_id",referencedColumnName = "customerId")
    private Customer customer;
    @JsonManagedReference
    @ManyToOne(targetEntity = Service.class)
    @JoinColumn(name = "service_id",referencedColumnName = "serviceId")
    private Service service;

    @JsonBackReference
    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    private Set<ContractDetail> contractDetailSet;

    public Contract() {
    }

    public Contract(int contractId, String contractStartDate, String contractEndDate, double contractDeposit, double contractTotalMoney, Employee employee, Customer customer, Service service, Set<ContractDetail> contractDetailSet) {
        this.contractId = contractId;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
        this.employee = employee;
        this.customer = customer;
        this.service = service;
        this.contractDetailSet = contractDetailSet;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
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

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Set<ContractDetail> getContractDetailSet() {
        return contractDetailSet;
    }

    public void setContractDetailSet(Set<ContractDetail> contractDetailSet) {
        this.contractDetailSet = contractDetailSet;
    }
}
