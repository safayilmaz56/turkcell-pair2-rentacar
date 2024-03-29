package com.turkcell.rentacar.core.adapter.abstracts;

import com.turkcell.rentacar.entities.concretes.Car;
import com.turkcell.rentacar.entities.concretes.PersonalCustomer;

import java.util.Optional;

public interface FindexService {
    double calculateFindexScoreforPerson(String nationalId);
    double calculateFindexScoreforCorporate(String TaxIdNumber);

}
