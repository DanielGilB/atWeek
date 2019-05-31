package com.atSistemas.atWeek.model.dto;

import lombok.Data;

@Data
public class RateDto {

    private Integer id;
    private String startDate;
    private String endDate;
    private Double price;
}
