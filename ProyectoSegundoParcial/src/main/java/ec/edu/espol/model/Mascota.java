/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

public class Mascota extends Application {

    private int id, idDueño;
    private String nombre, raza, tipo;
    private LocalDate fechaNacimiento;
    private ArrayList<Inscripcion> inscripciones;

    public Mascota(int id, int idDueño, String nombre, String raza, String tipo, LocalDate fechaNacimiento) {
        this.id = id;
        this.idDueño = idDueño;
        this.nombre = nombre;
        this.raza = raza;
        this.tipo = tipo;
        this.fechaNacimiento = fechaNacimiento;
        this.inscripciones = new ArrayList();
    }

    @Override
    public String toString() {
        return "Mascota{" + "nombre=" + nombre + ", raza=" + raza + ", tipo=" + tipo + ", fechaNacimiento=" + fechaNacimiento + '}';
    }

    public Mascota() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDueño() {
        return idDueño;
    }

    public void setIdDueño(int idDueño) {
        this.idDueño = idDueño;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public ArrayList<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(ArrayList<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public void saveFile(String nomfile) {
        StringBuilder sb = new StringBuilder();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomfile, true))) {

            sb.append(this.id).append("|");
            sb.append(this.idDueño).append("|");
            sb.append(this.nombre).append("|");
            sb.append(this.raza).append("|");
            sb.append(this.tipo).append("|");
            sb.append(this.fechaNacimiento);

            bw.write(sb.toString());
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public static void saveFile(ArrayList<Mascota> mascotas, String nomfile) {
        StringBuilder sb = new StringBuilder();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomfile))) {
            for (Mascota m : mascotas) {
                sb.append(m.id).append("|");
                sb.append(m.idDueño).append("|");
                sb.append(m.nombre).append("|");
                sb.append(m.raza).append("|");
                sb.append(m.tipo).append("|");
                sb.append(m.fechaNacimiento);
            }
            bw.write(sb.toString());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static ArrayList<Mascota> readFileMascota(String nomfile) {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        try (BufferedReader bw = new BufferedReader(new FileReader(nomfile))) {
            String linea;
            while ((linea = bw.readLine()) != null) {
                String[] tokens = linea.split("\\|");
                Mascota m = new Mascota(
                        Integer.parseInt(tokens[0]),
                        Integer.parseInt(tokens[1]),
                        tokens[2],
                        tokens[3],
                        tokens[5],
                        LocalDate.parse(tokens[4]));
                mascotas.add(m);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return mascotas;
    }

    public static Mascota searchByNombre(ArrayList<Mascota> mascotas, String nombre) {
        for (Mascota m : mascotas) {
            if (m.nombre.equals(nombre)) {
                return m;
            }
        }
        return null;
    }

    public static int getIdMascotaSearchedByNombre(String nombre) {
        ArrayList<Mascota> mascotas = readFileMascota("mascotas.txt");
        Mascota mascota = searchByNombre(mascotas, nombre);
        return mascota.id;
    }

    public static Mascota getDueñoSearchedByNombre(String nombre) {
        ArrayList<Mascota> mascotas = readFileMascota("mascotas.txt");
        Mascota mascota = searchByNombre(mascotas, nombre);
        return mascota;
    }

    public static ArrayList<String> getNombres(ArrayList<Mascota> mascotas) {
        ArrayList<String> nombresMascotas = new ArrayList<String>();
        for (Mascota m : mascotas) {
            if (!nombresMascotas.contains(m.nombre)) 
                nombresMascotas.add(m.nombre);
        }
        return nombresMascotas;
    }

    @Override
    public void start(Stage stage) throws Exception {

    }

    public static void main(String[] args) {
        launch(args);
    }

}
