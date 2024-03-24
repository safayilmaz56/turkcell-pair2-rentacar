package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.CarService;
import com.turkcell.rentacar.business.abstracts.ModelService;
import com.turkcell.rentacar.business.dtos.requests.creates.CreateCarRequest;
import com.turkcell.rentacar.business.dtos.responses.creates.CreatedCarResponse;
import com.turkcell.rentacar.business.dtos.responses.updates.UpdatedCarResponse;
import com.turkcell.rentacar.business.rules.CarBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.CarRepository;
import com.turkcell.rentacar.entities.concretes.Car;
import com.turkcell.rentacar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class CarManager implements CarService {
    private CarRepository carRepository;
    private ModelMapperService modelMapperService;
    private CarBusinessRules carBusinessRules;
    private ModelService modelService;


    @Override
    public CreatedCarResponse add(CreateCarRequest createCarRequest) {
        Car car = this.modelMapperService.forRequest().map(createCarRequest,Car.class);
        Model model = this.modelService.getByName(createCarRequest.getModelName());
        car.setCreatedDate(LocalDateTime.now());
        car.setModel(model);
        Car existsCar = this.carRepository.save(car);
        CreatedCarResponse createdCarResponse = this.modelMapperService.forResponse().map(existsCar,CreatedCarResponse.class);

        return createdCarResponse;
    }

    @Override
    public List<UpdatedCarResponse> getAll() {
        return null;
    }

    @Override
    public UpdatedCarResponse getById(int id) {
        return null;
    }

    @Override
    public CreatedCarResponse update(int id, CreateCarRequest createCarRequest) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<UpdatedCarResponse> getByModelName(String name) {
        return null;
    }
}
