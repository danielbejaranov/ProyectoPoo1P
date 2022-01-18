
package ec.edu.espol.model;

import ec.edu.espol.util.Util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Concurso {
    private int id;
    private String nombre,tematica;
    private LocalDateTime fechaConcurso;
    private LocalDate fechaCierre,fechaInicio;
    private double costo;
    
    String pattern = "yyyy-MM-dd";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    public Concurso(int id, String nombre, LocalDateTime fechaConcurso, LocalDate fechaInicio, LocalDate fechaCierre, String tematica, double costo) {
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

    public LocalDateTime getFechaConcurso() {
        return fechaConcurso;
    }

    public void setFechaConcurso(LocalDateTime fechaConcurso) {
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


    public static Concurso nextConcurso (Scanner sc, String nomfile){
        System.out.println("Registrar Concurso");
        
        int id = Util.nextID(nomfile);                
        System.out.println("Ingrese el nombre del concurso: ");
        String nombre = sc.next();
           
        System.out.println("Fecha del concurso");
        System.out.println("Ingrese el año del concurso: ");
        int yearConcurso = sc.nextInt();
        System.out.println("Ingrese el mes del concurso: ");
        int mesConcurso = sc.nextInt();
        System.out.println("Ingrese el día del concurso: ");
        int diaConcurso = sc.nextInt();
        System.out.println("Ingrese hora de inicio del concurso");
        int horaConcurso = sc.nextInt();
        System.out.println("Ingrese minuto de inicio del concurso");
        int minutoConcurso = sc.nextInt();
        LocalDateTime fechaConcurso = LocalDateTime.of(yearConcurso, mesConcurso, diaConcurso, horaConcurso, minutoConcurso);
       
        
        System.out.println("Ingrese la fecha de inicio de inscripciones ");        
        System.out.println("Ingrese el año del concurso: ");
        int yearInicio = sc.nextInt();
        System.out.println("Ingrese el mes del concurso: ");
        int mesInicio = sc.nextInt();
        System.out.println("Ingrese el día del concurso: ");
        int diaInicio = sc.nextInt();
        LocalDate fechaInicio = LocalDate.of(yearInicio, mesInicio, diaInicio);        

        System.out.println("Ingrese la fecha de cierre de incripciones ");
        System.out.println("Ingrese el año del concurso: ");
        int yearCierre = sc.nextInt();
        System.out.println("Ingrese el mes del concurso: ");
        int mesCierre = sc.nextInt();
        System.out.println("Ingrese el día del concurso: ");
        int diaCierre = sc.nextInt();
        LocalDate fechaCierre = LocalDate.of(yearCierre, mesCierre, diaCierre);
        
        
        
        System.out.println("Ingrese la tematica: ");
        String tematica = sc.next();
        System.out.println("Ingrese el costo: ");
        double costo = sc.nextDouble();
        Concurso concurso = new Concurso(id,nombre,fechaConcurso,fechaInicio,fechaCierre,tematica,costo);
        concurso.setId(id);
        concurso.saveFile(nomfile);  
        return concurso;
    }
    
    public void saveFile(String nomfile){
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true))){
            pw.println(this.id + "|" + this.nombre + "|" + this.fechaConcurso + "|" + this.fechaInicio + "|" + this.fechaCierre + "|" + this.tematica + "|" + this.costo);
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        }
    }
    public static void saveFile(ArrayList<Concurso> concursos, String nomfile){
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile)))){
            for(Concurso m : concursos)
                pw.println(m.getId() + "|" + m.getNombre()+ "|" + m.getFechaConcurso() + "|" + m.getFechaInicio() + "|" + m.getFechaCierre()+ "|" + m.getTematica()+ "|" + m.getCosto());
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Concurso> readFileConcurso(String nomfile) throws ParseException{
        ArrayList<Concurso> concursos = new ArrayList<>();
                        
                try{
                    FileReader reader = new FileReader(nomfile);
                    BufferedReader bf = new BufferedReader(reader);
                    String linea;
                    
              
                    while((linea = bf.readLine()) != null){
                        String[] tokens = linea.split("\\|");//  int id, String nombre, Date fechaConcurso, Date fechaInicio, Date fechaCierre, String tematica, double costo
                        
                        Concurso p = new Concurso( // 1|perroslokos|Sat Mar 04 23:12:00 EAST 2|Sat Mar 04 00:00:00 EAST 2|Sun Jun 07 00:00:00 EAST 5|perroslokso|23.0
                                Integer.parseInt(tokens[0]), 
                                tokens[1],
                                LocalDateTime.parse(tokens[2]),
                                LocalDate.parse(tokens[3]),
                                LocalDate.parse(tokens[4]),
                                tokens[5],
                                Double.parseDouble(tokens[6]));
                        concursos.add(p);     
                    }
                    bf.close();
                    reader.close();
                    System.out.println(concursos);

                }catch(IOException | NumberFormatException e ){
                    System.out.println("No se pudo abrir el archivo");
                }
                return concursos;
            }
            
              

    public static Concurso searchByNombre(ArrayList<Concurso> concursos, String nombre){
        for(Concurso c: concursos) //perroslokos
        {
            if(c.nombre.equals(nombre))
                return c; 
        }
        return null;
    }
    
    public static int getIdConcursoSearchedByNombre(String nombre) throws ParseException{
            ArrayList<Concurso> concursos = readFileConcurso("concursos.txt");
            Concurso concurso = searchByNombre(concursos, nombre);
            System.out.println(concurso.id);
            return concurso.id;
        }
    
    public static Concurso getConcursoSearchedByNombre(String correo) throws ParseException{
        ArrayList<Concurso> concursos = readFileConcurso("concursos.txt");
        Concurso concurso = searchByNombre(concursos, correo);
        return concurso;
    }    
}
