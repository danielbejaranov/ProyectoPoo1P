package ec.edu.espol.model;

import static ec.edu.espol.model.Dueno.getDueñoSearchedByMail;
import static ec.edu.espol.model.Dueno.getIdDueñoSearchedByMail;
import ec.edu.espol.util.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Premio {
   private int lugar,id;
   private String descripcion;
   
   public Premio(int id,int lugar,String descripcion){
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
   public static Premio nextPremio (Scanner sc,String nomfile){
       
        int id = Util.nextID(nomfile);
        String correo;
       
        //int idDueño = getIdDueñoSearchedByMail(correo);//agregar la busqueda de id
        
        
        System.out.println("Ingrese el lugar: ");
        int lugar = sc.nextInt();
        System.out.println("Ingrese una descripcion: ");
        String descripcion = sc.next();
        Premio p1 = new Premio(id,lugar,descripcion);
        p1.saveFile(nomfile);
         return p1;
    }
   public void saveFile(String nomfile){
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true))){
            pw.println(this.id+","+this.lugar + "," + this.descripcion );
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        }
    }
    public static void saveFile(ArrayList<Premio> premios, String nomfile){
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile)))){
            for(Premio m : premios)
                pw.println(m.id+","+m.lugar + "," + m.descripcion );
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        }
    }
    
}

