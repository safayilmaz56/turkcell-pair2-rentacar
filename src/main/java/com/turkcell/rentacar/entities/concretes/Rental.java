package com.turkcell.rentacar.entities.concretes;

import com.turkcell.rentacar.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "rentals")
public class Rental extends BaseEntity {

    @Column(name = "startDate")
    private LocalDateTime startDate;

    @Column(name = "finishDate")
    private LocalDateTime finishDate;

    @ManyToOne
    @JoinColumn(name = "carId")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "personalCustomerId")
    private PersonalCustomer personalCustomer;

    @ManyToOne
    @JoinColumn(name = "corporateCustomerId")
    private CorporateCustomer corporateCustomer;
}
