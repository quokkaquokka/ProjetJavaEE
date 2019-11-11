/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efrei.se.abdmeziem.moutte.part3.model;

import com.efrei.se.abdmeziem.moutte.part3.model.Employees;
/**
 *
 * @author QuokkaKoala
 */
public class Employees extends EmployeesWithoutID {
    
    
    private String objectID;
    private String name;
    private String firstname;
    private String telhome;
    private String telmob;
    private String telpro;
    private String adress;
    private String postalcode;
    private String city;
    private String email;

    public Employees() {}

    public String getName() {
        return name;
    }

    public EmployeesWithoutID setName(String name) {
        this.name = name;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public EmployeesWithoutID setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getTelhome() {
        return telhome;
    }

    public EmployeesWithoutID setTelhome(String telhome) {
        this.telhome = telhome;
        return this;
    }

    public String getTelmob() {
        return telmob;
    }

    public EmployeesWithoutID setTelmob(String telmob) {
        this.telmob = telmob;
        return this;
    }

    public String getTelpro() {
        return telpro;
    }

    public EmployeesWithoutID setTelpro(String telpro) {
        this.telpro = telpro;
        return this;
    }

    public String getAdress() {
        return adress;
    }

    public EmployeesWithoutID setAdress(String adress) {
        this.adress = adress;
        return this;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public EmployeesWithoutID setPostalcode(String postalcode) {
        this.postalcode = postalcode;
        return this;
    }

    public String getCity() {
        return city;
    }

    public EmployeesWithoutID setCity(String city) {
        this.city = city;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public EmployeesWithoutID setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getObjectID() {
        return objectID;
    }

    public Employees setObjectID(String objectID) {
        this.objectID = objectID;
        return this;
    }
}
