package com.example.dto;

import com.example.model.entity.CustomerType;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CustomerDto {
    private Long customerId;
    @NotBlank(message = "Mã khách hàng không được để trống!")
    @Pattern(regexp = "^KH-\\d{4}$", message = "Mã khách hàng phải đúng định dạng KH-xxxx")
    private String customerCode;
    private CustomerType customerType;
    @NotBlank(message = "Tên không được để trống!")
    private String customerName;
    @Column(columnDefinition = "DATE")
    @NotBlank(message = "Ngày sinh không được để trống!")
    private String customerBirthday;
    @NotNull(message = "Giới tính không được để trống!")
    private int customerGender;
    @Pattern(regexp = "^\\d{9}|\\d{12}$", message = "scmnd phải đúng định dạng 9 hoặc 12 số")
    private String customerIdCard;
    @Pattern(regexp = "^090\\d{7}|\\(84\\)\\+90\\d{7}|091\\d{7}|\\(84\\)\\+91\\d{7}$",message = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String customerPhone;
    @NotNull(message = "Email không được để trống!")
    @Email(message = "Email không đúng định dạng")
    private String customerEmail;
    @NotNull(message = "Địa chỉ không được để trống!")
    @NotBlank(message = "Địa chỉ không được để trống!")
    private String customerAddress;

    public CustomerDto() {
    }

    public CustomerDto(Long customerId, @NotBlank(message = "Mã khách hàng không được để trống!") @Pattern(regexp = "^KH-\\d{4}$", message = "Mã khách hàng phải đúng định dạng KH-xxxx") String customerCode, CustomerType customerType, @NotBlank(message = "Tên không được để trống!") String customerName, @NotBlank(message = "Ngày sinh không được để trống!") String customerBirthday, @NotNull(message = "Giới tính không được để trống!") int customerGender, @Pattern(regexp = "^\\d{9}|\\d{12}$", message = "Mã khách hàng phải đúng định dạng 9 hoặc 12 số") String customerIdCard, @Pattern(regexp = "^090\\d{7}|\\(84\\)\\+90\\d{7}|091\\d{7}|\\(84\\)\\+91\\d{7}$", message = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx") String customerPhone, @Email(message = "Email không đúng định dạng") String customerEmail, @NotBlank(message = "Địa chỉ không được để trống!") String customerAddress) {
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
