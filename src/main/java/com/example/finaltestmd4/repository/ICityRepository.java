package com.example.finaltestmd4.repository;

import com.example.finaltestmd4.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepository extends PagingAndSortingRepository<City,Long> {
    Page<City> findAll(Pageable pageable);
}
