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

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard( String board ) {
        this.board = board;
    }

    public String getModel() {
        return model;
    }

    public void setModel( String model ) {
        this.model = model;
    }
}
