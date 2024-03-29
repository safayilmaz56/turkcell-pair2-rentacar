package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.business.dtos.requests.creates.CreateRentalforCorporateRequest;
import com.turkcell.rentacar.business.dtos.requests.creates.CreateRentalforPersonRequest;
import com.turkcell.rentacar.business.messages.RentalMessages;
import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.CarRepository;
import com.turkcell.rentacar.dataAccess.abstracts.RentalRepository;
import com.turkcell.rentacar.entities.concretes.Car;
import com.turkcell.rentacar.entities.concretes.Rental;
import com.turkcell.rentacar.entities.enums.PaymentState;
import com.turkcell.rentacar.entities.enums.State;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RentalBusinessRules {
    private RentalRepository rentalRepository;
    private CarRepository carRepository;

     public void idIsNotExists (int id){
        Optional<Rental> rental=this.rentalRepository.findById(id);
        if(rental.isEmpty()){
            throw new BusinessException(RentalMessages.idIsnotExists);
        }
    }
    public void currentlyRented (int id){
        Optional<Car> car=this.carRepository.findById(id);
        if (car.get().getState().equals(State.Rented)){
            throw new BusinessException(RentalMessages.carIsCurrentlyRented);
        }
    }
    public void currentlyUnderMaintenance (int id){
        Optional<Car> car=this.carRepository.findById(id);
        if (car.get().getState().equals(State.UnderMaintenance)){
            throw new BusinessException(RentalMessages.carIsCurrentlyUnderMaintance);
        }
    }

    public void paymentIsDoneForPerson(Rental rental){
         if (!rental.getPayment().getPaymentState().equals(PaymentState.PaymentIsSuccessful)){
             throw new BusinessException(RentalMessages.paymentIsNotDone);
         }
    }
    public void paymentIsDoneForCorporate(Rental rental){
        if (!rental.getPayment().getPaymentState().equals(PaymentState.PaymentIsSuccessful)){
            throw new BusinessException(RentalMessages.paymentIsNotDone);
        }
    }
}
