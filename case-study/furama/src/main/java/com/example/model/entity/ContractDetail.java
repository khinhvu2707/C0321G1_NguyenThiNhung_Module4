package com.example.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name="contractDetail")
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contractDetailId;
    @JsonManagedReference
    @ManyToOne(targetEntity = Contract.class)
    @JoinColumn(name = "contract_id",referencedColumnName = "contractId")
    private Contract contract;
    @JsonManagedReference
    @ManyToOne(targetEntity = AttachService.class)
    @JoinColumn(name = "attachService_id",referencedColumnName = "attachServiceId")
    private AttachService attachService;
    private int quantity;

    public ContractDetail() {
    }

    public ContractDetail(Long contractDetailId, Contract contract, AttachService attachService, int quantity) {
        this.contractDetailId = contractDetailId;
        this.contract = contract;
        this.attachService = attachService;
        this.quantity = quantity;
    }

    public Long getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Long contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
