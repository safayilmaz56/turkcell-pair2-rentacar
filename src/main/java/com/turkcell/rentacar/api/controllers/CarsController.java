package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.CarService;
import com.turkcell.rentacar.business.dtos.requests.creates.CreateCarRequest;
import com.turkcell.rentacar.business.dtos.responses.creates.CreatedCarResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/cars")
public class CarsController {
    private CarService carService;

    @PostMapping("/add")
    public CreatedCarResponse add(@Valid @RequestBody CreateCarRequest createCarRequest){
        return this.carService.add(createCarRequest);
    }
}
