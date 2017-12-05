package com.unitri.ppi.v2.service.Impl;

import com.unitri.ppi.v2.data.domain.Student;
import com.unitri.ppi.v2.data.repository.StudentRepository;
import com.unitri.ppi.v2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository repository;

    @Autowired
    public StudentServiceImpl (StudentRepository repository) {

        this.repository = repository;
    }

    @Override
    public List< Student > getStudents () {

        return repository.findAll();
    }

    @Override
    public Student getStudentById (Long id) {

        return repository.findOne(id);
    }

    @Override
    @Transactional
    public Student saveAndFlush (Student student) {

        return repository.saveAndFlush(student);
    }

    @Override
    public void delete (Long id) {

        repository.delete(id);
    }
}
