package com.unitri.ppi.v2.data.repository;

import com.unitri.ppi.v2.data.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository< Car, Long > {
}
