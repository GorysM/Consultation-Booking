/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.skinconsultationcentre;


/**
 *
 * @author Greg
 */
public class SkinConsultationCentre {
    public static void main(String[] args) {
        WestminsterSkinConsultationManager manager = new WestminsterSkinConsultationManager();
       int choice;
        
        do{
          choice = manager.menu();
        }while(choice!=0);
        
               
        
    }
}
