package com.turkcell.rentacar.business.dtos.responses.getById;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class GetByIdPaymentResponse {
    private int id;
    private String paymentState;
    private double amount;
    private String cardHolderName;
    private String cardNumber;
    private String cvv;
    private String expirationDate;
    private int dayOfRent;
    private int carId;
    private int personalCustomerId;
    private int corporateCustomerId;
    private int extraServiceId;
    private LocalDateTime createdDate;
}
