package com.example.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="customerType")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerTypeId;
    private String customerTypeName;

    @JsonBackReference
    @OneToMany(mappedBy = "customerType", cascade = CascadeType.ALL)
    private Set<Customer> customerSet;
    public CustomerType() {
    }

    public CustomerType(int customerTypeId, String customerTypeName) {
        this.customerTypeId = customerTypeId;
        this.customerTypeName = customerTypeName;
    }

    public int getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(int customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }
}
