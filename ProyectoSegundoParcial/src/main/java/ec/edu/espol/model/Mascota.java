/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.util.Util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;



public class Mascota {
    private int id, idDueño;
    private String nombre, raza, tipo;
    private LocalDate fechaNacimiento;
    private ArrayList<Inscripcion> inscripciones;

    public Mascota(int id, int idDueño, String nombre, String raza, String tipo, LocalDate fechaNacimiento) {
        this.id = id;
        this.idDueño = idDueño;
        this.nombre = nombre;
        this.raza = raza;
        this.tipo = tipo;
        this.fechaNacimiento = fechaNacimiento;
        this.inscripciones = new ArrayList();
    }
    
    public Mascota(){
        
    }

    @Override
    public String toString() {
        return "Mascota{" + "nombre=" + nombre + ", raza=" + raza + ", tipo=" + tipo + ", fechaNacimiento=" + fechaNacimiento + '}';
    }

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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public ArrayList<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(ArrayList<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }
    
    public static Mascota nextMascota (Scanner sc, String nomfile){
        System.out.println("Registrar Mascota");
        
        int id = Util.nextID(nomfile);
        String correo;        
        do{
            System.out.println("Ingrese el correo electrónico del Dueño de la mascota: ");
            correo = sc.next();
        }while(!(Dueno.correoInFile(correo)));
        
        int idDueño = Dueno.getDueñoSearchedByMail(correo).getId();
        System.out.println("Ingrese el nombre de su mascota: ");
        String nombre = sc.next();
        
        System.out.println("Ingrese la raza de su mascota: ");
        String raza = sc.next();
        
        System.out.println("Ingrese el tipo de su mascota: ");
        String tipo = sc.next();
        
        System.out.println("Ingrese el año de nacimiento de su mascota: ");
        int year = sc.nextInt();
        
        System.out.println("Ingrese el mes de nacimiento de su mascota: ");
        int mes = sc.nextInt() ;
        
        System.out.println("Ingrese el día de nacimiento de su mascota:");
        int dia = sc.nextInt();
        
        LocalDate fechaNacimiento = LocalDate.of(year, mes, dia);
        
        
        Mascota mascota = new Mascota(id, idDueño, nombre, raza, tipo, fechaNacimiento);
        mascota.saveFile(nomfile);   
        
        return mascota;
    }

    public void saveFile(String nomfile){
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true))){
            pw.println(this.id + "|" + this.idDueño + "|" + this.nombre + "|" + this.raza + "|" +  this.fechaNacimiento + "|" + this.tipo);
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        }
    }
  
    public static void saveFile(ArrayList<Mascota> mascotas, String nomfile){
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile)))){
            for(Mascota m : mascotas)
                pw.println(m.id+ "|" +m.idDueño+ "|" + m.nombre + "|" + m.raza + "|" + m.fechaNacimiento + "|" +m.tipo);
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Mascota> readFileMascota(String nomfile){
        ArrayList<Mascota> mascotas = new ArrayList<>();
                        try{
                    FileReader reader = new FileReader(nomfile);
                    BufferedReader bf = new BufferedReader(reader);
                    String linea;
                    
              
                    while((linea = bf.readLine()) != null){
                        String[] tokens = linea.split("\\|");//  int id, int idDueño, String nombre, String raza, String tipo, LocalDate fechaNacimiento
                        
                        Mascota p = new Mascota( //1|1|pinki|chihuahua|2004-03-01|perro

                                Integer.parseInt(tokens[0]), 
                                Integer.parseInt(tokens[1]), 
                                tokens[2],
                                tokens[3],
                                tokens[5],
                                LocalDate.parse(tokens[4]));

                        mascotas.add(p);     
                    }
                    bf.close();
                    reader.close();
                   

                }catch(IOException | NumberFormatException e ){
                    System.out.println("No se pudo abrir el archivo");
                }
                return mascotas;
            }

    public static Mascota searchByNombre(ArrayList<Mascota> mascotas, String nombre){
        for(Mascota m: mascotas)
        {
            if(m.nombre.equals(nombre))
                return m; // dar formato
        }
        return null;
    }
    
    public static int getIdMascotaSearchedByNombre(String nombre){
        ArrayList<Mascota> mascotas = readFileMascota("mascotas.txt");
        Mascota mascota = searchByNombre(mascotas, nombre);
        return mascota.id;
    }
    
    public static Mascota getDueñoSearchedByNombre(String nombre){
        ArrayList<Mascota> mascotas = readFileMascota("mascotas.txt");
        Mascota mascota= searchByNombre(mascotas, nombre);
        return mascota;
    }

}
