package com.example.dto;


public class PositionDto {
    private Long positionId;
    private String positionName;

    public PositionDto() {
    }

    public PositionDto(Long positionId, String positionName) {
        this.positionId = positionId;
        this.positionName = positionName;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
