package com.atSistemas.atWeek.model.dto;

import lombok.Data;

@Data
public class RateDTO {

    private Integer id;
    private String startDate;
    private String endDate;
    private Double price;
}
