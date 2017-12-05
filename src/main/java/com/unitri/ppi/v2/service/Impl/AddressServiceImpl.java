package com.unitri.ppi.v2.service.Impl;

import com.unitri.ppi.v2.data.domain.Address;
import com.unitri.ppi.v2.data.repository.AddressRepository;
import com.unitri.ppi.v2.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository repository;

    @Autowired
    public AddressServiceImpl (AddressRepository repository) {

        this.repository = repository;
    }

    @Override
    public List< Address > getAddresses () {

        return repository.findAll();
    }

    @Override
    public Address getAddressById (Long id) {

        return repository.findOne(id);
    }

    @Override
    @Transactional
    public Address saveAndFlush (Address address) {

        return repository.saveAndFlush(address);
    }

    @Override
    @Transactional
    public void delete (Long id) {

        repository.delete(id);
    }

}
