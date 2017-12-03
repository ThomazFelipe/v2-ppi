package com.unitri.ppi.v2.service;

import com.unitri.ppi.v2.data.domain.Instructor;

import java.util.List;

public interface InstructorService {

    List< Instructor > getInstructors();

    Instructor getInstructorById( Long id );

    Instructor saveAndFlush( Instructor instructor );

    void delete( Long id );
}
