package com.unitri.ppi.v2.controller;

import com.unitri.ppi.v2.data.domain.City;
import com.unitri.ppi.v2.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/city" )
public class CityController {

    private CityService service;

    @Autowired
    public CityController( CityService service ) {

        this.service = service;
    }

    @GetMapping
    public ResponseEntity getCities() {

        try {

            return ResponseEntity.ok().body( service.getCities() );
        } catch( Exception e ) {

            return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR ).build();
        }
    }

    @GetMapping( "/{id}" )
    public ResponseEntity getCityById( Long id ) {

        try {

            return ResponseEntity.ok().body( service.getCityById( id ) );
        } catch( Exception e ) {

            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity save( City city ) {

        try {

            return ResponseEntity.ok().body( service.saveAndFlush( city ) );
        } catch( Exception e ) {

            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity update( City city ) {

        try {

            return ResponseEntity.ok().body( service.saveAndFlush( city ) );
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
