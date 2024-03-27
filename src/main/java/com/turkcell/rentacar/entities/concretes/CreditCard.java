package com.turkcell.rentacar.entities.concretes;

import com.turkcell.rentacar.core.entities.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "creditCards")
public class CreditCard extends BaseEntity {

    @Column(name = "cardHolderName")
    private String cardHolderName;

    @Column(name = "cardNumber")
    private String cardNumber;

    @Pattern(regexp = "\\d{3}", message = "CVV must be 3 digits")
    @Column(name = "cvv")
    private String cvv;

    @Pattern(regexp = "(0[1-9]|1[0-2])/[0-9]{2}", message = "Expiration date must be in the format MM/YY")
    @Column(name = "expirationDate")
    private String expirationDate;

    @ManyToOne
    @JoinColumn(name = "personalCustomerId")
    private PersonalCustomer personalCustomer;


    @ManyToOne
    @JoinColumn(name = "corporateCustomerId")
    private CorporateCustomer corporateCustomer;
}
