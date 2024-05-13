/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.skinconsultationcentre;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import java.util.Scanner;

/**
 *
 * @author Greg
 */
public class WestminsterSkinConsultationManager implements SkinConsultationManager {

    private ArrayList<Doctor> doctors;
    private Scanner sc = new Scanner(System.in);
    private String fileName = "doctors.ser";
    private GUI gui;

    public WestminsterSkinConsultationManager() {
        File save_file =new File(fileName);
        if(save_file.exists()){
            loadFromFile();
            
        }
        else{
           this.doctors = new ArrayList<Doctor>(); 
        }   
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    @Override
    public String toString() {
        return "WestminsterSkinConsultationManager{" + "doctors=" + doctors + '}';
    }

    @Override
    public int menu() {
        int choice;
       
        System.out.println("");
        System.out.println("0. Exit and save ");
        System.out.println("1. Add a new Doctor");
        System.out.println("2. Delete a Doctor");
        System.out.println("3. Display all Doctors");
        System.out.println("4. Save in file");
        System.out.println("5. Add a consultation ");
        System.out.println("Please choose an option :");
        choice = sc.nextInt();
        sc.nextLine();
        handleChoice(choice);   
        return choice;
    }
    public void handleChoice(int choice){
         int medicalLicenceNumber;
        String name;
        String specilization;
        String surname;
        String dateOfBirth;
        String mobileNumber;
        if (choice == 0) {
            System.out.println("Exiting...");
            saveInAFile();
            
        } else if (choice == 1) {
            System.out.println("Please enter the following details for a new Doctor : ");
            System.out.println("Name: ");
            name = sc.nextLine();
            System.out.println("Surname :");
            surname = sc.nextLine();
            System.out.println("Specilization: ");
            specilization = sc.nextLine();
            System.out.println("Medical licence number: ");
            medicalLicenceNumber = sc.nextInt();
            sc.nextLine();
            System.out.println("Date of birth: ");
            dateOfBirth = sc.nextLine();
            System.out.println("Mobile number: ");
            mobileNumber = sc.nextLine();
            addANewDoctor(medicalLicenceNumber, specilization, name, surname, dateOfBirth, mobileNumber);
        } else if (choice == 2) {
            printTheListOfTheDoctors("ascending");
            System.out.println("Please choose from the numeriacal above to delete a Doctor");
            int deleteChoice;
            deleteChoice = sc.nextInt();
            sc.nextLine();
            deleteADoctor(doctors.get(deleteChoice - 1).getMedicalLicenceNumber());

        } else if (choice == 3) {
            printTheListOfTheDoctors("ascending");
        } else if (choice == 4) {
            saveInAFile();
        } 
        else if (choice == 5){
            gui = new GUI(this);
            
        }
        else {
            System.out.println("Wrong choice. Please pick a number from the options given :");

        }
        
    }

    @Override
    public void addANewDoctor(int medicalLicenceNumber, String specilization, String name, String surname, String dateOfBirth, String mobileNumber) {
        doctors.add(new Doctor(medicalLicenceNumber, specilization, name, surname, dateOfBirth, mobileNumber));
        System.out.println("Doctor details has been added.");
    }

    @Override
    public void deleteADoctor(int medicalLicenceNumber) {
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getMedicalLicenceNumber() == medicalLicenceNumber) {
                System.out.println("The doctor  " + doctors.get(i) + " removed");
                doctors.remove(i);
            }
        }
    }

    @Override
    public void printTheListOfTheDoctors(String typesorting) {
        int counter = 0;
        Doctor temp;
        if (doctors.size() == 0) {
            System.out.println("Doctor list is empty ");
        } 
        else {
            if (typesorting.equals("ascending")) {
                for (int i = 0; i < doctors.size() - 1; i++) {
                    for (int j = 0; j < doctors.size() - 1 - i; j++) {
                        if (doctors.get(j).getSurname().compareTo(doctors.get(j + 1).getSurname()) > 0) {
                            temp = doctors.get(j + 1);
                            doctors.set(j + 1, doctors.get(j));
                            doctors.set(j, temp);

                        }
                    }
                }

            } 
            else if (typesorting.equals("descending")) {
                for (int i = 0; i < doctors.size() - 1; i++) {
                    for (int j = 0; j < doctors.size() - 1 - i; j++) {
                        if (doctors.get(j).getSurname().compareTo(doctors.get(j + 1).getSurname()) < 0) {
                            temp = doctors.get(j + 1);
                            doctors.set(j + 1, doctors.get(j));
                            doctors.set(j, temp);

                        }
                    }
                }
            }

            for (int i = 0; i < doctors.size(); i++) {
                counter++;
                System.out.println(counter + ". " + doctors.get(i));
            }
        }
    }

    @Override
    public void saveInAFile() {

        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            try {
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(doctors);
                out.close();
                fileOut.close();
                System.out.println("File has been saved.");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void loadFromFile(){
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            try {
                ObjectInputStream in = new ObjectInputStream (fileIn);
                try {
                    doctors =(ArrayList<Doctor>) in.readObject();
                    fileIn.close();
                    in.close();
                    
                } catch (ClassNotFoundException ex) {  
                   ex.printStackTrace();
                }
                
            } catch (IOException ex) {
               ex.printStackTrace();
            }
            
            
        } catch (FileNotFoundException ex) {
           ex.printStackTrace();
        }
        
    }




}
