package com.example.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="rentType")
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int RentTypeId;
    private String rentTypeName;
    private double rentTypeCost;

    @JsonBackReference
    @OneToMany(mappedBy = "rentType", cascade = CascadeType.ALL)
    private Set<Service> serviceSet;
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
