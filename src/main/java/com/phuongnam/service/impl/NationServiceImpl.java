package com.phuongnam.service.impl;

import com.phuongnam.model.Nation;
import com.phuongnam.repository.NationRepository;
import com.phuongnam.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NationServiceImpl implements NationService {
    @Autowired
    private NationRepository nationRepository;
    @Override
    public Iterable<Nation> findAll() {
        return nationRepository.findAll();
    }

    @Override
    public Nation findById(Long id) {
        return nationRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Nation nation) {
        nationRepository.save(nation);
    }

    @Override
    public void remove(Long id) {
        nationRepository.deleteById(id);
    }
}
