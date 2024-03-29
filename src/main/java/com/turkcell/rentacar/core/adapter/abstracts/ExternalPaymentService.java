package com.turkcell.rentacar.core.adapter.abstracts;

public interface ExternalPaymentService { //dış servis
    boolean sendInformation(String cardHolderName, String cardNumber, String cvv, String expirationDate);
    boolean sendCheckBudget(double amount);
}
