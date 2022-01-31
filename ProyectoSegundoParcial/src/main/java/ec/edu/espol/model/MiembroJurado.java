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


public class MiembroJurado extends Persona{
    private String perfil;
    private ArrayList<Evaluacion> evaluaciones;    
     
    public MiembroJurado(int id, String nombres, String apellidos, String telefono, String email, String perfil) {
        super(id, nombres, apellidos, telefono, email);
        this.perfil = perfil;
        this.evaluaciones = new ArrayList<>();        
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public static MiembroJurado nextMiembroJurado (Scanner sc, String nomfile){

        int id = Util.nextID(nomfile);
        System.out.println("Ingrese sus nombres: ");
        String nombres = sc.next();
        System.out.println("Ingrese sus apellidos: ");
        String apellidos = sc.next();
        System.out.println("Ingrese su telefono: ");
        String telefono = sc.next();
        String email;
        do{
            System.out.println("Ingrese su correo: ");
            email = sc.next();
        }while(!(Dueno.correoInFile(email)));
        System.out.println("Ingrese su perfil: ");
        String perfil = sc.next();
        
        MiembroJurado personaJurado = new MiembroJurado(id,nombres,apellidos,telefono,email,perfil);
        personaJurado.saveFile(nomfile);
        return personaJurado;
    }
    
    public void saveFile(String nomfile){
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true))){
            pw.println(this.id + "|" + this.nombres + "|" + this.apellidos + "|" + this.telefono + "|" + this.email + "|" + this.perfil + "|" + this.evaluaciones);
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        }
    }
    public static void saveFile(ArrayList<MiembroJurado> miembroJurados, String nomfile){
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile)))){
            for(MiembroJurado m : miembroJurados)
                pw.println(m.id + "|" + m.nombres+ "|" + m.apellidos + "|" + m.telefono + "|" + m.email+ "|" + m.perfil + "|" + m.evaluaciones);
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        }
    }
    
    public static ArrayList<MiembroJurado> readFileMiembroJurado(String nomfile){
        ArrayList<MiembroJurado> jurados = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomfile))){
            while(sc.hasNextLine())
            {
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                MiembroJurado jurado = new MiembroJurado(Integer.parseInt(tokens[0]), tokens[1], tokens[2], tokens[3], tokens[4], tokens[5]);
                jurados.add(jurado);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return jurados;        
    }    
    public static MiembroJurado searchByCorreo(ArrayList<MiembroJurado> jurados, String correo){
        for(MiembroJurado j: jurados)
        {
            if(j.email.equals(correo))
                return j;
        }
        return null;
    }
    
    public static int getIdDueñoSearchedByMail(String correo){
        ArrayList<MiembroJurado> jurados = readFileMiembroJurado("miembroJurados.txt");
        MiembroJurado jurado = searchByCorreo(jurados, correo);
        return jurado.id;
    }
    
    public static MiembroJurado getDueñoSearchedByMail(String correo){
        ArrayList<MiembroJurado> jurados = readFileMiembroJurado("miembroJurados.txt");
        MiembroJurado jurado = searchByCorreo(jurados, correo);
        return jurado;
    }
    
    public static Boolean correoInFile(String correo){
        try(Scanner sc = new Scanner(new File("miembroJurados.txt")))
        {
            while(sc.hasNextLine()){                
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                if(tokens[4].equals(correo))
                    return true;
           }   
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public static ArrayList<String> getNombres(ArrayList<MiembroJurado> jurados){
        ArrayList<String> nombresJurados = new ArrayList<String>();
        for(MiembroJurado j : jurados){
            if(!nombresJurados.contains(j.nombres))
                nombresJurados.add(j.nombres);       
        }
        return nombresJurados;
    }    
}
