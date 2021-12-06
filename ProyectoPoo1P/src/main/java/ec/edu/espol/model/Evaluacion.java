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
import java.util.Objects;
import java.util.Scanner;

public class Evaluacion {
    private int id, idInscripcion, idCriterio, idMiembroJurado;
    private Inscripcion inscripcion;
    private MiembroJurado miembroJurado;
    private double nota;
    private Criterio criterio;

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

    public Criterio getCriterio() {
        return criterio;
    }

    public void setCriterio(Criterio criterio) {
        this.criterio = criterio;
    }

    @Override
    public String toString() {
        return "Evaluacion{" + "nota=" + nota + '}';
    }
    
    public static Evaluacion nextEvaluacion (Scanner sc, String nomfile){
        int id = Util.nextID(nomfile);
        String correo;        
        do{
            System.out.println("Ingrese el correo electrónico del Dueño de la mascota: ");
            correo = sc.next();
        }while(!(MiembroJurado.correoInFile(correo)));
        
        System.out.println("Ingrese el id de la inscripción: ");
        int idInscripcion = sc.nextInt();
        
        System.out.println("Ingrese id del criterio: ");
        int idCriterio = sc.nextInt();
        
        System.out.println("Ingrese la nota de la evaluacion: ");
        double notaEvaluacion = sc.nextDouble();
        
        //Evaluacion v1 = new Evaluacion(mail,idInscripcion,idCriterio,notaEvaluacion);
        //Evaluacion evaluacion = Evaluacion(id, idInscripcion, idCriterio, idMiembroJurado, inscripcion, miembroJurado, nota, criterio);
        return null;
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
