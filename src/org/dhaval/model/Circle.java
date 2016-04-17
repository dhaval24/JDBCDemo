package org.dhaval.model;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@Component
@Entity(name = "mycircl")
public class Circle{
    @Id
    @Column(name = "circlr_Id")
    //@GenericGenerator(name="generator", strategy="increment")
    @GeneratedValue
    private int id = 0;
    @Column(name = "circle_name")
    private String name;

    public Circle(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Circle() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
