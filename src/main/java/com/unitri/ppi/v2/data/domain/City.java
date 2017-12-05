package com.unitri.ppi.v2.data.domain;

import javax.persistence.*;

@Entity
@Table( name = "CITY" )
public class City {

    @Id
    @Column( name = "ID" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column( name = "NAME" )
    private String name;

    public Long getId () {

        return id;
    }

    public City id (Long id) {

        this.id = id;
        return this;
    }

    public String getName () {

        return name;
    }

    public City name (String name) {

        this.name = name;
        return this;
    }
}
