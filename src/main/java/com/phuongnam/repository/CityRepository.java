package com.phuongnam.repository;

import com.phuongnam.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends PagingAndSortingRepository<City, Long> {
    Page<City> findAllByNameContainingIgnoreCase(String name, Pageable pageable);
}
