package com.example.dto;

import com.example.model.entity.AttachService;
import com.example.model.entity.Contract;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ContractDetailDto {
    private Long contractDetailId;
    private Contract contract;
    private AttachService attachService;
    @NotNull(message = "Không được để trống")
    @Min(0)
    private int quantity;

    public ContractDetailDto() {
    }

    public ContractDetailDto(Long contractDetailId, Contract contract, AttachService attachService, int quantity) {
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
