package com.unitri.ppi.v2.service;

import com.unitri.ppi.v2.data.domain.Grade;

import java.util.List;

public interface GradeService {

    List< Grade > getGrades ();

    Grade getGradeById (Long id);

    Grade saveAndFlush (Grade grade);

    void delete (Long id);
}
