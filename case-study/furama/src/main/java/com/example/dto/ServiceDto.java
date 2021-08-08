package com.example.dto;


import com.example.model.entity.RentType;
import com.example.model.entity.ServiceType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ServiceDto {
    private Long serviceId;
    @NotBlank(message = "Please fill out the form")
    @Pattern(regexp = "^DV-\\d{4}$", message = "Mã dịch vụ phải đúng định dạng DV-xxxx")
    private String serviceCode;
    @NotBlank(message = "Please fill out the form")
    private String serviceName;
    @NotNull(message = "Please fill out the form")
    @Min(0)
    private int serviceArea;
    @NotNull(message = "Please fill out the form")
    @Min(0)
    private double serviceCost;
    @NotNull(message = "Please fill out the form")
    @Min(0)
    private int serviceMaxPeople;
    private RentType rentType;
    private ServiceType serviceType;
    @NotBlank(message = "Please fill out the form")
    private String standardRoom;
    @NotBlank(message = "Please fill out the form")
    private String descriptionOtherConvenience;
    @NotNull(message = "Please fill out the form")
    @Min(0)
    private double poolArea;
    @NotNull(message = "Please fill out the form")
    @Min(0)
    private int numberOfFloor;
    private int flag;

    public ServiceDto() {
    }

    public ServiceDto(Long serviceId, String serviceCode, String serviceName, int serviceArea, double serviceCost, int serviceMaxPeople, RentType rentType, ServiceType serviceType, String standardRoom, String descriptionOtherConvenience,double poolArea,int numberOfFloor,int flag) {
        this.serviceId = serviceId;
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.rentType = rentType;
        this.serviceType = serviceType;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
        this.flag = flag;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(int serviceArea) {
        this.serviceArea = serviceArea;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public int getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(int serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

}
