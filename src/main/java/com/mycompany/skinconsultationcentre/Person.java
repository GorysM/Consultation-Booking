/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.skinconsultationcentre;

import java.io.Serializable;

/**
 *
 * @author Greg
 */
public abstract class Person implements Serializable{
    private String name;
    private String Surname;
    private String dateOfBirth;
    private String mobileNumber;

    public Person(String name, String Surname, String dateOfBirth, String mobileNumber) {
        this.name = name;
        this.Surname = Surname;
        this.dateOfBirth = dateOfBirth;
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }


    @Override
    public String toString() {
        return  "name=" + name + ", Surname=" + Surname + ", dateOfBirth=" + dateOfBirth + ", mobileNumber=" + mobileNumber;
    }

  
    
   
    
}
