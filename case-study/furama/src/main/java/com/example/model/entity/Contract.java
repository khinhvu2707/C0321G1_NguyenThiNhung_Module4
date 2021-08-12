package com.example.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contractId;
    @Column(columnDefinition = "DATETIME")
    private String contractStartDate;
    @Column(columnDefinition = "DATETIME")
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
    @ManyToOne(targetEntity = Services.class)
    @JoinColumn(name = "service_id",referencedColumnName = "serviceId")
    private Services services;
    @JsonBackReference
    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    private List<ContractDetail> contractDetailList;
    private int flag;
    private String listAttachService;
    public Contract() {
    }

    public Contract(Long contractId, String contractStartDate, String contractEndDate, double contractDeposit, double contractTotalMoney, Employee employee, Customer customer, Services services, List<ContractDetail> contractDetailList, int flag, String listAttachService) {
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
