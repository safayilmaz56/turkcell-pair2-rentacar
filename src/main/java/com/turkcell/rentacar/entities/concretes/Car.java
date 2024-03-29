package com.turkcell.rentacar.entities.concretes;

import com.turkcell.rentacar.core.entities.BaseEntity;
import com.turkcell.rentacar.entities.enums.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="cars")
public class Car extends BaseEntity {
    @Column(name = "modelYear")
    private int modelYear;

    @Column(name = "minimumFindexScore")
    private double minimumFindexScore;

    @Column(name = "state")//1-Available 2-Rented 3-Under Maintenance
    private State state = State.Available;

    @Column(name = "dailyPrice")
    private double dailyPrice;

    @ManyToOne
    @JoinColumn(name = "modelId")
    private Model model;

    @OneToMany(mappedBy = "car")
    private List<Maintenance> maintenances;

    @OneToMany(mappedBy = "car")
    private List<Rental> rentals;

    @OneToMany(mappedBy = "car")
    private List<Payment> payment;

}
