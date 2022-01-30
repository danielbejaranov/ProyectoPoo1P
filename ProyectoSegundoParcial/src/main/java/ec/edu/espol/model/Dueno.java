/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.util.Util;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Dueno extends Persona{
    private String direccion;

    public Dueno(int id, String nombres, String apellidos,String direccion, String telefono, String email) {
        super(id, nombres, apellidos, telefono, email);
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public void saveFile(String nomfile){
        StringBuilder sb = new StringBuilder();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomfile, true))) {

            sb.append(this.id).append("|");
            sb.append(this.nombres).append("|");
            sb.append(this.apellidos).append("|");
            sb.append(this.direccion).append("|");
            sb.append(this.telefono).append("|");
            sb.append(this.email);

            bw.write(sb.toString());
        } catch (IOException e) {
            System.out.println(e);
        }        
    }
    
    public static void saveFile(ArrayList<Dueno> dueños, String nomfile){
        StringBuilder sb = new StringBuilder();        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomfile))) {            
            for (Dueno d : dueños) {
                sb.append(d.id).append("|");
                sb.append(d.nombres).append("|");
                sb.append(d.apellidos).append("|");
                sb.append(d.direccion).append("|");
                sb.append(d.telefono).append("|");
                sb.append(d.email);            
            }
            bw.write(sb.toString());
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    public static ArrayList<Dueno> readFileDueño(String nomfile){
        ArrayList<Dueno> dueños = new ArrayList<>();
        try (BufferedReader bw = new BufferedReader(new FileReader(nomfile))) {
            String linea;
            while ((linea = bw.readLine()) != null) {
                String[] tokens = linea.split("\\|");
                Dueno dueño = new Dueno(
                                Integer.parseInt(tokens[0]), 
                                tokens[1], 
                                tokens[2], 
                                tokens[3], 
                                tokens[4], 
                                tokens[5]);
                dueños.add(dueño);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return dueños;        
    }
    
    public static Dueno searchByCorreo(ArrayList<Dueno> dueños, String correo){
        for(Dueno d: dueños)
        {
            if(d.email.equals(correo))
                return d;
        }
        return null;
    }
        
    public static Dueno getDueñoSearchedByMail(String correo){
        ArrayList<Dueno> dueños = readFileDueño("duenos.txt");
        Dueno dueño = searchByCorreo(dueños, correo);
        return dueño;
    }
    
    public static Boolean correoInFile(String correo){
        try (BufferedReader bw = new BufferedReader(new FileReader("duenos.txt"))) {
            String linea;
            while ((linea = bw.readLine()) != null) {
                String [] tokens = linea.split("|");
                if(tokens[5].equals(correo))
                    return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }    
}
