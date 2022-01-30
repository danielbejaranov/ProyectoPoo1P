/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import ec.edu.espol.model.Concurso;
import ec.edu.espol.proyectosegundoparcial.App;
import ec.edu.espol.util.Util;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author sebastian
 */
public class InterfazConcursoController implements Initializable {

    @FXML
    private TextField txtNombres;
    @FXML
    private Button btnEnviar;
    @FXML
    private Button btnRegresar;
    @FXML
    private TextField txtTematica;
    @FXML
    private TextField txtCosto;
    @FXML
    private TextField txtDia;
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
    private TextField txtDia1;
    @FXML
    private Label lblDia1;
    @FXML
    private Label lblMes1;
    @FXML
    private TextField txtMes1;
    @FXML
    private TextField txtAno1;
    @FXML
    private Label lblAno1;
    @FXML
    private TextField txtDia2;
    @FXML
    private Label lblDia2;
    @FXML
    private Label lblMes2;
    @FXML
    private TextField txtMes2;
    @FXML
    private TextField txtAno2;
    @FXML
    private Label lblAno2;
    private int id,dia,dia1,dia2,mes,mes1,mes2,ano,ano1,ano2;
    private String nombre,tematica;
    private double costo;
    private LocalDate fechaCierre,fechaInicio, fechaConcurso;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Enviar(ActionEvent event) {
        id = Util.nextID("concursos.txt");
        nombre = txtNombres.getText();
        tematica = txtTematica.getText();
        //hazte las fechas plz
        dia = Integer.valueOf(txtDia.getText());
        mes = Integer.valueOf(txtMes.getText());
        ano = Integer.valueOf(txtAno.getText());        
        fechaConcurso = LocalDate.of(ano,mes,dia);

        dia1 = Integer.valueOf(txtDia1.getText());
        mes1 = Integer.valueOf(txtMes1.getText());
        ano1 = Integer.valueOf(txtAno1.getText());        
        fechaInicio = LocalDate.of(ano1, mes1, dia1);
        
        dia2 = Integer.valueOf(txtDia2.getText());
        mes2 = Integer.valueOf(txtMes2.getText());
        ano2 = Integer.valueOf(txtAno2.getText());        
        fechaConcurso = LocalDate.of(ano2, mes2, dia2);
        
        costo = Double.parseDouble(txtCosto.getText());
        
        Concurso c = new Concurso(id,nombre,fechaConcurso,fechaInicio,fechaCierre,tematica,costo);
        c.saveFile("concursos.txt");
        txtNombres.clear();
        txtTematica.clear();
        txtCosto.clear();
        txtDia.clear();
        txtMes.clear();
        txtAno.clear();
    }


    @FXML
    private void regresarMenu(ActionEvent event) throws IOException {
        App.setRoot("Interfaz");
    }

    
}
