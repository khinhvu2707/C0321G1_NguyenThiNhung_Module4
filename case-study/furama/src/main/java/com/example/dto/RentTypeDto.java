package com.example.dto;


public class RentTypeDto {

    private Long RentTypeId;
    private String rentTypeName;
    private double rentTypeCost;

    public RentTypeDto() {
    }

    public RentTypeDto(Long rentTypeId, String rentTypeName, double rentTypeCost) {
        RentTypeId = rentTypeId;
        this.rentTypeName = rentTypeName;
        this.rentTypeCost = rentTypeCost;
    }

    public Long getRentTypeId() {
        return RentTypeId;
    }

    public void setRentTypeId(Long rentTypeId) {
        RentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public double getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(double rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }
}
