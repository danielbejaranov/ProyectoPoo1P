/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.util.ArrayList;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Inscripcion {
    private int id, idMascota, idConcurso;
    private Mascota mascota;
    private Concurso concurso;
    private ArrayList<Evaluacion> evaluaciones;
    private double valor, descuento;

    public Inscripcion(double valor, double descuento) {
        this.valor = valor;
        this.descuento = descuento;
    }

    public Inscripcion(int id, int idMascota, int idConcurso, Mascota mascota, Concurso concurso, ArrayList<Evaluacion> evaluaciones, double valor, double descuento) {
        this.id = id;
        this.idMascota = idMascota;
        this.idConcurso = idConcurso;
        this.mascota = mascota;
        this.concurso = concurso;
        this.evaluaciones = evaluaciones;
        this.valor = valor;
        this.descuento = descuento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public int getIdConcurso() {
        return idConcurso;
    }

    public void setIdConcurso(int idConcurso) {
        this.idConcurso = idConcurso;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Concurso getConcurso() {
        return concurso;
    }

    public void setConcurso(Concurso concurso) {
        this.concurso = concurso;
    }

    public ArrayList<Evaluacion> getEvaluaciones() {
        return evaluaciones;
    }

    public void setEvaluaciones(ArrayList<Evaluacion> evaluaciones) {
        this.evaluaciones = evaluaciones;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "valor=" + valor + ", descuento=" + descuento + '}';
    }
    public static Inscripcion nextInscripcion (Scanner sc){
        System.out.println("Ingrese el valor: ");
        sc.nextLine();
        double descuento = sc.nextDouble();
        System.out.println("Ingrese el decuento: ");
        double valor = sc.nextDouble();
        Inscripcion i1 = new Inscripcion(valor,descuento);
        return i1;}
    public void saveFile(String nomfile){
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true))){
            pw.println(this.valor + "," + this.descuento );
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        }
    }
    public static void saveFile(ArrayList<Inscripcion> inscripcion, String nomfile){
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile)))){
            for(Inscripcion m : inscripcion)
                pw.println(m.getValor()+ "," + m.getDescuento());
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        }
    }
}
