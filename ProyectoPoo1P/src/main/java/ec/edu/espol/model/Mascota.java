/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.util.ArrayList;
import java.util.Date;
<<<<<<< HEAD
import java.util.Scanner;

=======

/**
 *
 * @author Daniel Bejarano
 */
>>>>>>> 637c0e93b3fc62d109e7dea6781297f0d61ee1c8
public class Mascota {
    private int id, idDueño;
    private String nombre, raza, tipo;
    private Date fechaNacimiento;
<<<<<<< HEAD
    private Dueno dueño;
    private ArrayList<Inscripcion> inscripciones;
=======
    private Dueño dueño;
    private ArrayList<Inscripción> inscripciones;
>>>>>>> 637c0e93b3fc62d109e7dea6781297f0d61ee1c8

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDueño() {
        return idDueño;
    }

    public void setIdDueño(int idDueño) {
        this.idDueño = idDueño;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

<<<<<<< HEAD
    public Dueno getDueño() {
        return dueño;
    }

    public void setDueño(Dueno dueño) {
        this.dueño = dueño;
    }

    public ArrayList<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(ArrayList<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public Mascota(String nombre, String raza, String tipo, String fechaNacimiento1) {
        this.id = id;
        this.idDueño = idDueño;
        this.nombre = nombre;
        this.raza = raza;
        this.tipo = tipo;
        this.fechaNacimiento = fechaNacimiento;
        this.dueño = dueño;
        this.inscripciones = inscripciones;
    }

    public Mascota(String nombre, String raza, String tipo, Date fechaNacimiento) {
        this.nombre = nombre;
        this.raza = raza;
        this.tipo = tipo;
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Mascota{" + "nombre=" + nombre + ", raza=" + raza + ", tipo=" + tipo + ", fechaNacimiento=" + fechaNacimiento + '}';
    }

    
    
   public static Mascota nextMascota (Scanner sc){
        System.out.println("Ingrese el nombre de su mascota: ");
        sc.nextLine();
        String nombre = sc.nextLine();
        System.out.println("Ingrese la raza de su mascota: ");
        String raza = sc.nextLine();
        System.out.println("Ingrese el tipo de su mascota: ");
        String tipo = sc.nextLine();
        System.out.println("Ingrese la fehca de nacimiento de su mascota: ");
        String fechaNacimiento = sc.nextLine();
        
        
         Mascota m1 = new Mascota(nombre,raza,tipo,fechaNacimiento);
         return m1;
    } 
=======
    public Dueño getDueño() {
        return dueño;
    }

    public void setDueño(Dueño dueño) {
        this.dueño = dueño;
    }

    public ArrayList<Inscripción> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(ArrayList<Inscripción> inscripciones) {
        this.inscripciones = inscripciones;
    }
    
    
>>>>>>> 637c0e93b3fc62d109e7dea6781297f0d61ee1c8
}
