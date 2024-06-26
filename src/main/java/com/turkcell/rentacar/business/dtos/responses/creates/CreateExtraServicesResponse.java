package com.turkcell.rentacar.business.dtos.responses.creates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateExtraServicesResponse {
    private int id;
    private String name;
    private double price;
    private LocalDateTime createdDate;
}
