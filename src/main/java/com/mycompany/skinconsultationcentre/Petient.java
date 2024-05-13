/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.skinconsultationcentre;

/**
 *
 * @author Greg
 */
public class Petient extends Person {
    private int uniqueID;

    public Petient(int uniqueID, String name, String Surname, String dateOfBirth, String mobileNumber) {
        super(name, Surname, dateOfBirth, mobileNumber);
        this.uniqueID = uniqueID;
    }

    public int getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(int uniqueID) {
        this.uniqueID = uniqueID;
    }

    @Override
    public String toString() {
        return "Petient{" + "uniqueID=" + uniqueID + '}';
    }

    





}