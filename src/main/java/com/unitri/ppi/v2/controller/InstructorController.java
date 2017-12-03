package com.unitri.ppi.v2.controller;

import com.unitri.ppi.v2.data.domain.Instructor;
import com.unitri.ppi.v2.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/instructor" )
public class InstructorController {

    private InstructorService service;

    @Autowired
    public InstructorController( InstructorService service ) {

        this.service = service;
    }

    @GetMapping
    public ResponseEntity getInstructors() {

        try {

            return ResponseEntity.ok().body( service.getInstructors() );
        } catch( Exception e ) {

            return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR ).build();
        }
    }

    @GetMapping( "/{id}" )
    public ResponseEntity getInstructorById( Long id ) {

        try {

            return ResponseEntity.ok().body( service.getInstructorById( id ) );
        } catch( Exception e ) {

            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity save( Instructor instructor ) {

        try {

            return ResponseEntity.ok().body( service.saveAndFlush( instructor ) );
        } catch( Exception e ) {

            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity update( Instructor instructor ) {

        try {

            return ResponseEntity.ok().body( service.saveAndFlush( instructor ) );
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
