package com.unitri.ppi.v2.controller;

import com.unitri.ppi.v2.data.domain.Car;
import com.unitri.ppi.v2.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/car" )
public class CarController {

    private CarService service;

    @Autowired
    public CarController( CarService service ) {

        this.service = service;
    }

    @GetMapping
    public ResponseEntity getCars() {

        try {

            return ResponseEntity.ok().body( service.getCars() );
        } catch( Exception e ) {

            return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR ).build();
        }
    }

    @GetMapping( "/{id}" )
    public ResponseEntity getCarById( Long id ) {

        try {

            return ResponseEntity.ok().body( service.getCarById( id ) );
        } catch( Exception e ) {

            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity save( Car car ) {

        try {

            return ResponseEntity.ok().body( service.saveAndFlush( car ) );
        } catch( Exception e ) {

            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity update( Car car ) {

        try {

            return ResponseEntity.ok().body( service.saveAndFlush( car ) );
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
