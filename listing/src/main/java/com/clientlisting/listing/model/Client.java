package com.clientlisting.listing.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String firstName;

    private Date dateOfBirth;

    private String permissionNb;

    public Client(){

    }

    public Client(int id, String name, String firstName, Date dateOfBirth, String permissionNb){

        this.id = id;

        this.name = name;

        this.firstName = firstName;

        this.dateOfBirth = dateOfBirth;

        this.permissionNb = permissionNb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setPermissionNb(String permissionNb) {
        this.permissionNb = permissionNb;
    }

    public String getPermissionNb() {
        return permissionNb;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", permissionNb=" + permissionNb +
                '}';
    }
}


