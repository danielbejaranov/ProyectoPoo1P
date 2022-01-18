/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import static ec.edu.espol.model.Concurso.getIdConcursoSearchedByNombre;
import static ec.edu.espol.model.Mascota.getIdMascotaSearchedByNombre;
import ec.edu.espol.util.Util;
import java.io.BufferedReader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Inscripcion {
    private int id, idMascota, idConcurso;
    private Mascota mascota;
    private Concurso concurso;
    private ArrayList<Evaluacion> evaluaciones;
    private double valor, descuento;
    private LocalDate fechaInscripcion;

    public Inscripcion(double valor) {
        this.valor = valor;
        this.descuento = descuento;
    }

    public Inscripcion(int id, int idMascota, int idConcurso, double valor, LocalDate fechaInscripcion) {
        this.id = id;
        this.idMascota = idMascota;
        this.idConcurso = idConcurso;
        this.valor = valor;
        this.fechaInscripcion = fechaInscripcion;
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
    
    public static Inscripcion nextInscripcion (Scanner sc, String nomfile) throws ParseException{
        int id = Util.nextID(nomfile);
        
        System.out.println("Ingrese el nombre de la mascota: ");
        String nombreMascota = sc.next();
        int idMascota = getIdMascotaSearchedByNombre(nombreMascota);
        
        System.out.println("Ingrese el nombre del concurso: ");
        String nombreConcurso = sc.next();
        int idConcurso = getIdConcursoSearchedByNombre(nombreConcurso);
        
        System.out.println("Ingrese el valor: ");
        double valor = sc.nextDouble();
        
        System.out.println("Ingrese la fecha de inscripción ");        
        System.out.println("Ingrese el año de inscripción : ");
        int yearI = sc.nextInt();
        System.out.println("Ingrese el mes de inscripción : ");
        int mesI = sc.nextInt();
        System.out.println("Ingrese el día de inscripción : ");
        int diaI = sc.nextInt();
      
        LocalDate fechaInscripcion = LocalDate.of(yearI, mesI, diaI);
                
        Inscripcion i = new Inscripcion(id, idMascota, idConcurso,valor, fechaInscripcion);
        i.saveFile(nomfile);        
        i.setId(id);
        return i;
    }
    
    public void saveFile(String nomfile){
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true))){
            pw.println(this.id+"|"+this.idMascota+"|"+this.idConcurso+"|"+this.valor + "|" + this.descuento );
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        }
    }
    public static void saveFile(ArrayList<Inscripcion> inscripcion, String nomfile){
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile)))){
            for(Inscripcion m : inscripcion)
                pw.println(m.id+"|"+m.idMascota+"|"+m.idConcurso+"|"+m.valor + "|" + m.descuento );
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        }
    }
    public static ArrayList<Inscripcion> readFileInscripciones(String nomfile){
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();

        try{
            FileReader reader = new FileReader(nomfile);
            BufferedReader bf = new BufferedReader(reader);
            String linea;


            while((linea = bf.readLine()) != null){
                String[] tokens = linea.split("\\|");

                Inscripcion p = new Inscripcion( // int id, int idMascota, int idConcurso, double valor, LocalDate fechaInscripcion
                        Integer.parseInt(tokens[0]), 
                        Integer.parseInt(tokens[1]), 
                        Integer.parseInt(tokens[2]), 
                        Double.parseDouble(tokens[3]),
                        LocalDate.parse(tokens[4]));
                inscripciones.add(p);     
            }
            bf.close();
            reader.close();


        }catch(IOException | NumberFormatException e ){
            System.out.println("No se pudo abrir el archivo");
        }
        return inscripciones;
    }
    
    public static MiembroJurado searchByCorreo(ArrayList<Inscripcion> inscripciones, String correo){
        for(Inscripcion i: inscripciones)
        {
            //if(i.email.equals(correo))
                //return i;
        }
        return null;
    }
    
    public static int getIdDueñoSearchedByMail(String correo){
        ArrayList<Inscripcion> inscripciones = readFileInscripciones("miembroJurados.txt");
        MiembroJurado jurado = searchByCorreo(inscripciones, correo);
        return jurado.id;
    }
    
    public static MiembroJurado getDueñoSearchedByMail(String correo){
        ArrayList<Inscripcion> inscripciones = readFileInscripciones("miembroJurados.txt");
        MiembroJurado jurado = searchByCorreo(inscripciones, correo);
        return jurado;
    }    
}
