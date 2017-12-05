package com.unitri.ppi.v2.data.domain;

import javax.persistence.*;

@Entity
@Table( name = "ADDRESS" )
public class Address {

    @Id
    @Column( name = "ID" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @OneToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "CITY_ID" )
    private City city;

    @Column( name = "STREET" )
    private String street;

    @Column( name = "NUMBER" )
    private Long number;

    @Column( name = "COMPLEMENT" )
    private String complement;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity( City city ) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet( String street ) {
        this.street = street;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber( Long number ) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement( String complement ) {
        this.complement = complement;
    }
}
