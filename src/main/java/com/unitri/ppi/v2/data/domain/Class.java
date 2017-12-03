package com.unitri.ppi.v2.data.domain;

import javax.persistence.*;

@Entity
@Table( name = "CLASS" )
public class Class {

    @Id
    @Column( name = "ID" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @OneToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "STUDENT_ID" )
    private Student student;

    @OneToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "INSTRUCTOR_ID" )
    private Instructor instructor;

    @OneToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "CAR_ID" )
    private Car car;

    public Long getId() {

        return id;
    }

    public Class id( Long id ) {

        this.id = id;
        return this;
    }

    public Student getStudent() {

        return student;
    }

    public Class student( Student student ) {

        this.student = student;
        return this;
    }

    public Instructor getInstructor() {

        return instructor;
    }

    public Class instructor( Instructor instructor ) {

        this.instructor = instructor;
        return this;
    }

    public Car getCar() {

        return car;
    }

    public Class car( Car car ) {

        this.car = car;
        return this;
    }
}
