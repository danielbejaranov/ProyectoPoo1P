/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import static ec.edu.espol.model.Concurso.getIdConcursoSearchedByNombre;
import static ec.edu.espol.model.Mascota.getIdMascotaSearchedByNombre;
import ec.edu.espol.util.Util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Inscripcion {
    private int id, idMascota, idConcurso;
    private Mascota mascota;
    private Concurso concurso;
    private ArrayList<Evaluacion> evaluaciones;
    private double valor, descuento;
    private Date fechaInscripcion;

    public Inscripcion(double valor) {
        this.valor = valor;
        this.descuento = descuento;
    }

    public Inscripcion(int id, int idMascota, int idConcurso, double valor, Date fechaInscripcion) {
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
    
    public static Inscripcion nextInscripcion (Scanner sc, String nomfile){
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
        int yearI = sc.nextInt() - 1900;
        System.out.println("Ingrese el mes de inscripción : ");
        int mesI = sc.nextInt() -1;
        System.out.println("Ingrese el día de inscripción : ");
        int diaI = sc.nextInt();
        Date fechaInscripcion = new Date(yearI, mesI, diaI);        

        Inscripcion i1 = new Inscripcion(id, idMascota, idConcurso,valor, fechaInscripcion);
        return i1;
    }
    
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
    public static ArrayList<Inscripcion> readFileInscripciones(String nomfile){
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomfile))){
            while(sc.hasNextLine())
            {
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                //Inscripcion inscripcion = new Inscripcion(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]), tokens[2], tokens[3], tokens[4], tokens[5], tokens[6]);
                //                                          (int id, int idMascota, int idConcurso, Mascota mascota, Concurso concurso, ArrayList<Evaluacion> evaluaciones, double valor, double descuento)
                //inscripciones.add(inscripcion);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
        //return jurados;        
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
