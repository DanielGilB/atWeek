package com.atSistemas.atWeek.model.dto;

import com.atSistemas.atWeek.model.entity.Car;
import com.atSistemas.atWeek.model.entity.Client;
import lombok.Data;

@Data
public class RentalDTO {


    private Integer id;
    private String startDate;
    private String endDate;
    private Double price;
    private Car car;
    private Client client;
}
