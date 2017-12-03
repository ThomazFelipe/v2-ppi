package com.unitri.ppi.v2.data.domain;

import javax.persistence.*;

@Entity
@Table( name = "INSTRUCTOR" )
public class Instructor {

    @Id
    @Column( name = "ID" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column( name = "NAME" )
    private String name;

    @OneToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "ADDRESS_ID" )
    private Address address;

    public Long getId() {

        return id;
    }

    public Instructor id( Long id ) {

        this.id = id;
        return this;
    }

    public String getName() {

        return name;
    }

    public Instructor name( String name ) {

        this.name = name;
        return this;
    }

    public Address getAddress() {

        return address;
    }

    public Instructor address( Address address ) {

        this.address = address;
        return this;
    }
}
