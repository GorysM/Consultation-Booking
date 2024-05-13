/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.skinconsultationcentre;

/**
 *
 * @author Greg
 */
public interface SkinConsultationManager {
    public int menu();
    public void addANewDoctor(int medicalLicenceNumber, String specilization, String name, String Surname, String dateOfBirth, String mobileNumber);
    public void deleteADoctor(int medicalLicenceNumber);
    public void printTheListOfTheDoctors(String typesorting);
    public void saveInAFile();
    public void loadFromFile();
}
