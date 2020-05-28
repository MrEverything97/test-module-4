package com.phuongnam.service;

import com.phuongnam.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface CityService {
    Page<City> findAll(Pageable pageable);

    Page<City> findAllByNameContainingIgnoreCase(String name, Pageable pageable);

    City findById(Long id);

    void save(City note);

    void remove(Long id);

}
