package org.dhaval.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Dhaval on 4/15/2016.
 */
@Component
@Scope("prototype")
@Entity
public class RentedVehicle {

    @Id
    @GenericGenerator(name = "opt-seq", strategy = "sequence", parameters = @Parameter(name = "prefer_sequence_per_entity", value = "true"))
    @GeneratedValue(generator = "opt-seq")
    private int rentedVehicleID;
    private String name;

    public Collection<User> getUserList() {
        return userList;
    }

    public void setUserList(Collection<User> userList) {
        this.userList = userList;
    }

    @ManyToMany
    private Collection<User> userList = new ArrayList<>();
    public int getRentedVehicleID() {
        return rentedVehicleID;
    }

    public void setRentedVehicleID(int rentedVehicleID) {
        this.rentedVehicleID = rentedVehicleID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
