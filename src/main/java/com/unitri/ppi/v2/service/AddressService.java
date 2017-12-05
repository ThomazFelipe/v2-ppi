package com.unitri.ppi.v2.service;

import com.unitri.ppi.v2.data.domain.Address;

import java.util.List;

public interface AddressService {

    List< Address > getAddresses ();

    Address getAddressById (Long id);

    Address saveAndFlush (Address address);

    void delete (Long id);
}
