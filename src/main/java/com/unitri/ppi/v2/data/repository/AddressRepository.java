package com.unitri.ppi.v2.data.repository;

import com.unitri.ppi.v2.data.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository< Address, Long > {
}
