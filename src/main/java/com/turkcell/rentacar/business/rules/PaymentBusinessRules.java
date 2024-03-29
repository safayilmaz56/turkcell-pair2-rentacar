package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.business.dtos.requests.creates.CreatePaymentRequest;
import com.turkcell.rentacar.business.messages.PaymentMessages;
import com.turkcell.rentacar.core.adapter.abstracts.CustomerPaymentService;
import com.turkcell.rentacar.core.adapter.abstracts.FindexService;
import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.CarRepository;
import com.turkcell.rentacar.dataAccess.abstracts.CorporateCustomerRepository;
import com.turkcell.rentacar.dataAccess.abstracts.PaymentRepository;
import com.turkcell.rentacar.dataAccess.abstracts.PersonCustomerRepository;
import com.turkcell.rentacar.entities.concretes.Car;
import com.turkcell.rentacar.entities.concretes.CorporateCustomer;
import com.turkcell.rentacar.entities.concretes.Payment;
import com.turkcell.rentacar.entities.concretes.PersonalCustomer;
import com.turkcell.rentacar.entities.enums.PaymentState;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class PaymentBusinessRules {
    private PaymentRepository paymentRepository;
    private CustomerPaymentService customerPaymentService;
    private CarRepository carRepository;
    private CorporateCustomerRepository corporateCustomerRepository;
    private PersonCustomerRepository personCustomerRepository;
    private FindexService findexService;
    public void paymentIsAlreadyDone(int id){
        Optional<Payment> payment=this.paymentRepository.findById(id);
        if (payment.get().getPaymentState().equals(PaymentState.PaymentIsSuccessful)){
            throw new BusinessException(PaymentMessages.paymentIsAlreadyDone);
        }
    }
    public void paymentIsAlreadyCancelled(int id){
        Optional<Payment> payment=this.paymentRepository.findById(id);
        if (payment.get().getPaymentState().equals(PaymentState.PaymentIsCancelled)){
            throw new BusinessException(PaymentMessages.paymentIsAlreadyCancelled);
        }
    }
    public void idIsNotExists(int id){
        Optional<Payment> payment = this.paymentRepository.findById(id);
        if (payment.isEmpty()){
            throw new BusinessException(PaymentMessages.idIsNotExists);
        }
    }

    public void checkCreditCartInformation(CreatePaymentRequest createPaymentRequest){
        String message = customerPaymentService.information(createPaymentRequest);
        if (message.equals(PaymentMessages.incorrectInformation)){
            throw new BusinessException(PaymentMessages.incorrectInformation);
        }
    }

    public void checkCreditCardBudget(double amount){
        String message = customerPaymentService.sendBudgetCheck(amount);
        if (message.equals(PaymentMessages.insufficientBudget)){
            throw new BusinessException(PaymentMessages.insufficientBudget);
        }
    }

    public void findexScoreisNotEnoughforPerson(int id,String nationalId) {
        this.findexService.calculateFindexScoreforPerson(nationalId);
        Optional<PersonalCustomer> personCustomer = this.personCustomerRepository.findByNationalNumber(nationalId);
        Car car = this.carRepository.findById(id).get();
        if(car.getMinimumFindexScore() >= personCustomer.get().getFindexScore()); {
            throw new BusinessException(PaymentMessages.findexScoreisNotEnough);
        }
    }
    public void findexScoreisNotEnoughforCorporate(int id, String taxIdNumber ) {
        this.findexService.calculateFindexScoreforCorporate(taxIdNumber);
        Optional<CorporateCustomer> corporateCustomer = this.corporateCustomerRepository.findByTaxIdNumber(taxIdNumber);
        Optional<Car> car=this.carRepository.findById(id);
        if(car.get().getMinimumFindexScore() >= corporateCustomer.get().getFindexScore());{
            throw new BusinessException(PaymentMessages.findexScoreisNotEnough);
        }
    }
}