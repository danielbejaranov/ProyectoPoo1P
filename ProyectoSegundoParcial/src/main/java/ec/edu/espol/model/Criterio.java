/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.util.Util;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Criterio {

    private String descripcion;
    private int id, idConcurso;

    public Criterio(int id, String descripcion) {
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
}
