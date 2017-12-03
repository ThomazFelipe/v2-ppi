package com.unitri.ppi.v2.controller;

import com.unitri.ppi.v2.data.domain.Class;
import com.unitri.ppi.v2.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/class" )
public class ClassController {

    private ClassService service;

    @Autowired
    public ClassController( ClassService service ) {

        this.service = service;
    }

    @GetMapping
    public ResponseEntity get() {

        try {

            return ResponseEntity.ok().body( service.getClasses() );
        } catch( Exception e ) {

            return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR ).build();
        }
    }

    @GetMapping( "/{id}" )
    public ResponseEntity getClassById( Long id ) {

        try {

            return ResponseEntity.ok().body( service.getClassById( id ) );
        } catch( Exception e ) {

            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity save( Class clas ) {

        try {

            return ResponseEntity.ok().body( service.saveAndFlush( clas ) );
        } catch( Exception e ) {

            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity update( Class clas ) {

        try {

            return ResponseEntity.ok().body( service.saveAndFlush( clas ) );
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
