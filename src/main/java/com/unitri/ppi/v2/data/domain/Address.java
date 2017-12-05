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

    public Long getId () {
        return id;
    }

    public Address id (Long id) {

        this.id = id;
        return this;
    }

    public City getCity () {
        return city;
    }

    public Address city (City city) {

        this.city = city;
        return this;
    }

    public String getStreet () {
        return street;
    }

    public Address street (String street) {

        this.street = street;
        return this;
    }

    public Long getNumber () {
        return number;
    }

    public Address number (Long number) {

        this.number = number;
        return this;
    }

    public String getComplement () {
        return complement;
    }

    public Address complement (String complement) {

        this.complement = complement;
        return this;
    }
}
