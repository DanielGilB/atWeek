package com.atSistemas.atWeek.model.dto;

import lombok.Data;

@Data
public class RentalDTO {

    private Integer id;
    private String startDate;
    private String endDate;
    private Double price;
    private CarDTO car;
    private ClientDTO client;
}
