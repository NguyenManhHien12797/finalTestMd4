package com.example.finaltestmd4.service;

import com.example.finaltestmd4.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICityService extends IGeneralService<City>{
    Page<City> findAll(Pageable pageable);
}
