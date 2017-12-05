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

    public void setId( Long id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress( Address address ) {
        this.address = address;
    }
}
