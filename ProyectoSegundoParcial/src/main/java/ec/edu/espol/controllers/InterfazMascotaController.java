/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import ec.edu.espol.model.Dueno;
import ec.edu.espol.model.FileChooserMascota;
import ec.edu.espol.model.Mascota;
import ec.edu.espol.proyectosegundoparcial.App;
import ec.edu.espol.util.Util;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sebastian
 */
public class InterfazMascotaController implements Initializable {

    @FXML
    private Button imgMascota;
    @FXML
    private TextField txtNombres;
    @FXML
    private Button btnEnviar;
    @FXML
    private Button btnRegresar;
    @FXML
    private TextField txtRaza;
    @FXML
    private TextField txtTipo;
    private TextField txtFecha;
    
    private String nombre,raza,tipo;
    private LocalDate fechaNacimiento;
    private int id, idDueno,ano,mes,dia;
    private ArrayList<Dueno> duenos;
    @FXML
    private Label lblNombre;
    @FXML
    private Label lblRaza;
    @FXML
    private Label lblTipo;
    @FXML
    private Label lblFecha;
    @FXML
    private TextField txtDia;
    @FXML
    private Label lblDueno;
    @FXML
    private TextField txtCorreo;
    @FXML
    private Label lblDia;
    @FXML
    private Label lblMes;
    @FXML
    private TextField txtMes;
    @FXML
    private TextField txtAno;
    @FXML
    private Label lblAno;
    @FXML
    private Button btnVerificar;
    @FXML
    private Label lbl1;
    @FXML
    private Label lbl2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lbl1.setVisible(false);
        lbl2.setVisible(false);
        txtNombres.setVisible(false);
        txtRaza.setVisible(false);
        txtTipo.setVisible(false);
        txtDia.setVisible(false);
        txtMes.setVisible(false);
        txtAno.setVisible(false);
        btnEnviar.setVisible(false);
        lblNombre.setVisible(false);
        lblRaza.setVisible(false);
        lblTipo.setVisible(false);
        lblDia.setVisible(false);
        lblMes.setVisible(false);
        lblAno.setVisible(false);
        lblFecha.setVisible(false);
        imgMascota.setVisible(false);
        duenos = Dueno.readFileDueño("duenos.txt");
        
    }    

    @FXML
    private void Enviar(ActionEvent event) {
        
        id = Util.nextID("mascotas.txt");
        nombre = txtNombres.getText();
        raza = txtRaza.getText();
        tipo = txtTipo.getText();
        dia = Integer.parseInt(txtDia.getText());
        mes = Integer.parseInt(txtMes.getText());
        ano = Integer.parseInt(txtAno.getText());
        fechaNacimiento = LocalDate.of(ano, mes, dia); //Al crear una mascota lanza un error, estoy seguro que es por LocalDate, corrigelo xd
        Mascota m1 = new Mascota(id,idDueno,nombre,raza,tipo,fechaNacimiento);
        m1.saveFile("mascotas.txt");
        
        //d1.agregarDueno(d1, duenos);
        
        txtNombres.clear();
        txtRaza.clear();
        txtTipo.clear();
        txtFecha.clear();
        txtDia.clear();
        txtMes.clear();
        txtAno.clear();
        lbl1.setVisible(true);
        lbl2.setVisible(true);
    }

    @FXML
    private void regresarMenu(ActionEvent event) throws IOException {
        App.setRoot("Interfaz");
    }

    @FXML
    private void Verificar(ActionEvent event) {
        Dueno d = Dueno.searchByCorreo(duenos, txtCorreo.getText());
        if(d == null)
        {
            txtCorreo.clear();    
        }
        else
        {
            lblDueno.setVisible(false);
            txtCorreo.setVisible(false);
            txtNombres.setVisible(true);
            txtRaza.setVisible(true);
            txtTipo.setVisible(true);
            txtDia.setVisible(true);
            txtMes.setVisible(true);
            txtAno.setVisible(true);
            lblNombre.setVisible(true);
            lblRaza.setVisible(true);
            lblTipo.setVisible(true);
            lblDia.setVisible(true);
            lblMes.setVisible(true);
            lblAno.setVisible(true);
            lblFecha.setVisible(true);
            btnVerificar.setVisible(false);
            btnEnviar.setVisible(true);
            idDueno = d.getId();
            imgMascota.setVisible(true);
            imgMascota.setOnAction(e -> 
            {
                FileChooserMascota fc = new FileChooserMascota();
                Stage s1 =  new Stage();
                try {
                    fc.start(s1);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                
            });
        }
    }  
}
