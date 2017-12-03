package com.unitri.ppi.v2.service;

import java.util.List;
import com.unitri.ppi.v2.data.domain.Class;

public interface ClassService {

    List< Class > getClasses();

    Class getClassById( Long id );

    Class saveAndFlush( Class clas );

    void delete( Long id );
}
