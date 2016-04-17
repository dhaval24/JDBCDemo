package org.dhaval.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.Parameter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by Dhaval on 4/15/2016.
 */

@Component
@Entity
@Scope("prototype")
public class Vehicle {

    @Id
    @GenericGenerator(name = "opt-seq", strategy = "sequence", parameters = @Parameter(name = "prefer_sequence_per_entity", value = "true"))
    @GeneratedValue(generator = "opt-seq")
    private int vehicle_id;
    private String vehicle_Name;

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getVehicle_Name() {
        return vehicle_Name;
    }

    public void setVehicle_Name(String vehicle_Name) {
        this.vehicle_Name = vehicle_Name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    private User user;
}
