/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.util.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
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
        sc.useDelimiter("\n");

        int id = Util.nextID(nomfile);
        System.out.println("Ingrese los nombres: ");
        String nombres = sc.next();
        System.out.println("Ingrese los apellidos: ");
        String apellidos = sc.next();
        System.out.println("Ingrese el telefono: ");
        String telefono = sc.next();
        System.out.println("Ingrese el correo: ");
        String email = sc.next();
        System.out.println("Ingrese el perfil: ");
        String perfil = sc.next();
        
        MiembroJurado personaJurado = new MiembroJurado(id,nombres,apellidos,telefono,email,perfil);
        personaJurado.saveFile(nomfile);
        return personaJurado;
    }
    
    public void saveFile(String nomfile){
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true))){
            pw.println(this.nombres + "," + this.apellidos + "," + this.telefono + "," + this.email + "," + this.perfil);
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        }
    }
    public static void saveFile(ArrayList<MiembroJurado> miembroJurados, String nomfile){
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile)))){
            for(MiembroJurado m : miembroJurados)
                pw.println(m.getNombres()+ "," + m.getApellidos() + "," + m.getTelefono() + "," + m.getEmail()+ "," + m.getPerfil());
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        }
    }
}
