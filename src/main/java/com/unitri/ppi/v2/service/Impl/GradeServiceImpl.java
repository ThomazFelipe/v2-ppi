package com.unitri.ppi.v2.service.Impl;

import com.unitri.ppi.v2.data.domain.Grade;
import com.unitri.ppi.v2.data.repository.GradeRepository;
import com.unitri.ppi.v2.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    private GradeRepository repository;

    @Autowired
    public GradeServiceImpl (GradeRepository repository) {

        this.repository = repository;
    }

    @Override
    public List< Grade > getGrades () {

        return repository.findAll();
    }

    @Override
    public Grade getGradeById (Long id) {

        return repository.findOne(id);
    }

    @Override
    @Transactional
    public Grade saveAndFlush (Grade grade) {

        return repository.saveAndFlush(grade);
    }

    @Override
    @Transactional
    public void delete (Long id) {

        repository.delete(id);
    }
}
