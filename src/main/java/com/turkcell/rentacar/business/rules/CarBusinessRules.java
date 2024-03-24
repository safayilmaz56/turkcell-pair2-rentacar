package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.business.messages.CarMessages;
import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.CarRepository;
import com.turkcell.rentacar.entities.concretes.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CarBusinessRules {
    private CarRepository carRepository;

    public void idIsNotExists(int id){
        Optional<Car> car = this.carRepository.findById(id);
        if (car.isEmpty()){
            throw new BusinessException(CarMessages.idIsNotExists);
        }
    }
}
