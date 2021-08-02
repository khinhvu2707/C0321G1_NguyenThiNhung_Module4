package com.example.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "serviceType")
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceTypeId;
    private String serviceTypeName;

    @JsonBackReference
    @OneToMany(mappedBy = "serviceType", cascade = CascadeType.ALL)
    private Set<Service> serviceSet;
    public ServiceType() {
    }

    public ServiceType(int serviceTypeId, String serviceTypeName) {
        this.serviceTypeId = serviceTypeId;
        this.serviceTypeName = serviceTypeName;
    }

    public int getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(int serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }


}
