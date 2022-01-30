/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import ec.edu.espol.model.Dueno;
import ec.edu.espol.proyectosegundoparcial.App;
import ec.edu.espol.util.Util;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sebastian
 */
public class InterfazDueñoController implements Initializable {

    @FXML
    private TextField txtNombres;
    @FXML
    private Button btnEnviar;
    private Parent root;
    private Scene scene;
    private Stage stage;
    private int id;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String email;
    private ArrayList<Dueno> duenos = new ArrayList<>();
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtEmail;
    @FXML
    private Button btnRegresar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    private void Enviar(ActionEvent event) {
        
        id = Util.nextID("duenos.txt"); 
        nombres = txtNombres.getText();
        apellidos = txtApellidos.getText();
        direccion = txtDireccion.getText();
        telefono = txtTelefono.getText();
        email = txtEmail.getText();
        
        Dueno d1 = new Dueno(id,nombres,apellidos,direccion,telefono,email);
        d1.saveFile("duenos.txt");

        txtNombres.clear();
        txtApellidos.clear();
        txtDireccion.clear();
        txtTelefono.clear();
        txtEmail.clear();
                
    }

    @FXML
    private void regresarMenu(ActionEvent event) throws IOException {
        App.setRoot("Interfaz");
    }
    
}
