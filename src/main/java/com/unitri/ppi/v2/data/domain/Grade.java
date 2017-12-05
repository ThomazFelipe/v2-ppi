package com.unitri.ppi.v2.data.domain;

import javax.persistence.*;

@Entity
@Table( name = "GRADE" )
public class Grade {

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

    public void setId( Long id ) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent( Student student ) {
        this.student = student;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor( Instructor instructor ) {
        this.instructor = instructor;
    }

    public Car getCar() {
        return car;
    }

    public void setCar( Car car ) {
        this.car = car;
    }
}
