/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.skinconsultationcentre;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import com.github.lgooddatepicker.components.DateTimePicker;   //The following implemetation has been referenced to the person who created the datetimepicker and i imported through JavaMaven.
import javax.swing.JOptionPane;

/**
 *
 * @author Greg
 */
public class GUI extends JFrame {

    private JPanel doctorPanel;
    private JPanel consultationPanel;
    private JTable doctorTable;
    private JPanel selectedDoctorPanel;
    private JPanel patientPanel;
    private JLabel nameLab;
    private JLabel selNameLab;
    private JLabel surnameLab;
    private JLabel selSurnameLab;
    private JLabel numberLab;
    private JLabel selNumberLab;
    private JLabel specLab;
    private JLabel selSpecLab;
    private JLabel pHoursLab;
    private JLabel pUniqueIDLab;
    private JLabel pNameLab;
    private JLabel pSurnameLab;
    private JLabel pDobLab;
    private JLabel pMobileNLab;
    private JLabel pNotesLab;
    private JTextField pNameField;
    private JTextField pSurnameField;
    private JTextField pUniqueIDField;
    private JTextField pDobField;
    private JTextField pMobileNField;
    private JTextField pNotesField;
    private JTextField pHoursField;
    private JButton submitBut;
    private JPanel dayTimePanel;
    private JLabel dateTimeLab;
    private JLabel docIDLab;
    private JLabel selDocIDLab;
    private JPanel pDisplayPanel;
    private JTable pConsultationTable;
    private JLabel cPatientNameSurname;
    private JLabel cNotes;
    private JLabel cDateTime;
    private JLabel cDoctorNameSurname;
    private JLabel cCost;
    private JLabel cHours;
    private WestminsterSkinConsultationManager manager;

