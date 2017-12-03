package com.unitri.ppi.v2.service;

import com.unitri.ppi.v2.data.domain.Student;

import java.util.List;

public interface StudentService {

    List< Student > getStudents();

    Student getStudentById( Long id );

    Student saveAndFlush( Student student );

    void delete( Long id );
}
