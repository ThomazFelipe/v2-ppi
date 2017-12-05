package com.unitri.ppi.v2.data.repository;

import com.unitri.ppi.v2.data.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository< Student, Long > {
}
