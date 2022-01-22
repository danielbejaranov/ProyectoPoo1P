/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import ec.edu.espol.model.Concurso;
import ec.edu.espol.model.Premio;
import ec.edu.espol.proyectosegundoparcial.App;
import ec.edu.espol.util.Util;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author sebastian
 */
public class InterfazPremioController implements Initializable {

    @FXML
    private TextField txtLugar;
    @FXML
    private Button btnEnviar;
    @FXML
    private Button btnRegresar;
    @FXML
    private TextArea txtDescripcion;
    private String descripcion;
    private int lugar,id,idConcurso;
    private ArrayList<Premio> premios;
    private ArrayList<Concurso> concursos;
    @FXML
    private Label lblLugar;
    @FXML
    private Label lblDescripcion;
    @FXML
    private Label lblConcurso;
    @FXML
    private TextField txtConcurso;
    @FXML
    private Button btnVerificar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnEnviar.setVisible(false);
        lblLugar.setVisible(false);
        txtLugar.setVisible(false);
        lblDescripcion.setVisible(false);
        txtDescripcion.setVisible(false);
        concursos = Concurso.readFileConcurso("concursos.txt");
    }    

    @FXML
    private void Enviar(ActionEvent event) {
        id = Util.nextID("premios.txt");
        lugar = Integer.parseInt(txtLugar.getText());
        descripcion = txtDescripcion.getText();
        
        Premio p1 = new Premio(id,lugar,descripcion,idConcurso);
        p1.saveFile("premiox.txt");
        //d1.agregarDueno(p1, premios);
        txtLugar.clear();
        txtDescripcion.clear();
        
    }

    @FXML
    private void regresarMenu(ActionEvent event) throws IOException {
        App.setRoot("Interfaz");
    }

    @FXML
    private void Verificar(ActionEvent event) {
        Concurso c = Concurso.searchByNombre(concursos, txtConcurso.getText());
        if(c == null)
        {
            txtConcurso.clear();    
        }
        else
        {
            btnEnviar.setVisible(true);
            lblLugar.setVisible(true);
            txtLugar.setVisible(true);
            lblDescripcion.setVisible(true);
            txtDescripcion.setVisible(true);
            lblConcurso.setVisible(false);
            txtConcurso.setVisible(false);
            btnVerificar.setVisible(false);
        }
        
    }
    
}
