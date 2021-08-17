package com.example.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"dealCode"})})
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dealId;
    private String dealCode;
    @JsonManagedReference
    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customer", referencedColumnName = "customerId")
    private Customer customer;
    private String dateTime;
    @JsonManagedReference
    @ManyToOne(targetEntity = Services.class)
    @JoinColumn(name = "serviceId", referencedColumnName = "serviceId")
    private Services services;
    private double money;
    private double area;
    private int flag;

    public Deal() {
    }

    public Deal(Long dealId, String dealCode, Customer customer, String dateTime, Services services, double money, double area, int flag) {
        this.dealId = dealId;
        this.dealCode = dealCode;
        this.customer = customer;
        this.dateTime = dateTime;
        this.services = services;
        this.money = money;
        this.area = area;
        this.flag = flag;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Long getDealId() {
        return dealId;
    }

    public void setDealId(Long dealId) {
        this.dealId = dealId;
    }

    public String getDealCode() {
        return dealCode;
    }

    public void setDealCode(String dealCode) {
        this.dealCode = dealCode;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
