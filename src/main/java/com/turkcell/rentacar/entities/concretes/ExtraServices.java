package com.turkcell.rentacar.entities.concretes;

import com.turkcell.rentacar.core.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "extra_services")
public class ExtraServices extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price = 0;

    @OneToMany(mappedBy = "extraServices")
    private List<Payment> payment;
}
