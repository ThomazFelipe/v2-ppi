package com.unitri.ppi.v2.service.Impl;

import com.unitri.ppi.v2.data.domain.Car;
import com.unitri.ppi.v2.data.repository.CarRepository;
import com.unitri.ppi.v2.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository repository;

    @Autowired
    public CarServiceImpl( CarRepository repository ) {

        this.repository = repository;
    }

    @Override
    public List< Car > getCars() {

        return repository.findAll();
    }

    @Override
    public Car getCarById( Long id ) {

        return repository.findOne( id );
    }

    @Override
    @Transactional
    public Car saveAndFlush( Car car ) {

        return repository.saveAndFlush( car );
    }

    @Override
    @Transactional
    public void delete( Long id ) {

        repository.delete( id );
    }
}
