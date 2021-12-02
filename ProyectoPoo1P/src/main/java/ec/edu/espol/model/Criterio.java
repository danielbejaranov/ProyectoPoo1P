/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Criterio {
    private String descripcion;

    public Criterio(String descripcion) {
        this.descripcion = descripcion;
    }
    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public static Criterio nextCriterio (Scanner sc){
        System.out.println("Ingrese el criterio: ");
        sc.nextLine();
        String descripcion = sc.nextLine();
        Criterio cr1 = new Criterio(descripcion);
         return cr1;
    }
    public void saveFile(String nomfile){
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true))){
            pw.println(this.descripcion );
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        }
    }
    public static void saveFile(ArrayList<Criterio> criterios, String nomfile){
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile)))){
            for(Criterio m : criterios)
                pw.println(m.getDescripcion());
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        }
    }
}
