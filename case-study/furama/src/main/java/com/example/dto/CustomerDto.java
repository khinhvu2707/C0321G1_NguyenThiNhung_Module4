package com.example.dto;

import com.example.model.entity.CustomerType;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CustomerDto {
    private Long customerId;
    @NotBlank(message = "Please fill out the form")
    @Pattern(regexp = "^KH-\\d{4}$", message = "Not valid (KH-xxxx)")
    private String customerCode;
    private CustomerType customerType;
    @NotBlank(message = "Please fill out the form")
    private String customerName;
    @Column(columnDefinition = "DATE")
    @NotBlank(message = "Please fill out the form")
    private String customerBirthday;
    @NotNull(message = "Please fill out the form")
    private int customerGender;
    @Pattern(regexp = "^\\d{9}|\\d{12}$", message = "Id Card not valid (9 or 12 number)")
    private String customerIdCard;
    @Pattern(regexp = "^090\\d{7}|\\(84\\)\\+90\\d{7}|091\\d{7}|\\(84\\)\\+91\\d{7}$",message = "Telephone not valid (090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx)")
    private String customerPhone;
    @NotNull(message = "Please fill out the form")
    @Email(message = "Email not valid")
    private String customerEmail;
    @NotBlank(message = "Please fill out the form")
    private String customerAddress;
    private int flag;

    public CustomerDto() {
    }

    public CustomerDto(Long customerId,String customerCode, CustomerType customerType,String customerName, String customerBirthday, int customerGender,String customerIdCard, String customerPhone,  String customerEmail,  String customerAddress) {
        this.customerId = customerId;
        this.customerCode = customerCode;
        this.customerType = customerType;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }

    public CustomerDto(Long customerId,String customerCode, CustomerType customerType,String customerName, String customerBirthday, int customerGender,String customerIdCard, String customerPhone,  String customerEmail,  String customerAddress, int flag) {
        this.customerId = customerId;
        this.customerCode = customerCode;
        this.customerType = customerType;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.flag = flag;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public int getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(int customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

}
