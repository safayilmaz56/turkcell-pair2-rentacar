package com.turkcell.rentacar.core.adapter.concretes;

import com.turkcell.rentacar.core.adapter.abstracts.ExternalPaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExternalPaymentManager implements ExternalPaymentService {

    @Override
    public boolean sendInformation(String cardHolderName, String cardNumber, String cvv, String expirationDate) {
        if (cardHolderName.equals("Safa Yılmaz") && cardNumber.equals("1234567891011145") && cvv.equals("111") && expirationDate.equals("05/31")){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean sendCheckBudget(double amount) {
        double budget = 40000;
        if (budget >= amount ){
            return true;
        }
        else {
            return false;
        }
    }
}
