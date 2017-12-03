package com.unitri.ppi.v2.controller;

import com.unitri.ppi.v2.data.domain.Student;
import com.unitri.ppi.v2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/student" )
public class StudentController {

    private StudentService service;

    @Autowired
    public StudentController( StudentService service ) {

        this.service = service;
    }

    @GetMapping
    public ResponseEntity getStudents() {

        try {

            return ResponseEntity.ok().body( service.getStudents() );
        } catch( Exception e ) {

            return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR ).build();
        }
    }

    @GetMapping( "/{id}" )
    public ResponseEntity getStudentById( Long id ) {

        try {

            return ResponseEntity.ok().body( service.getStudentById( id ) );
        } catch( Exception e ) {

            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity save( Student student ) {

        try {

            return ResponseEntity.ok().body( service.saveAndFlush( student ) );
        } catch( Exception e ) {

            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity update( Student student ) {

        try {

            return ResponseEntity.ok().body( service.saveAndFlush( student ) );
        } catch( Exception e ) {

            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity delete( Long id ) {

        try {
            service.delete( id );
            return ResponseEntity.status( HttpStatus.OK ).build();
        } catch( Exception e ) {

            return ResponseEntity.badRequest().build();
        }
    }
}
