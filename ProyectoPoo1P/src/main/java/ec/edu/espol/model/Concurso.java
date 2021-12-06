
package ec.edu.espol.model;

import ec.edu.espol.util.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Concurso {
    private int id;
    private String nombre,tematica;
    private Date fechaConcurso,fechaInicio,fechaCierre;
    private double costo;

    public Concurso(int id, String nombre, Date fechaConcurso, Date fechaInicio, Date fechaCierre, String tematica, double costo) {
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

    public Date getFechaConcurso() {
        return fechaConcurso;
    }

    public void setFechaConcurso(Date fechaConcurso) {
        this.fechaConcurso = fechaConcurso;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
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
        System.out.println("Ingrese el nombre del concurso: ");
        String nombre = sc.next();
        
        System.out.println("Fecha del concurso");
        System.out.println("Ingrese el año del concurso: ");
        int yearConcurso = sc.nextInt() - 1900;
        System.out.println("Ingrese el mes del concurso: ");
        int mesConcurso = sc.nextInt() - 1;
        System.out.println("Ingrese el día del concurso: ");
        int diaConcurso = sc.nextInt();
        System.out.println("Ingrese hora de inicio del concurso");
        int horaConcurso = sc.nextInt();
        System.out.println("Ingrese minuto de inicio del concurso");
        int minutoConcurso = sc.nextInt();
        Date fechaConcurso = new Date(yearConcurso, mesConcurso, diaConcurso,horaConcurso,minutoConcurso);
        
        System.out.println("Ingrese la fecha de inicio de inscripciones ");        
        System.out.println("Ingrese el año del concurso: ");
        int yearInicio = sc.nextInt() - 1900;
        System.out.println("Ingrese el mes del concurso: ");
        int mesInicio = sc.nextInt() -1;
        System.out.println("Ingrese el día del concurso: ");
        int diaInicio = sc.nextInt();
        Date fechaInicio = new Date(yearInicio, mesInicio, diaInicio);        

        System.out.println("Ingrese la fecha de cierre de incripciones ");
        System.out.println("Ingrese el año del concurso: ");
        int yearCierre = sc.nextInt() -1900;
        System.out.println("Ingrese el mes del concurso: ");
        int mesCierre = sc.nextInt() - 1 ;
        System.out.println("Ingrese el día del concurso: ");
        int diaCierre = sc.nextInt();
        Date fechaCierre = new Date(yearCierre, mesCierre, diaCierre);
        
        System.out.println("Ingrese la tematica: ");
        String tematica = sc.next();
        System.out.println("Ingrese el costo: ");
        double costo = sc.nextDouble();
        Concurso concurso = new Concurso(id,nombre,fechaConcurso,fechaInicio,fechaCierre,tematica,costo);
        
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

    public static ArrayList<Concurso> readFileConcurso(String nomfile){
        ArrayList<Concurso> concursos = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomfile))){
            while(sc.hasNextLine())
            {
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                //Concurso concurso = new Concurso(Integer.parseInt(tokens[0]), tokens[1], Date.parse(tokens[2]), tokens[3], tokens[4], tokens[5]);
                //concursos.add(concurso);
                return null;
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return concursos;        
    }    

    public static Concurso searchByNombre(ArrayList<Concurso> concursos, String nombre){
        for(Concurso c: concursos)
        {
            if(c.nombre.equals(nombre))
                return c; // dar formato
        }
        return null;
    }
    
    public static int getIdConcursoSearchedByNombre(String nombre){
        ArrayList<Concurso> concursos = readFileConcurso("concursos.txt");
        Concurso concurso = searchByNombre(concursos, nombre);
        return concurso.id;
    }
    
    public static Concurso getConcursoSearchedByNombre(String correo){
        ArrayList<Concurso> concursos = readFileConcurso("concursos.txt");
        Concurso concurso = searchByNombre(concursos, correo);
        return concurso;
    }    
}
