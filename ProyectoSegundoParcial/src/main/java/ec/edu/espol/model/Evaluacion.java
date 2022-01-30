/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Evaluacion {
    private int id, idInscripcion, idCriterio, idMiembroJurado;
    private double nota;

    public Evaluacion(int id, int idInscripcion, int idCriterio, int idMiembroJurado, double nota) {
        this.id = id;
        this.idInscripcion = idInscripcion;
        this.idCriterio = idCriterio;
        this.idMiembroJurado = idMiembroJurado;
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

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public int getIdCriterio() {
        return idCriterio;
    }

    public void setIdCriterio(int idCriterio) {
        this.idCriterio = idCriterio;
    }

    public int getIdMiembroJurado() {
        return idMiembroJurado;
    }

    public void setIdMiembroJurado(int idMiembroJurado) {
        this.idMiembroJurado = idMiembroJurado;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Evaluacion{" + "id=" + id + ", idInscripcion=" + idInscripcion + ", idCriterio=" + idCriterio + ", idMiembroJurado=" + idMiembroJurado + ", nota=" + nota + '}';
    }

    
    public void saveFile(String nomfile){
        StringBuilder sb = new StringBuilder();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomfile, true))) {
            
            sb.append(this.id).append("|");
            sb.append(this.idInscripcion).append("|");
            sb.append(this.idCriterio).append("|");
            sb.append(this.idMiembroJurado).append("|");
            sb.append(this.nota);
            
            bw.write(sb.toString());
        } catch (IOException e) {
            System.out.println(e);
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
