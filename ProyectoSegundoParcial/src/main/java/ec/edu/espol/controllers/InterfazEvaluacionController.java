/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import ec.edu.espol.model.Evaluacion;
import ec.edu.espol.proyectosegundoparcial.App;
import ec.edu.espol.util.Util;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
    @FXML
    private ComboBox<?> cbJurado;
    @FXML
    private ComboBox<?> cbDueno;
    @FXML
    private ComboBox<?> cbMascota;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
//INTEGRAR LAS LISTAS, TODOS LOS MÉTODOS SE ENCUENTRAN EN LA CLASE EVALUACION
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
