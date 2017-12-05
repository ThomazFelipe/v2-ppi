package com.unitri.ppi.v2.service.Impl;

import com.unitri.ppi.v2.data.domain.City;
import com.unitri.ppi.v2.data.repository.CityRepository;
import com.unitri.ppi.v2.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private CityRepository repository;

    @Autowired
    public CityServiceImpl (CityRepository repository) {

        this.repository = repository;
    }

    @Override
    public List< City > getCities () {
        return repository.findAll();
    }

    @Override
    public City getCityById (Long id) {
        return repository.findOne(id);
    }

    @Override
    @Transactional
    public City saveAndFlush (City city) {

        return repository.saveAndFlush(city);
    }

    @Override
    @Transactional
    public void delete (Long id) {
        repository.delete(id);
    }
}
