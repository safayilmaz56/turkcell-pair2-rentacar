package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.business.dtos.requests.creates.CreateBrandRequest;
import com.turkcell.rentacar.business.dtos.requests.updates.UpdateBrandRequest;
import com.turkcell.rentacar.business.dtos.responses.updates.UpdatedBrandResponse;
import com.turkcell.rentacar.business.rules.BrandBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.BrandRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BrandManager implements BrandService {
    private final BrandRepository brandRepository;
    private final ModelMapperService modelMapperService;
    private final BrandBusinessRules brandBusinessRules;

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        this.brandBusinessRules.brandNameCanNotBeDuplicated(createBrandRequest.getName());


        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        brand.setCreatedDate(LocalDateTime.now());

        this.brandRepository.save(brand);
    }

    @Override
    public UpdatedBrandResponse getById(int id) {
        this.brandBusinessRules.idIsNotExists(id);
        Brand brand = this.brandRepository.findById(id).get();
        UpdatedBrandResponse updatedBrandResponse = this.modelMapperService.forResponse().map(brand,UpdatedBrandResponse.class);
        return updatedBrandResponse;
    }

    @Override
    public List<UpdatedBrandResponse> getAll() {
        List<UpdatedBrandResponse> updatedBrandResponseList = new ArrayList<>();
        List<Brand> brands = this.brandRepository.findAll();
        for (Brand brand:brands){
            UpdatedBrandResponse updatedBrandResponse = this.modelMapperService.forResponse().map(brand,UpdatedBrandResponse.class);
            updatedBrandResponseList.add(updatedBrandResponse);
        }
        return updatedBrandResponseList;
    }

    @Override
    @Transactional
    public UpdatedBrandResponse update(int id, UpdateBrandRequest updateBrandRequest) {
        this.brandBusinessRules.idIsNotExists(id);
        this.brandBusinessRules.brandNameCanNotBeDuplicated(updateBrandRequest.getName());

        Brand existsBrand = this.brandRepository.findById(id).get();
        existsBrand.setName(updateBrandRequest.getName());
        existsBrand.setUpdatedDate(LocalDateTime.now());
        Brand updatedBrand = this.brandRepository.save(existsBrand);
        UpdatedBrandResponse updatedBrandResponse = this.modelMapperService.forResponse().map(updatedBrand, UpdatedBrandResponse.class);
        return updatedBrandResponse;
    }

    @Override
    @Transactional
    public void delete(int id) {
        this.brandBusinessRules.idIsNotExists(id);
        Brand brand = this.brandRepository.findById(id).get();
        this.brandRepository.delete(brand);
    }

    @Override
    public Brand getByName(String brandName) {
        this.brandBusinessRules.brandNameIsNotExists(brandName);
        Brand brand = this.brandRepository.findByNameIgnoreCase(brandName).get();
        return brand;
    }
}