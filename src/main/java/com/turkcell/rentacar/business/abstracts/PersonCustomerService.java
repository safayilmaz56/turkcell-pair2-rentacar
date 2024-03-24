package com.turkcell.rentacar.business.abstracts;

import java.util.List;

import com.turkcell.rentacar.business.dtos.requests.creates.CreatePersonCustomerRequest;
import com.turkcell.rentacar.business.dtos.requests.updates.UpdatePersonCustomerRequest;
import com.turkcell.rentacar.business.dtos.responses.creates.CreatedPersonCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.updates.UpdatedPersonCustomerResponse;

public interface PersonCustomerService {
	CreatedPersonCustomerResponse add(CreatePersonCustomerRequest createPersonCustomerRequest);
	List<UpdatedPersonCustomerResponse> getall();
	UpdatedPersonCustomerResponse getById(int id);
	void delete(int id);
	UpdatedPersonCustomerResponse update(UpdatePersonCustomerRequest updatePersonCustomerRequest);

}
