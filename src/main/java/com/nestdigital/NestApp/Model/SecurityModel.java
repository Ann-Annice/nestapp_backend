package com.nestdigital.NestApp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "security")
public class SecurityModel {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String place;
    private String dob;
    private String email;
    private String password;

    public SecurityModel(int id, String name, String place, String dob, String email, String password) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.dob = dob;
        this.email = email;
        this.password = password;
    }

    public SecurityModel() {
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
