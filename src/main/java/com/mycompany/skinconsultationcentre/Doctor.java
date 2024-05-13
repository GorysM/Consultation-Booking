/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.skinconsultationcentre;

import java.util.ArrayList;

/**
 *
 * @author Greg
 */
public class Doctor extends Person {

    private int medicalLicenceNumber;
    private String specilization;
    private ArrayList<Consultation> consultationList;

    public Doctor(int medicalLicenceNumber, String specilization, String name, String Surname, String dateOfBirth, String mobileNumber) {
        super(name, Surname, dateOfBirth, mobileNumber);
        consultationList = new ArrayList<Consultation>();
        this.medicalLicenceNumber = medicalLicenceNumber;
        this.specilization = specilization;
    }

    public boolean availabilityCheck(Consultation new_cons) {
        String time;
        String time_list[];
        double timeD;
        double timeD2;
        double timeCons;
        double timeCons2;
        String timeListCons[];
        boolean availability = true;
        timeListCons = new_cons.getTime().split(":");
        timeCons = Integer.parseInt(timeListCons[0]) + Integer.parseInt(timeListCons[1]) / 100.0;
        timeCons2 = timeCons + new_cons.getHours();
        for (int j = 0; j < consultationList.size(); j++) {
            if (new_cons.getDate().equals(consultationList.get(j).getDate())) {
                time = consultationList.get(j).getTime();
                time_list = time.split(":");
                timeD = Integer.parseInt(time_list[0]) + Integer.parseInt(time_list[1]) / 100.0;
                timeD2 = timeD + consultationList.get(j).getHours();
                System.out.println(timeD + " " + timeD2 + " " + timeCons + " " + timeCons2);
                if (timeCons >= timeD && timeCons <= timeD2) {
                    availability = false;
                    break;
                }
                if (timeCons2 >= timeD && timeCons2 <= timeD2) {
                    availability = false;
                    break;
                }
            }
        }
        return availability;
    }

    public int getMedicalLicenceNumber() {
        return medicalLicenceNumber;
    }

    public void setMedicalLicenceNumber(int medicalLicenceNumber) {
        this.medicalLicenceNumber = medicalLicenceNumber;
    }

    public String getSpecilization() {
        return specilization;
    }

    public void setSpecilization(String specilization) {
        this.specilization = specilization;
    }

    public ArrayList<Consultation> getConsultationList() {
        return consultationList;
    }

    public void setConsultationList(ArrayList<Consultation> consultationList) {
        this.consultationList = consultationList;
    }

    @Override
    public String toString() {
        String consult_str = "";
        for (int i = 0; i < consultationList.size(); i++) {
            consult_str = consult_str + "\t" + consultationList.get(i).toString() + "\n";
        }
        return super.toString() + ", medicalLicenceNumber=" + medicalLicenceNumber + ", specilization=" + specilization + "\nconsultations: \n" + consult_str;
    }

    public void addConstultation(Consultation consultation) {
        consultationList.add(consultation);
    }

}
