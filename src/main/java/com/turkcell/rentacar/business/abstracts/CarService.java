package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.creates.CreateCarRequest;
import com.turkcell.rentacar.business.dtos.responses.creates.CreatedCarResponse;
import com.turkcell.rentacar.business.dtos.responses.creates.CreatedModelResponse;
import com.turkcell.rentacar.business.dtos.responses.updates.UpdatedCarResponse;

import java.util.List;

public interface CarService {

    CreatedCarResponse add(CreateCarRequest createCarRequest);
    List<UpdatedCarResponse> getAll();
    UpdatedCarResponse getById(int id);
    CreatedCarResponse update(int id,CreateCarRequest createCarRequest);
    void delete(int id);
    List<UpdatedCarResponse> getByModelName(String name);
    //getall , getById, delete,update
}
