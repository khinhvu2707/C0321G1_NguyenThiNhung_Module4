package com.example.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="attachService")
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private int attachServiceId;
private String attachServiceName;
private double attachServiceCost;
private int attachServiceUnit;
private String attachServiceStatus;

    @JsonBackReference
    @OneToMany(mappedBy = "attachService", cascade = CascadeType.ALL)
    private Set<ContractDetail> contractDetailSet;
    public AttachService() {
    }

    public AttachService(int attachServiceId, String attachServiceName, double attachServiceCost, int attachServiceUnit, String attachServiceStatus, Set<ContractDetail> contractDetailSet) {
        this.attachServiceId = attachServiceId;
        this.attachServiceName = attachServiceName;
        this.attachServiceCost = attachServiceCost;
        this.attachServiceUnit = attachServiceUnit;
        this.attachServiceStatus = attachServiceStatus;
        this.contractDetailSet = contractDetailSet;
    }

    public int getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(int attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public double getAttachServiceCost() {
        return attachServiceCost;
    }

    public void setAttachServiceCost(double attachServiceCost) {
        this.attachServiceCost = attachServiceCost;
    }

    public int getAttachServiceUnit() {
        return attachServiceUnit;
    }

    public void setAttachServiceUnit(int attachServiceUnit) {
        this.attachServiceUnit = attachServiceUnit;
    }

    public String getAttachServiceStatus() {
        return attachServiceStatus;
    }

    public void setAttachServiceStatus(String attachServiceStatus) {
        this.attachServiceStatus = attachServiceStatus;
    }

    public Set<ContractDetail> getContractDetailSet() {
        return contractDetailSet;
    }

    public void setContractDetailSet(Set<ContractDetail> contractDetailSet) {
        this.contractDetailSet = contractDetailSet;
    }
}
