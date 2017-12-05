package com.unitri.ppi.v2.data.repository;

import com.unitri.ppi.v2.data.domain.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository< Grade, Long > {
}
