package com.unitri.ppi.v2.service;

import com.unitri.ppi.v2.data.domain.Car;

import java.util.List;

public interface CarService {

    List< Car > getCars();

    Car getCarById( Long id );

    Car saveAndFlush( Car car );

    void delete( Long id );
}
