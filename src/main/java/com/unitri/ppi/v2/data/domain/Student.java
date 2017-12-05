package com.unitri.ppi.v2.data.domain;

import javax.persistence.*;

@Entity
@Table( name = "STUDENT" )
public class Student {

    @Id
    @Column( name = "ID" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column( name = "NAME" )
    private String name;

    @OneToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "ADDRESS_ID" )
    private Address address;

    @Column( name = "STATUS" )
    @Enumerated( EnumType.STRING )
    private StatusEnum status;

    public Long getId () {

        return id;
    }

    public Student id (Long id) {

        this.id = id;
        return this;
    }

    public String getName () {

        return name;
    }

    public Student name (String name) {

        this.name = name;
        return this;
    }

    public Address getAddress () {

        return address;
    }

    public Student address (Address address) {

        this.address = address;
        return this;
    }

    public StatusEnum getStatus () {

        return status;
    }

    public Student status (StatusEnum status) {

        this.status = status;
        return this;
    }
}
