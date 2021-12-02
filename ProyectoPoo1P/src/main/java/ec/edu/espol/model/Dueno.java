/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Dueno extends Persona{
    private String direccion;
    private ArrayList<Mascota> mascotas;

    public Dueno(String nombres, String direccion, String apellidos, String telefono, String email) {
        super(id, nombres, apellidos, telefono, email);
        this.direccion = direccion;
    }


    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
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
    public static Dueno nextDueno (Scanner sc){
        System.out.println("Ingrese sus nombres: ");
        sc.nextLine();
        String nombres = sc.nextLine();
        System.out.println("Ingrese sus apellidos: ");
        String apellidos = sc.nextLine();
        System.out.println("Ingrese su direccion: ");
        String direccion = sc.nextLine();
        System.out.println("Ingrese su telefono: ");
        String telefono = sc.nextLine();
        System.out.println("Ingrese su correo: ");
        String email = sc.nextLine();
        Dueno d1 = new Dueno(nombres,apellidos,direccion,telefono,email);
         return d1;
    }
    @Override
    public String toString() {
        return "Dueño{" + "nombres=" + nombres + ", apellidos=" + apellidos + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + '}';
    }
    
    public void saveFile(String nomfile){
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true))){
            pw.println(this.nombres + "," + this.apellidos + "," + this.direccion + "," + this.telefono + "," + this.email);
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        }
    }
    public static void saveFile(ArrayList<Dueno> dueños, String nomfile){
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile)))){
            for(Dueno d : dueños)
                pw.println(d.getNombres()+ "," + d.getApellidos() + "," + d.getDireccion() + "," + d.getTelefono() + "," + d.getEmail());
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        }
    }
}
