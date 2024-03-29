package com.turkcell.rentacar.core.adapter.abstracts;

import com.turkcell.rentacar.business.dtos.requests.creates.CreatePaymentRequest;

public interface CustomerPaymentService {
    boolean sendInformationCheck(String cardHolderName, String cardNumber, String cvv, String expirationDate);
    String information(CreatePaymentRequest createPaymentRequest);
    String sendBudgetCheck(double amount);
}