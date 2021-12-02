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

public class Premio {
   private int lugar;
   private String descripcion;
   
   public Premio(int lugar,String descripcion){
       this.lugar = lugar;
       this.descripcion = descripcion;
   } 

    public int getLugar() {
        return lugar;
    }

    public void setLugar(int lugar) {
        this.lugar = lugar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
   public static Premio nextPremio (Scanner sc){
        System.out.println("Ingrese el lugar: ");
        sc.nextLine();
        int lugar = sc.nextInt();
        System.out.println("Ingrese una descripcion: ");
        String descripcion = sc.nextLine();
        Premio p1 = new Premio(lugar,descripcion);
         return p1;
    }
   public void saveFile(String nomfile){
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true))){
            pw.println(this.lugar + "," + this.descripcion );
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        }
    }
    public static void saveFile(ArrayList<Premio> premios, String nomfile){
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile)))){
            for(Premio m : premios)
                pw.println(m.getLugar()+ "," + m.getDescripcion());
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        }
    }
}

