package com.example.dto;


public class ContractDetailDto {
    private Long contractDetailId;
    private ContractDto contract;
    private AttachServiceDto attachService;
    private int quantity;

    public ContractDetailDto() {
    }

    public ContractDetailDto(Long contractDetailId, ContractDto contract, AttachServiceDto attachService, int quantity) {
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

    public ContractDto getContract() {
        return contract;
    }

    public void setContract(ContractDto contract) {
        this.contract = contract;
    }

    public AttachServiceDto getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachServiceDto attachService) {
        this.attachService = attachService;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
