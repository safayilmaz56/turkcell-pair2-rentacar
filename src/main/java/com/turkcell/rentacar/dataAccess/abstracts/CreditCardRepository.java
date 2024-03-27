package com.turkcell.rentacar.dataAccess.abstracts;

import com.turkcell.rentacar.entities.concretes.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard,Integer> {
}
