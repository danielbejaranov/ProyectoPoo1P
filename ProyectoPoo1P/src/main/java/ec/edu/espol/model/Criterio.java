/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import static ec.edu.espol.model.Premio.saveFile;
import ec.edu.espol.util.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Criterio {
    private String descripcion;
    private int id,idConcurso;

    public Criterio( int id, String descripcion) {
        this.descripcion = descripcion;
    }

    public Criterio(String descripcion, int id, int idConcurso) {
        this.descripcion = descripcion;
        this.id = id;
        this.idConcurso = idConcurso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdConcurso() {
        return idConcurso;
    }

    public void setIdConcurso(int idConcurso) {
        this.idConcurso = idConcurso;
    }
    
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public static void nextCriterio (Scanner sc, String nomfile) throws ParseException{
        int id = Util.nextID(nomfile);
        System.out.println("Ingrese cantidad de criterios");
        int numeroCriterios = sc.nextInt();
        ArrayList<Criterio> criterios = new ArrayList<>();
        
            for(int i = 0; i < numeroCriterios; i++){
                System.out.println("Ingrese una descripcion: ");
                String descripcion = sc.next();

                Criterio c1 = new Criterio(id,descripcion);
                criterios.add(c1);
            } 
        
        System.out.println("Ingrese nombre del concurso: ");
        String nombreConcurso = sc.next();
        int idConcurso1 = Concurso.getIdConcursoSearchedByNombre(nombreConcurso);
     
        for (Criterio c : criterios)
        {
            c.setIdConcurso(idConcurso1);
            c.setId(id);
        }
        saveFile(criterios,nomfile);
    }
    
    public void saveFile(String nomfile){
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true))){
            pw.println(this.id+"|"+this.idConcurso+"|"+this.descripcion );
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        }
    }
    public static void saveFile(ArrayList<Criterio> criterios, String nomfile){
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true))){
            for(Criterio m : criterios)
                pw.println(m.id+"|"+m.idConcurso+"|"+m.descripcion );
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        }
    }
}
