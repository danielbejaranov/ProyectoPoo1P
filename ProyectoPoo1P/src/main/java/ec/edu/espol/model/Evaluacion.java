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
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Daniel Bejarano
 */
public class Evaluacion {
    private int id, idInscripcion, idMiembro;
    private Inscripcion inscripcion;
    private MiembroJurado miembroJurado;
    private double nota;

    public Evaluacion(int id, int idInscripcion, int idMiembro, Inscripcion inscripcion, MiembroJurado miembroJurado, double nota) {
        this.id = id;
        this.idInscripcion = idInscripcion;
        this.idMiembro = idMiembro;
        this.inscripcion = inscripcion;
        this.miembroJurado = miembroJurado;
        this.nota = nota;
    }

    public Evaluacion(double nota){
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripción) {
        this.idInscripcion = idInscripción;
    }

    public int getIdMiembro() {
        return idMiembro;
    }

    public void setIdMiembro(int idMiembro) {
        this.idMiembro = idMiembro;
    }

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

    public MiembroJurado getMiembroJurado() {
        return miembroJurado;
    }

    public void setMiembroJurado(MiembroJurado miembroJurado) {
        this.miembroJurado = miembroJurado;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Evaluacion{" + "nota=" + nota + '}';
    }

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Evaluacion other = (Evaluacion) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.idInscripcion != other.idInscripcion) {
            return false;
        }
        if (this.idMiembro != other.idMiembro) {
            return false;
        }
        if (Double.doubleToLongBits(this.nota) != Double.doubleToLongBits(other.nota)) {
            return false;
        }
        if (!Objects.equals(this.inscripcion, other.inscripcion)) {
            return false;
        }
        if (!Objects.equals(this.miembroJurado, other.miembroJurado)) {
            return false;
        }
        return true;
    }

    
    public static Evaluacion nextCalificacion (Scanner sc){
        System.out.println("Ingrese la Evaluacion: ");
        sc.nextLine();
        double nota = sc.nextDouble();
        Evaluacion v1 = new Evaluacion(nota);
         return v1;
    }
    public void saveFile(String nomfile){
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true))){
            pw.println(this.nota );
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        }
    }
    public static void saveFile(ArrayList<Evaluacion> evaluaciones, String nomfile){
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile)))){
            for(Evaluacion m : evaluaciones)
                pw.println(m.getNota());
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        }
    }
}
