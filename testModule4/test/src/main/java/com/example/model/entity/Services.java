package com.example.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;
    private String serviceName;
    @JsonBackReference
    @OneToMany(mappedBy = "services")
    private Set<Deal> dealSet;

    public Services() {
    }

    public Services(Long serviceId, String serviceName, Set<Deal> dealSet) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.dealSet = dealSet;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Set<Deal> getDealSet() {
        return dealSet;
    }

    public void setDealSet(Set<Deal> dealSet) {
        this.dealSet = dealSet;
    }
}
