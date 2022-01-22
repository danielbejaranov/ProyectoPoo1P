/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import ec.edu.espol.model.Evaluacion;
import ec.edu.espol.model.MiembroJurado;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author sebastian
 */
public class InterfazMiembroJuradoController implements Initializable {

    @FXML
    private TextField txtNombres;
    @FXML
    private Button btnEnviar;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtEmail;
    @FXML
    private Button btnRegresar;
    @FXML
    private TextArea txtPerfil;
    private String nombres;
    private String apellidos;
    private String perfil;
    private String telefono;
    private String email;
    private int id;
    private ArrayList<MiembroJurado> jurados;
    private ArrayList<Evaluacion> evaluaciones;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //evaluaciones = Evaluacion.readFileEvaluacion("evaluaciones.txt");
    }    

    @FXML
    private void Enviar(ActionEvent event) {
        id = Util.nextID("jurados.txt");
        nombres = txtNombres.getText();
        apellidos = txtApellidos.getText();
        telefono = txtTelefono.getText();
        email = txtEmail.getText();
        perfil = txtPerfil.getText();
        MiembroJurado j1 = new MiembroJurado(id,nombres,apellidos,telefono,email,perfil);
        j1.saveFile("jurados.txt");
        //d1.agregarDueno(d1, duenos);
        txtNombres.clear();
        txtApellidos.clear();
        txtTelefono.clear();
        txtEmail.clear();
        txtPerfil.clear();
    }

    @FXML
    private void regresarMenu(ActionEvent event) throws IOException {
        App.setRoot("Interfaz");
    }
    
}
