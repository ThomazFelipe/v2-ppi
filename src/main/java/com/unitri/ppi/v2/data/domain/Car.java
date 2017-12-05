package com.unitri.ppi.v2.data.domain;

import javax.persistence.*;

@Entity
@Table( name = "CAR" )
public class Car {

    @Id
    @Column( name = "ID" )
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column( name = "BOARD" )
    private String board;

    @Column( name = "MODEL" )
    private String model;

    public Long getId () {

        return id;
    }

    public Car id (Long id) {

        this.id = id;
        return this;
    }

    public String getBoard () {

        return board;
    }

    public Car board (String board) {

        this.board = board;
        return this;
    }

    public String getModel () {

        return model;
    }

    public Car model (String model) {

        this.model = model;
        return this;
    }
}
