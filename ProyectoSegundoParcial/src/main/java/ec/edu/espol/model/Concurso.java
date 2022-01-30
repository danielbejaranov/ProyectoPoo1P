
package ec.edu.espol.model;

import ec.edu.espol.util.Util;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Concurso {
    private int id;
    private String nombre,tematica;
    private LocalDate fechaCierre,fechaInicio, fechaConcurso;
    private double costo;
    
    String pattern = "yyyy-MM-dd";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    public Concurso(int id, String nombre, LocalDate fechaConcurso, LocalDate fechaInicio, LocalDate fechaCierre, String tematica, double costo) {
        this.id = id;
        this.nombre = nombre;
        this.fechaConcurso = fechaConcurso;
        this.fechaInicio = fechaInicio;
        this.fechaCierre = fechaCierre;
        this.tematica = tematica;
        this.costo = costo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaConcurso() {
        return fechaConcurso;
    }

    public void setFechaConcurso(LocalDate fechaConcurso) {
        this.fechaConcurso = fechaConcurso;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(LocalDate fechaCierre) {
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

    @Override
    public String toString() {
        return "Concurso{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
    public void saveFile(String nomfile){
        StringBuilder sb = new StringBuilder();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomfile, true))) {
            
            sb.append(this.id).append("|");
            sb.append(this.nombre).append("|");
            sb.append(this.fechaConcurso).append("|");
            sb.append(this.fechaInicio).append("|");
            sb.append(this.fechaCierre).append("|");
            sb.append(this.tematica).append("|");
            sb.append(this.costo);
            
            bw.write(sb.toString());
        } catch (IOException e) {
            System.out.println(e);
        }        
    }
    
    public static void saveFile(ArrayList<Concurso> concursos, String nomfile){
        StringBuilder sb = new StringBuilder();        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomfile))) {            
            for (Concurso c : concursos) {
                sb.append(c.id).append("|");
                sb.append(c.nombre).append("|");
                sb.append(c.fechaConcurso).append("|");
                sb.append(c.fechaInicio).append("|");
                sb.append(c.fechaCierre).append("|");
                sb.append(c.tematica).append("|");
                sb.append(c.costo);                
            }
            bw.write(sb.toString());
        } catch (IOException e) {
            System.out.println(e);
        }        
    }

    public static ArrayList<Concurso> readFileConcurso(String nomfile) {
        ArrayList<Concurso> concursos = new ArrayList<>();
        try (BufferedReader bw = new BufferedReader(new FileReader(nomfile))) {
            String linea;
            while ((linea = bw.readLine()) != null) {
                String [] tokens = linea.split("|");
                Concurso c = new Concurso(
                                Integer.parseInt(tokens[0]), 
                                tokens[1],
                                LocalDate.parse(tokens[2]),
                                LocalDate.parse(tokens[3]),
                                LocalDate.parse(tokens[4]),
                                tokens[5],
                                Double.parseDouble(tokens[6]));                        
                concursos.add(c);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return concursos;        
    }            

    public static Concurso searchByNombre(ArrayList<Concurso> concursos, String nombre){
        for(Concurso c: concursos)
        {
            if(c.nombre.equals(nombre))
                return c; 
        }
        return null;
    }
    
    public static Concurso getConcursoSearchedByNombre(String nombre) throws ParseException{
        ArrayList<Concurso> concursos = readFileConcurso("concursos.txt");
        Concurso concurso = searchByNombre(concursos, nombre);
        return concurso;
    }    
}
