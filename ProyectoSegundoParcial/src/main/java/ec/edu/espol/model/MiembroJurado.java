/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.util.Util;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class MiembroJurado extends Persona{
    private String perfil;   
     
    public MiembroJurado(int id, String nombres, String apellidos, String telefono, String email, String perfil) {
        super(id, nombres, apellidos, telefono, email);
        this.perfil = perfil;       
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public static MiembroJurado nextMiembroJurado (Scanner sc, String nomfile){

        int id = Util.nextID(nomfile);
        System.out.println("Ingrese sus nombres: ");
        String nombres = sc.next();
        System.out.println("Ingrese sus apellidos: ");
        String apellidos = sc.next();
        System.out.println("Ingrese su telefono: ");
        String telefono = sc.next();
        String email;
        do{
            System.out.println("Ingrese su correo: ");
            email = sc.next();
        }while(!(Dueno.correoInFile(email)));
        System.out.println("Ingrese su perfil: ");
        String perfil = sc.next();
        
        MiembroJurado personaJurado = new MiembroJurado(id,nombres,apellidos,telefono,email,perfil);
        personaJurado.saveFile(nomfile);
        return personaJurado;
    }
    
    public void saveFile(String nomfile){
        StringBuilder sb = new StringBuilder();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomfile, true))) {
            
            sb.append(this.id).append("|");
            sb.append(this.nombres).append("|");
            sb.append(this.apellidos).append("|");
            sb.append(this.telefono).append("|");
            sb.append(this.email).append("|");
            sb.append(this.perfil);
            
            bw.write(sb.toString());
        } catch (IOException e) {
            System.out.println(e);
        }    
    }
    public static void saveFile(ArrayList<MiembroJurado> miembroJurados, String nomfile){
        StringBuilder sb = new StringBuilder();        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomfile))) {            
            for (MiembroJurado j : miembroJurados) {
            sb.append(j.id).append("|");
            sb.append(j.nombres).append("|");
            sb.append(j.apellidos).append("|");
            sb.append(j.telefono).append("|");
            sb.append(j.email).append("|");
            sb.append(j.perfil);             
            }
            bw.write(sb.toString());
        } catch (IOException e) {
            System.out.println(e);
        }  
    }
    
    public static ArrayList<MiembroJurado> readFileMiembroJurado(String nomfile){
        ArrayList<MiembroJurado> jurados = new ArrayList<>();
        try (BufferedReader bw = new BufferedReader(new FileReader(nomfile))) {
            String linea;
            while ((linea = bw.readLine()) != null) {
                String [] tokens = linea.split("|");
                MiembroJurado j = new MiembroJurado(
                                Integer.parseInt(tokens[0]), 
                                tokens[1],
                                tokens[2],
                                tokens[3],
                                tokens[4],
                                tokens[5]);                        
                jurados.add(j);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return jurados;                
    }    
    public static MiembroJurado searchByCorreo(ArrayList<MiembroJurado> jurados, String correo){
        for(MiembroJurado j: jurados)
        {
            if(j.email.equals(correo))
                return j;
        }
        return null;
    }
    
    public static int getIdDueñoSearchedByMail(String correo){
        ArrayList<MiembroJurado> jurados = readFileMiembroJurado("miembroJurados.txt");
        MiembroJurado jurado = searchByCorreo(jurados, correo);
        return jurado.id;
    }
    
    public static MiembroJurado getDueñoSearchedByMail(String correo){
        ArrayList<MiembroJurado> jurados = readFileMiembroJurado("miembroJurados.txt");
        MiembroJurado jurado = searchByCorreo(jurados, correo);
        return jurado;
    }
    
    public static Boolean correoInFile(String correo){
        try(Scanner sc = new Scanner(new File("miembroJurados.txt")))
        {
            while(sc.hasNextLine()){                
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                if(tokens[4].equals(correo))
                    return true;
           }   
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public static ArrayList<String> getNombres(ArrayList<MiembroJurado> jurados){
        ArrayList<String> nombresJurados = new ArrayList<String>();
        for(MiembroJurado j : jurados){
            if(!nombresJurados.contains(j.nombres))
                nombresJurados.add(j.nombres);       
        }
        return nombresJurados;
    }    
}
