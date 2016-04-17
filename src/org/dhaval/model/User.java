package org.dhaval.model;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Dhaval on 4/14/2016.
 */
@Component
@Entity
@Table(name = "user_details")
public class User{

    @ElementCollection
    @JoinTable(name = "user_address",
                joinColumns=@JoinColumn(name = "User_ID"))
    @GenericGenerator(name = "sequence-gen", strategy = "sequence", parameters = {@Parameter(name = "prefer_sequence_per_entity", value = "true")}) //hilo is common generator that hibernate provides
    @CollectionId(columns = {@Column(name = "Address_ID")}, type = @Type(type = "long"), generator = "sequence-gen" )
    private Collection<Address> listOfAddress = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

//    @OneToOne(cascade = {CascadeType.ALL})
//    private Vehicle vehicle;

//    public Vehicle getVehicle() {
//        return vehicle;
//    }
//
//    public void setVehicle(Vehicle vehicle) {
//        this.vehicle = vehicle;
//    }

    public Collection<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(Collection<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    @OneToMany
    private Collection<Vehicle> vehicleList = new ArrayList<>();

    @ManyToMany
    private Collection<RentedVehicle> rentedVehicleList = new ArrayList<>();

    public Collection<RentedVehicle> getRentedVehicleList() {
        return rentedVehicleList;
    }

    public void setRentedVehicleList(Collection<RentedVehicle> rentedVehicleList) {
        this.rentedVehicleList = rentedVehicleList;
    }

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Last_Name")
    private String lastName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    @Column(name = "User_Name")
    private String user_name;

    @Column(name = "Password",length = 20)
    private String pasword;

    public Collection<Address> getListOfAddress() {
        return listOfAddress;
    }

    public void setListOfAddress(Collection<Address> listOfAddress) {
        this.listOfAddress = listOfAddress;
    }

    public void assignUser(User user, Collection<Vehicle> vehicles){

        for(Vehicle vehicle : vehicles){
            user.getVehicleList().add(vehicle);
            vehicle.setUser(user);
        }

    }
}
