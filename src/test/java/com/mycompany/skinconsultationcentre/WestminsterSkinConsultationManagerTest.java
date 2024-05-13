/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.skinconsultationcentre;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Greg
 */
public class WestminsterSkinConsultationManagerTest {

    public static void main(String[] args) {

        testHandleChoiceOutBound();
        testHandleChoice4();
        testHandleChoice0();
    }

    public WestminsterSkinConsultationManagerTest() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testGetDoctors() {
    }


    @Test
    public void testSetDoctors() {
    }

    @Test
    public void testToString() {
    }


    @Test
    public void testMenu() {
    }

    @Test
    public static void testHandleChoice0() {
        PrintStream originalOut = System.out;
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);

 
        os.toString();
        String separator = System.getProperty("line.separator");

        WestminsterSkinConsultationManager manager = new WestminsterSkinConsultationManager();
        manager.handleChoice(0);
        assertEquals("Exiting..." + separator + "File has been saved." + separator, os.toString());
        System.setOut(originalOut);

    }

    @Test
    public static void testHandleChoiceOutBound() {
        PrintStream originalOut = System.out;
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
        os.toString();
        String separator = System.getProperty("line.separator");

        WestminsterSkinConsultationManager manager = new WestminsterSkinConsultationManager();
        manager.handleChoice(9);
        assertEquals("Wrong choice. Please pick a number from the options given :" + separator, os.toString());
        System.setOut(originalOut);

    }

    @Test
    public static void testHandleChoice4() {
        PrintStream originalOut = System.out;
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
        os.toString();
        String separator = System.getProperty("line.separator");

        WestminsterSkinConsultationManager manager = new WestminsterSkinConsultationManager();
        manager.handleChoice(4);
        assertEquals("File has been saved." + separator, os.toString());
        System.setOut(originalOut);
    }


    @Test
    public void testAddANewDoctor() {
    }

    @Test
    public void testDeleteADoctor() {
    }


    @Test
    public void testPrintTheListOfTheDoctors() {
    }

    @Test
    public void testSaveInAFile() {
    }


    @Test
    public void testLoadFromFile() {
    }

}
