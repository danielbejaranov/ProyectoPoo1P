/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import ec.edu.espol.proyectosegundoparcial.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sebastian
 */
public class InterfazController implements Initializable {

    @FXML
    private Button btnMascota;
    @FXML
    private Button btnPremio;
    @FXML
    private Button btnMiembroJurado;
    @FXML
    private Button btnCriterio;
    @FXML
    private Button btnEvaluacion;
    @FXML
    private Button btnConcurso;
    @FXML
    private Button btnInscripcion;
    @FXML
    private Button btnSalir;
    @FXML
    private Button btnDueño;
    private Parent root;
    private Scene scene;
    private Stage stage;
    @FXML
    private AnchorPane scenePane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    
    
    @FXML
    private void menuDueño(ActionEvent event) throws IOException{
        App.setRoot("InterfazDueño");
    }
        
    @FXML
    private void menuMascota(ActionEvent event) throws IOException {
        App.setRoot("InterfazMascota");
    }

    @FXML
    private void menuPremio(ActionEvent event) throws IOException {
        App.setRoot("InterfazPremio");
    }

    @FXML
    private void menuMiembroJurado(ActionEvent event) throws IOException {
        App.setRoot("InterfazMiembroJurado");
    }

    @FXML
    private void menuCriterio(ActionEvent event) throws IOException {
        App.setRoot("InterfazCriterio");
    }

    @FXML
    private void menuEvaluacion(ActionEvent event) throws IOException {
        App.setRoot("InterfazEvaluacion");
    }

    @FXML
    private void menuConcurso(ActionEvent event) throws IOException {
        App.setRoot("InterfazConcurso");
    }

    @FXML
    private void menuInscripcion(ActionEvent event) throws IOException {
        App.setRoot("InterfazInscripcion");
    }

    @FXML
    private void SalirDelPrograma(ActionEvent event) {
        Alert a = new Alert(AlertType.CONFIRMATION);
        a.setTitle("Salir");
        a.setHeaderText("Estas a punto de salir del programa!");
        a.setContentText("Quieres guardar antes de salir? ");
        if (a.showAndWait().get() == ButtonType.OK){
            stage = (Stage)scenePane.getScene().getWindow();
            stage.close();
        }
    }

    
    
}
