package com.example.dto;


public class RentType {

    private int RentTypeId;
    private String rentTypeName;
    private double rentTypeCost;

    public RentType() {
    }

    public RentType(int rentTypeId, String rentTypeName, double rentTypeCost) {
        RentTypeId = rentTypeId;
        this.rentTypeName = rentTypeName;
        this.rentTypeCost = rentTypeCost;
    }

    public int getRentTypeId() {
        return RentTypeId;
    }

    public void setRentTypeId(int rentTypeId) {
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
