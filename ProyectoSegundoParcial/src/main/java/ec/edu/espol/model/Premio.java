package ec.edu.espol.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Premio {
   private int id, idConcurso, lugar;
   private String descripcion;

    public Premio(int id, int idConcurso, int lugar, String descripcion) {
        this.id = id;
        this.idConcurso = idConcurso;
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
    
    public void saveFile(String nomfile){
        StringBuilder sb = new StringBuilder();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomfile, true))) {
            
            sb.append(this.id).append("|");
            sb.append(this.idConcurso).append("|");
            sb.append(this.lugar).append("|");
            sb.append(this.descripcion).append(System.getProperty("line.separator"));;
            
            bw.write(sb.toString());
        } catch (IOException e) {
            System.out.println(e);
        }        
    }
    public static void saveFile(ArrayList<Premio> premios, String nomfile){
        StringBuilder sb = new StringBuilder();        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomfile))) {            
            for (Premio p : premios) {
                sb.append(p.id).append("|");
                sb.append(p.idConcurso).append("|");
                sb.append(p.lugar).append("|");
                sb.append(p.descripcion).append(System.getProperty("line.separator"));;                
            }
            bw.write(sb.toString());
        } catch (IOException e) {
            System.out.println(e);
        }         
    }
    
}

