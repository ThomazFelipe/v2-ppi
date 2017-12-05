package com.unitri.ppi.v2.service.Impl;

import com.unitri.ppi.v2.data.domain.Instructor;
import com.unitri.ppi.v2.data.repository.InstructorRepository;
import com.unitri.ppi.v2.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {

    private InstructorRepository repository;

    @Autowired
    public InstructorServiceImpl (InstructorRepository repository) {

        this.repository = repository;
    }

    @Override
    public List< Instructor > getInstructors () {

        return repository.findAll();
    }

    @Override
    public Instructor getInstructorById (Long id) {

        return repository.findOne(id);
    }

    @Override
    @Transactional
    public Instructor saveAndFlush (Instructor instructor) {

        return repository.saveAndFlush(instructor);
    }

    @Override
    @Transactional
    public void delete (Long id) {

        repository.delete(id);
    }
}
