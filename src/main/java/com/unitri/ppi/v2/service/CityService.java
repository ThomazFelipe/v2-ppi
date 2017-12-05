package com.unitri.ppi.v2.service;

import com.unitri.ppi.v2.data.domain.City;

import java.util.List;

public interface CityService {

    List< City > getCities ();

    City getCityById (Long id);

    City saveAndFlush (City city);

    void delete (Long id);
}
