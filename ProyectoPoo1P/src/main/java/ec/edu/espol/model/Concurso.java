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

public class Concurso {
    private String nombre, fecha,fechaInscripcion,fechaCierre,tematica;
    private double costo;

    public Concurso(String nombre, String fecha, String fechaInscripcion, String fechaCierre, String tematica, double costo) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.fechaInscripcion = fechaInscripcion;
        this.fechaCierre = fechaCierre;
        this.tematica = tematica;
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(String fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(String fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    public static Concurso nextConcurso (Scanner sc, String nomfile){
        System.out.println("Registrar Concurso");
        
        int id = Util.nextID(nomfile);                
        System.out.println("Ingrese el nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese la fecha: ");
        String fecha = sc.nextLine();
        System.out.println("Ingrese la fechaInscripcion: ");
        String fechaInscripcion = sc.nextLine();
        System.out.println("Ingrese la fechaCierre: ");
        String fechaCierre = sc.nextLine();
        System.out.println("Ingrese la tematica: ");
        String tematica = sc.nextLine();
        System.out.println("Ingrese el costo: ");
        double costo = sc.nextDouble();
        Concurso co1 = new Concurso(nombre,fecha,fechaInscripcion,fechaCierre,tematica,costo);
        return co1;
    }
    public void saveFile(String nomfile){
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true))){
            pw.println(this.nombre + "," + this.fecha + "," + this.fechaInscripcion + "," + this.fechaCierre + "," + this.tematica + "," + this.costo);
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        }
    }
    public static void saveFile(ArrayList<Concurso> concursos, String nomfile){
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile)))){
            for(Concurso m : concursos)
                pw.println(m.getNombre()+ "," + m.getFecha() + "," + m.getFechaInscripcion() + "," + m.getFechaCierre()+ "," + m.getTematica()+ "," + m.getCosto());
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        }
    }
}
