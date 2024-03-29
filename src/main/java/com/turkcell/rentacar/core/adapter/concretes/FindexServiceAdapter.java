package com.turkcell.rentacar.core.adapter.concretes;

import com.turkcell.rentacar.core.adapter.abstracts.CustomerFindexService;
import com.turkcell.rentacar.core.adapter.abstracts.FindexService;
import com.turkcell.rentacar.dataAccess.abstracts.CorporateCustomerRepository;
import com.turkcell.rentacar.dataAccess.abstracts.PersonCustomerRepository;
import com.turkcell.rentacar.entities.concretes.PersonalCustomer;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindexServiceAdapter implements FindexService{
    private PersonCustomerRepository personCustomerRepository;
    private CorporateCustomerRepository corporateCustomerRepository;
    @Override

    public double calculateFindexScoreforPerson(String nationalId) {

        // servis işlemleri

        double findexScore = 1600; // manuel olarak atadık şimdilik
        PersonalCustomer personalCustomer = personCustomerRepository.findByNationalNumber(nationalId).get();
        personalCustomer.setFindexScore(findexScore);
        this.personCustomerRepository.save(personalCustomer);
        return findexScore;
    }

    @Override
    public double calculateFindexScoreforCorporate(String TaxIdNumber) {
        double findexScore = 1450; // manuel olarak atadık şimdilik
        corporateCustomerRepository.findByTaxIdNumber(TaxIdNumber).get().setFindexScore(findexScore);
        return findexScore;
    }

}
