package com.unitri.ppi.v2.data.repository;

import com.unitri.ppi.v2.data.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository < City, Long > {
}
