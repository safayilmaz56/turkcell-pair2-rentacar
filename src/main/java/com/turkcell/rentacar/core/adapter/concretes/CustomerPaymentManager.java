package com.turkcell.rentacar.core.adapter.concretes;

import com.turkcell.rentacar.business.dtos.requests.creates.CreatePaymentRequest;
import com.turkcell.rentacar.business.messages.PaymentMessages;
import com.turkcell.rentacar.core.adapter.abstracts.CustomerPaymentService;
import com.turkcell.rentacar.core.adapter.abstracts.ExternalPaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerPaymentManager implements CustomerPaymentService {
    private ExternalPaymentService externalPaymentService;
    @Override
    public boolean sendInformationCheck(String cardHolderName, String cardNumber, String cvv, String expirationDate) {
        return externalPaymentService.sendInformation(cardHolderName,cardNumber,cvv,expirationDate);
    }

    @Override
    public String information(CreatePaymentRequest createPaymentRequest) {
        String cardHolderName = createPaymentRequest.getCardHolderName();
        String cardNumber = createPaymentRequest.getCardNumber();
        String cvv = createPaymentRequest.getCvv();
        String expirationDate = createPaymentRequest.getExpirationDate();;

        if (sendInformationCheck(cardHolderName,cardNumber,cvv,expirationDate)){
            return PaymentMessages.correctedInformation;
        }
        else {
            return PaymentMessages.incorrectInformation;
        }
    }

    @Override
    public String sendBudgetCheck(double amount) {
       if (externalPaymentService.sendCheckBudget(amount)){
           return PaymentMessages.sufficientBudget;
       }
       else {
           return PaymentMessages.insufficientBudget;
       }
    }
}
