package com.phuongnam.service;

import com.phuongnam.model.Nation;
import org.springframework.stereotype.Service;

@Service
public interface NationService {
    Iterable<Nation> findAll();

    Nation findById(Long id);

    void save(Nation type);

    void remove(Long id);

}