    public GUI(WestminsterSkinConsultationManager manager_passed) {
        super("Add a consultation "); //titlos jframe
        super.setSize(2500, 1000); // 500H, 200V
        super.setResizable(false); // Kleidoma sto resizing apo user


        //create panels
        manager = manager_passed;
        dayTimePanel = new JPanel();
        doctorPanel = new JPanel();
        consultationPanel = new JPanel();
        selectedDoctorPanel = new JPanel();
        patientPanel = new JPanel();
        pDisplayPanel = new JPanel();
        pDisplayPanel.setLayout(new GridLayout(7, 1));

        super.setLayout(new GridLayout(1, 3));// 1 = row 2= columns
        super.add(doctorPanel);
        super.add(consultationPanel);
        super.add(pDisplayPanel);
        DateTimePicker callendar = new DateTimePicker();
        dateTimeLab = new JLabel();
        dateTimeLab.setText("Date time picker: ");
        patientPanel.setLayout(new GridLayout(7, 2));
        submitBut = new JButton("Submit Booking");
//        submitBut.setSize(15, 5); 
        submitBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double timeCons;
                double timeCons2;
                String timeListCons[];
                int uniqueID;
                uniqueID = Integer.parseInt(selDocIDLab.getText());
                Consultation new_cons = new Consultation(callendar.getDatePicker().toString(), callendar.getTimePicker().toString(), Double.parseDouble(pHoursField.getText()), pNotesField.getText(), new Petient(Integer.parseInt(pUniqueIDField.getText()), pNameField.getText(), pSurnameField.getText(), pDobField.getText(), pMobileNField.getText()));
                timeListCons = new_cons.getTime().split(":");
                timeCons = Integer.parseInt(timeListCons[0]) + Integer.parseInt(timeListCons[1]) / 100.0;
                timeCons2 = timeCons + new_cons.getHours();
                System.out.println(new_cons);
                System.out.println(uniqueID);

                String time;
                String time_list[];
                double timeD;
                double timeD2;
                boolean availability = true;
                for (int i = 0; i < manager.getDoctors().size(); i++) {
                    if (manager.getDoctors().get(i).getMedicalLicenceNumber() == uniqueID) {
                        availability = manager.getDoctors().get(i).availabilityCheck(new_cons);
                        if (availability == true) {
                            manager.getDoctors().get(i).addConstultation(new_cons);
                            manager.saveInAFile();
                            pNameField.setText("");
                            pSurnameField.setText("");
                            pUniqueIDField.setText("");
                            pDobField.setText("");
                            pMobileNField.setText("");
                            pNotesField.setText("");
                            pHoursField.setText("");
                            callendar.clear();
                            JOptionPane.showConfirmDialog(null, "Your consultation now has been booked press ok to continue ", "Consultation confirmation", JOptionPane.DEFAULT_OPTION);
                            fillConsultationTable();
                            break;
                        } else {
                            boolean availability2 = false;
                            for (int k = 0; k < manager.getDoctors().size(); k++) {
                                if (manager.getDoctors().get(k).getMedicalLicenceNumber() != uniqueID && manager.getDoctors().get(i).getSpecilization().equals(manager.getDoctors().get(k).getSpecilization())) {
                                    availability2 = manager.getDoctors().get(k).availabilityCheck(new_cons);
                                    if (availability2 == true) {
                                        manager.getDoctors().get(k).addConstultation(new_cons);
                                        manager.saveInAFile();
                                        pNameField.setText("");
                                        pSurnameField.setText("");
                                        pUniqueIDField.setText("");
                                        pDobField.setText("");
                                        pMobileNField.setText("");
                                        pNotesField.setText("");
                                        pHoursField.setText("");
                                        callendar.clear();
                                        JOptionPane.showConfirmDialog(null, "Your consultation has been booked to a different doctor (MedicalLicenceNumber: " + manager.getDoctors().get(k).getMedicalLicenceNumber() + ",Surname: " + manager.getDoctors().get(k).getSurname() + ") " + "as the slot you choose is not available. ", "Consultation confirmation", JOptionPane.DEFAULT_OPTION);
                                        fillConsultationTable();
                                        break;
                                    }
                                }

                            }
                            if (availability2 == false) {
                                JOptionPane.showConfirmDialog(null, "No doctor with the specilasation, date and time is available. Please choose another date and time ", "Consultation confirmation", JOptionPane.DEFAULT_OPTION);
                            }
                        }

                    }

                }
                manager.saveInAFile();
            }
        });

        dayTimePanel.setLayout(new GridLayout(2, 1));
        dayTimePanel.add(dateTimeLab);
        dayTimePanel.add(callendar);
        consultationPanel.setLayout(new GridLayout(4, 1));
        consultationPanel.add(selectedDoctorPanel);
        consultationPanel.add(patientPanel);
        consultationPanel.add(dayTimePanel);
        consultationPanel.add(submitBut);
        String columns[] = {"surname", "name", "specilization", "mobileNumber"};
        doctorTable = new JTable();
        TableModel model;

        //fill the table
        Object[][] allData = new Object[manager.getDoctors().size()][columns.length];
        for (int i = 0; i < manager.getDoctors().size(); i++) {
            Object[] data = {manager.getDoctors().get(i).getSurname(), manager.getDoctors().get(i).getName(), manager.getDoctors().get(i).getSpecilization(), manager.getDoctors().get(i).getMobileNumber()};
            allData[i] = data;
        }
        model = new DefaultTableModel(allData, columns);
        doctorTable.setModel(model);
        doctorTable.getSelectionModel().addListSelectionListener(new RowSelectionListener());
        JScrollPane scrollPanel = new JScrollPane(doctorTable);
        doctorTable.setGridColor(Color.black);
        doctorPanel.add(scrollPanel);

        //fill selectedDoctorPanel
        nameLab = new JLabel();
        nameLab.setHorizontalAlignment(SwingConstants.RIGHT);
        surnameLab = new JLabel();
        surnameLab.setHorizontalAlignment(SwingConstants.RIGHT);
        numberLab = new JLabel();
        numberLab.setHorizontalAlignment(SwingConstants.RIGHT);
        specLab = new JLabel();
        specLab.setHorizontalAlignment(SwingConstants.RIGHT);
        selNameLab = new JLabel();
        selSurnameLab = new JLabel();
        selSpecLab = new JLabel();
        selNumberLab = new JLabel();
        docIDLab = new JLabel();
        docIDLab.setHorizontalAlignment(SwingConstants.RIGHT);
        selDocIDLab = new JLabel();
        nameLab.setText("Name: ");
        surnameLab.setText("Surname: ");
        numberLab.setText("Mobile Num: ");
        specLab.setText("Specilization: ");
        docIDLab.setText("Unique ID: ");
        selectedDoctorPanel.setLayout(new GridLayout(5, 2));
        selectedDoctorPanel.add(surnameLab);
        selectedDoctorPanel.add(selSurnameLab);
        selectedDoctorPanel.add(nameLab);
        selectedDoctorPanel.add(selNameLab);
        selectedDoctorPanel.add(specLab);
        selectedDoctorPanel.add(selSpecLab);
        selectedDoctorPanel.add(numberLab);
        selectedDoctorPanel.add(selNumberLab);
        selectedDoctorPanel.add(docIDLab);
        selectedDoctorPanel.add(selDocIDLab);

        //Fill patient panel
        pNameLab = new JLabel();
        pNameLab.setHorizontalAlignment(SwingConstants.RIGHT);
        pUniqueIDLab = new JLabel();
        pUniqueIDLab.setHorizontalAlignment(SwingConstants.RIGHT);
        pSurnameLab = new JLabel();
        pSurnameLab.setHorizontalAlignment(SwingConstants.RIGHT);
        pDobLab = new JLabel();
        pDobLab.setHorizontalAlignment(SwingConstants.RIGHT);
        pMobileNLab = new JLabel();
        pMobileNLab.setHorizontalAlignment(SwingConstants.RIGHT);
        pNotesLab = new JLabel();
        pNotesLab.setHorizontalAlignment(SwingConstants.RIGHT);
        pHoursLab = new JLabel();
        pHoursLab.setHorizontalAlignment(SwingConstants.RIGHT);
        pNameLab.setText("Name: ");
        pUniqueIDLab.setText("Unique ID: ");
        pSurnameLab.setText("Surname: ");
        pDobLab.setText("Date Of Birth: ");
        pMobileNLab.setText("Mobile Number: ");
        pNotesLab.setText("Notes: ");
        pHoursLab.setText("Hours: ");
        pNameField = new JTextField();
        pSurnameField = new JTextField();
        pUniqueIDField = new JTextField();
        pDobField = new JTextField();
        pMobileNField = new JTextField();
        pNotesField = new JTextField();
        pHoursField = new JTextField();
        patientPanel.add(pSurnameLab);
        patientPanel.add(pSurnameField);
        patientPanel.add(pNameLab);
        patientPanel.add(pNameField);
        patientPanel.add(pUniqueIDLab);
        patientPanel.add(pUniqueIDField);
        patientPanel.add(pMobileNLab);
        patientPanel.add(pMobileNField);
        patientPanel.add(pDobLab);
        patientPanel.add(pDobField);
        patientPanel.add(pNotesLab);
        patientPanel.add(pNotesField);
        patientPanel.add(pHoursLab);
        patientPanel.add(pHoursField);

        fieldDisplay();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //otan patithei to koumpi x na kleisei to programma Kai termatizei to programma
        setVisible(true);//emfanise to main frame

    }

    public void fillConsultationTable() {
        String columns[] = {"Doctor ID", "Patient ID", "Patient surname", "Patient name", "Doctor surname", "Doctor name", "Date and time"};

        TableModel model;
        ArrayList<Consultation> conList = new ArrayList<Consultation>();
        for (int i = 0; i < manager.getDoctors().size(); i++) {
            for (int j = 0; j < manager.getDoctors().get(i).getConsultationList().size(); j++) {
                conList.add(manager.getDoctors().get(i).getConsultationList().get(j));
            }
        }       
        //fill the table
        Object[][] allData = new Object[conList.size()][columns.length];
        int c = 0;
        for (int i = 0; i < manager.getDoctors().size(); i++) {

            for (int j = 0; j < manager.getDoctors().get(i).getConsultationList().size(); j++) {
                System.out.println(i + "," + j);
                Object[] data = {manager.getDoctors().get(i).getMedicalLicenceNumber(), manager.getDoctors().get(i).getConsultationList().get(j).getPetient().getUniqueID(), manager.getDoctors().get(i).getConsultationList().get(j).getPetient().getSurname(), manager.getDoctors().get(i).getConsultationList().get(j).getPetient().getName(), manager.getDoctors().get(i).getSurname(), manager.getDoctors().get(i).getName(), manager.getDoctors().get(i).getConsultationList().get(j).getDate() + " " + manager.getDoctors().get(i).getConsultationList().get(j).getTime()};
                allData[c] = data;
                c = c + 1;
            }
        }
        model = new DefaultTableModel(allData, columns);
        pConsultationTable.getSelectionModel().addListSelectionListener(new RowSelectionListenerCon());
        pConsultationTable.setModel(model);

    }

    public void fieldDisplay() {
        pConsultationTable = new JTable();
        JScrollPane scrollPanel = new JScrollPane(pConsultationTable);
        pConsultationTable.setGridColor(Color.black);
        pDisplayPanel.add(scrollPanel);
        fillConsultationTable();
        cPatientNameSurname = new JLabel();
        cNotes = new JLabel();
        cDateTime = new JLabel();
        cDoctorNameSurname = new JLabel();
        cCost = new JLabel();
        cHours = new JLabel();
        pDisplayPanel.add(cPatientNameSurname);
        pDisplayPanel.add(cDoctorNameSurname);
        pDisplayPanel.add(cNotes);
        pDisplayPanel.add(cDateTime);
        pDisplayPanel.add(cCost);
        pDisplayPanel.add(cHours);
    }

    private class RowSelectionListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            int selectRow = doctorTable.getSelectedRow();
            System.out.println(selectRow);
            System.out.println(manager.getDoctors().get(selectRow));
            selSurnameLab.setText(manager.getDoctors().get(selectRow).getSurname());
            selNameLab.setText(manager.getDoctors().get(selectRow).getName());
            selSpecLab.setText(manager.getDoctors().get(selectRow).getSpecilization());
            selNumberLab.setText(manager.getDoctors().get(selectRow).getMobileNumber());
            selDocIDLab.setText(Integer.toString(manager.getDoctors().get(selectRow).getMedicalLicenceNumber()));

        }

    }

    private class RowSelectionListenerCon implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            int selectRow = pConsultationTable.getSelectedRow();
            for (int i = 0; i < manager.getDoctors().size(); i++) {
                if (manager.getDoctors().get(i).getMedicalLicenceNumber() == (Integer) pConsultationTable.getModel().getValueAt(selectRow, 0)) {
                    for (int j = 0; j < manager.getDoctors().get(i).getConsultationList().size(); j++) {
                        if (manager.getDoctors().get(i).getConsultationList().get(j).getPetient().getUniqueID() == (Integer) pConsultationTable.getModel().getValueAt(selectRow, 1)) {
                            cPatientNameSurname.setText("Patient : " + manager.getDoctors().get(i).getConsultationList().get(j).getPetient().getSurname() + " " + manager.getDoctors().get(i).getConsultationList().get(j).getPetient().getName());
                            cDoctorNameSurname.setText("Doctor : " + manager.getDoctors().get(i).getSurname() + " " + manager.getDoctors().get(i).getName());
                            if (manager.getDoctors().get(i).getConsultationList().get(j).getNotes() == null) {
                                cNotes.setText("Notes : ");
                            } else {
                                cNotes.setText("Notes : " + manager.getDoctors().get(i).getConsultationList().get(j).getNotes());
                            }
                            cDateTime.setText("Date and time : " + manager.getDoctors().get(i).getConsultationList().get(j).getDate() + " " + manager.getDoctors().get(i).getConsultationList().get(j).getTime());
                            cCost.setText(String.valueOf("Cost : " + manager.getDoctors().get(i).getConsultationList().get(j).getCost()));
                            cHours.setText(String.valueOf("Booked hours : " + manager.getDoctors().get(i).getConsultationList().get(j).getHours()));

                        }
                    }
                }

            }
        }

    }
}
