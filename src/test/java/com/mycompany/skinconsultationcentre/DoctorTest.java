/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.skinconsultationcentre;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Greg
 */
public class DoctorTest {
    public static void main(String[] args) {
    testGetMedicalLicenceNumber();
    testGetSpecilization();
}
    
    public DoctorTest() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getMedicalLicenceNumber method, of class Doctor.
     */
    @Test
    static public void testGetMedicalLicenceNumber() {
            Doctor d = new Doctor(23, "skin", "john", "smith", "15.01.01", "0777777777");
            assertEquals(d.getMedicalLicenceNumber(), 23);
    }

    /**
     * Test of setMedicalLicenceNumber method, of class Doctor.
     */
    @Test
    public void testSetMedicalLicenceNumber() {
    }

    /**
     * Test of getSpecilization method, of class Doctor.
     */
    @Test
    public static void testGetSpecilization() {
         Doctor d = new Doctor(23, "skin", "john", "smith", "15.01.01", "0777777777");
            assertEquals(d.getSpecilization(), "skin");
    }

    /**
     * Test of setSpecilization method, of class Doctor.
     */
    @Test
    public void testSetSpecilization() {
    }

    /**
     * Test of getConsultationList method, of class Doctor.
     */
    @Test
    public void testGetConsultationList() {
    }

    /**
     * Test of setConsultationList method, of class Doctor.
     */
    @Test
    public void testSetConsultationList() {
        
    }

    /**
     * Test of toString method, of class Doctor.
     */
    @Test
    public void testToString() {
    }

    /**
     * Test of addConstultation method, of class Doctor.
     */
    @Test
    public void testAddConstultation() {
    }
    
}
