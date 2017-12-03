package com.unitri.ppi.v2.data.repository;

import com.unitri.ppi.v2.data.domain.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository< Instructor, Long > {
}
