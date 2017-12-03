package com.unitri.ppi.v2.service.Impl;

import com.unitri.ppi.v2.data.repository.ClassRepository;
import com.unitri.ppi.v2.data.domain.Class;
import com.unitri.ppi.v2.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    private ClassRepository repository;

    @Autowired
    public ClassServiceImpl( ClassRepository repository ) {

        this.repository = repository;
    }

    @Override
    public List< Class > getClasses() {

        return repository.findAll();
    }

    @Override
    public Class getClassById( Long id ) {

        return repository.findOne( id );
    }

    @Override
    @Transactional
    public Class saveAndFlush( Class clas ) {

        return repository.saveAndFlush( clas );
    }

    @Override
    @Transactional
    public void delete( Long id ) {

        repository.delete( id );
    }
}
