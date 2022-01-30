/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import static ec.edu.espol.model.Concurso.readFileConcurso;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Criterio {

    private String descripcion;
    private int id, idConcurso;

    public Criterio(int id, int idConcurso, String descripcion) {
        this.id = id;
        this.idConcurso = idConcurso;
        this.descripcion = descripcion;        
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

    public void saveFile(String nomfile) {
        StringBuilder sb = new StringBuilder();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomfile, true))) {

            sb.append(this.id).append("|");
            sb.append(this.idConcurso).append("|");
            sb.append(this.descripcion);

            bw.write(sb.toString());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void saveFile(ArrayList<Criterio> criterios, String nomfile) {
        StringBuilder sb = new StringBuilder();        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomfile))) {            
            for (Criterio c : criterios) {
                
                sb.append(c.id).append("|");
                sb.append(c.idConcurso).append("|");
                sb.append(c.descripcion);
                
            bw.write(sb.toString());
            }
        } catch (IOException e) {
            System.out.println(e);
        }        
    }
    
    public static ArrayList<Criterio> readFileConcurso(String nomfile) {
        ArrayList<Criterio> criterios = new ArrayList<>();
        try (BufferedReader bw = new BufferedReader(new FileReader(nomfile))) {
            String linea;
            while ((linea = bw.readLine()) != null) {
                String [] tokens = linea.split("|");
                Criterio c = new Criterio(
                                Integer.parseInt(tokens[0]), 
                                Integer.parseInt(tokens[1]),
                                tokens[2]);                      
                criterios.add(c);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return criterios;        
    }

    public static Criterio searchByDescripcion(ArrayList<Criterio> criterios, String descripcion){
        for(Criterio c: criterios)
        {
            if(c.descripcion.equals(descripcion))
                return c; 
        }
        return null;
    }
    
    public static Criterio getConcursoSearchedByDescripcion(String descripcion) throws ParseException{
        ArrayList<Criterio> criterios = readFileConcurso("criterios.txt");
        Criterio criterio = searchByDescripcion(criterios, descripcion);
        return criterio;
    }    
}
