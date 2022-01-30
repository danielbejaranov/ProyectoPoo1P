/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import ec.edu.espol.model.Concurso;
import ec.edu.espol.model.Criterio;
import ec.edu.espol.proyectosegundoparcial.App;
import ec.edu.espol.util.Util;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author sebastian
 */
public class InterfazCriterioController implements Initializable {

    @FXML
    private Button btnEnviar;
    @FXML
    private Button btnRegresar;
    @FXML
    private TextArea txtDescripcion;
    @FXML
    private TextArea txtConcurso;
    
    private int id,idConcurso;
    private String descripcion, concurso;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Enviar(ActionEvent event) throws ParseException {
        id = Util.nextID("criterios.txt");
        concurso = txtConcurso.getText();
        idConcurso = Concurso.getConcursoSearchedByNombre(concurso).getId();
        
        descripcion = txtDescripcion.getText();
        Criterio c = new Criterio(descripcion,id,idConcurso);
        c.saveFile("criterios.txt");
        txtDescripcion.clear();   
    }

    @FXML
    private void regresarMenu(ActionEvent event) throws IOException {
        App.setRoot("Interfaz");
    }
    
}
