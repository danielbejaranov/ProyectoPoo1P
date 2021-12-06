/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.util.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Dueno extends Persona{
    private String direccion;

    public Dueno(int id, String nombres, String apellidos,String direccion, String telefono, String email) {
        super(id, nombres, apellidos, telefono, email);
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public static Dueno nextDueno (Scanner sc, String nomfile){
        System.out.println("Registrar Dueño");

        int id = Util.nextID(nomfile);        
        System.out.println("Ingrese sus nombres: ");
        String nombres = sc.next();
        System.out.println("Ingrese sus apellidos: ");
        String apellidos = sc.next();
        System.out.println("Ingrese su direccion: ");
        String direccion = sc.next();
        System.out.println("Ingrese su telefono: ");
        String telefono = sc.next();
        String email;
        do{
            System.out.println("Ingrese el correo: ");
            email = sc.next();
        }while(!(Dueno.correoInFile(email)));

        Dueno personaDueño = new Dueno(id,nombres,apellidos,direccion,telefono,email);
        personaDueño.saveFile(nomfile);
        return personaDueño;
    }
    
    public void saveFile(String nomfile){
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true))){
            pw.println(this.id + "|" + this.nombres + "|" + this.apellidos + "|" + this.direccion + "|" + this.telefono + "|" + this.email);
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        }
    }
    public static void saveFile(ArrayList<Dueno> dueños, String nomfile){
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile)))){
            for(Dueno d : dueños)
                pw.println(d.id+ "|" + d.nombres+ "|" + d.apellidos + "|" + d.direccion + "|" + d.telefono + "|" + d.email);
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        }
    }
    
    public static ArrayList<Dueno> readFileDueño(String nomfile){
        ArrayList<Dueno> dueños = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomfile))){
            while(sc.hasNextLine())
            {
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                Dueno dueño = new Dueno(Integer.parseInt(tokens[0]), tokens[1], tokens[2], tokens[3], tokens[4], tokens[5]);
                dueños.add(dueño);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return dueños;        
    }
    
    public static Dueno searchByCorreo(ArrayList<Dueno> dueños, String correo){
        for(Dueno d: dueños)
        {
            if(d.email.equals(correo))
                return d; // dar formato
        }
        return null;
    }
    
    public static int getIdDueñoSearchedByMail(String correo){
        ArrayList<Dueno> dueños = readFileDueño("dueños.txt");
        Dueno dueño = searchByCorreo(dueños, correo);
        return dueño.id;
    }
    
    public static Dueno getDueñoSearchedByMail(String correo){
        ArrayList<Dueno> dueños = readFileDueño("dueños.txt");
        Dueno dueño = searchByCorreo(dueños, correo);
        return dueño;
    }
    
    public static Boolean correoInFile(String correo){
        try(Scanner sc = new Scanner(new File("dueños.txt")))
        {
            while(sc.hasNextLine()){                
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                if(tokens[5].equals(correo))
                    return true;
           }   
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }    
}
