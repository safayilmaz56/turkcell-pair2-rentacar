package com.turkcell.rentacar.entities.concretes;

import com.turkcell.rentacar.core.entities.BaseCustomerEntitity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="personalCustomers")
public class PersonalCustomer extends BaseCustomerEntitity{

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name ="nationalId")
	private String nationalId;

	@OneToMany(mappedBy = "personalCustomer")
	private List<Rental> rentals;
}
