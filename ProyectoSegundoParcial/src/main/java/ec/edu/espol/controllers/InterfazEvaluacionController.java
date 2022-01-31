/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import ec.edu.espol.model.Concurso;
import ec.edu.espol.model.Dueno;
import ec.edu.espol.model.Evaluacion;
import ec.edu.espol.model.Mascota;
import ec.edu.espol.model.MiembroJurado;
import ec.edu.espol.proyectosegundoparcial.App;
import ec.edu.espol.util.Util;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author sebastian
 */
public class InterfazEvaluacionController implements Initializable {

    @FXML
    private TextField txtNota;
    @FXML
    private Button btnEnviar;
    @FXML
    private Button btnRegresar;
    private int id,idInscripcion,idCriterio,idMiembroJurado;
    private double nota;
    ArrayList<MiembroJurado> jurados;
    ArrayList<Dueno> duenos;
    ArrayList<Mascota> mascotas;
    ArrayList<Concurso> concursos;
    
    @FXML
    private ComboBox<String> cbJurado;
    @FXML
    private ComboBox<String> cbDueno;
    @FXML
    private ComboBox<String> cbMascota;
    @FXML
    private ComboBox<String> cbConcurso;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.jurados = MiembroJurado.readFileMiembroJurado("jurados.txt");
        ArrayList<String> nombresJurados = MiembroJurado.getNombres(jurados);       
        cbJurado.setItems(FXCollections.observableArrayList(nombresJurados));
        
        this.duenos = Dueno.readFileDueño("duenos.txt");
        ArrayList<String> nombresDuenos = Dueno.getNombres(duenos);
        cbDueno.setItems(FXCollections.observableArrayList(nombresDuenos));
        
        this.mascotas = Mascota.readFileMascota("mascotas.txt"); //lista de mascotas 
        ArrayList<String> nombresMascotas = Mascota.getNombres(mascotas);
        System.out.println(nombresMascotas);
        cbMascota.setItems(FXCollections.observableArrayList(nombresMascotas));
        
        this.concursos= Concurso.readFileConcurso("concursos.txt");
        ArrayList<String> nombresConcursos = Concurso.getNombres(concursos);
        cbConcurso.setItems(FXCollections.observableArrayList(nombresConcursos));        
        
    }    

    @FXML
    private void Enviar(ActionEvent event) {//CORREGIR
        id = Util.nextID("evaluaciones.txt");
        nota = Double.parseDouble(txtNota.getText());
        Evaluacion ev = new Evaluacion(id,idInscripcion,idCriterio,idMiembroJurado,nota);
        ev.saveFile("evaluaciones.txt");
        txtNota.clear();
    }

    @FXML
    private void regresarMenu(ActionEvent event) throws IOException {
        App.setRoot("Interfaz");
    }
    
}
