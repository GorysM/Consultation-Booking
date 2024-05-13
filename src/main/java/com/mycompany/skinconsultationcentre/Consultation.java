/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.skinconsultationcentre;
import java.io.Serializable;
import java.time.LocalTime;
/**
 *
 * @author Greg
 */
public class Consultation implements Serializable {
    private String date;
    private String time;
    private double cost;
    private String notes;
    private Petient petient;
    private double hours;

    public Consultation(String date, String time, double hours, String notes, Petient petient) {
        this.date = date;
        this.time = time;
        this.hours = hours;
        this.petient = petient;
        this.notes = notes;
        calculateCost();
    }

    public void calculateCost (){
        if ( hours <= 1){
            cost = hours *15;
        }
        else{
            cost = 15 + (hours - 1 )*25 ; 
        }
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Petient getPetient() {
        return petient;
    }

    public void setPetient(Petient petient) {
        this.petient = petient;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }
    
    

    @Override
    public String toString() {
        return  "date=" + date + ", time=" + time + ", cost=" + cost + ", notes=" + notes + ", petient=" + petient + ", hours=" + hours ;
    }

    
    


 

  

 



 

   
    
          
    
    
    
}
