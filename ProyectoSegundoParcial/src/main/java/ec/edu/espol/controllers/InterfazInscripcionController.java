/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import ec.edu.espol.model.Concurso;
import ec.edu.espol.model.Inscripcion;
import ec.edu.espol.model.Mascota;
import ec.edu.espol.proyectosegundoparcial.App;
import ec.edu.espol.util.Util;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
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
public class InterfazInscripcionController implements Initializable {

    @FXML
    private TextField txtValor;
    @FXML
    private Button btnEnviar;
    @FXML
    private Button btnRegresar;
    private int id,idMascota,idConcurso,dia,mes,ano;
    private double valor;
    private LocalDate fechaInscripcion;
    private ArrayList<Mascota> mascotas;
    private ArrayList<Concurso> concursos;
    @FXML
    private Label lblFecha;
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
    private Label lblValor;
    @FXML
    private Button btnVerificar;
    @FXML
    private Label lblMascota;
    @FXML
    private TextField txtMascota;
    @FXML
    private Label lblConcurso;
    @FXML
    private TextField txtConcurso;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mascotas = Mascota.readFileMascota("mascotas.txt");
        concursos = Concurso.readFileConcurso("concursos.txt");
        btnEnviar.setVisible(false);
        lblValor.setVisible(false);
        lblAno.setVisible(false);
        lblDia.setVisible(false);
        lblMes.setVisible(false);
        lblFecha.setVisible(false);
        txtDia.setVisible(false);
        txtAno.setVisible(false);
        txtMes.setVisible(false);
        txtValor.setVisible(false);
    }    

    @FXML
    private void Enviar(ActionEvent event) {
        id = Util.nextID("mascotas.txt");
        fechaInscripcion = LocalDate.of(ano, mes, dia);
        valor = Integer.parseInt(txtValor.getText());
        Inscripcion i = new Inscripcion(id,idMascota,idConcurso,valor,fechaInscripcion);
    }

    @FXML
    private void regresarMenu(ActionEvent event) throws IOException {
        App.setRoot("Interfaz");
    }

    @FXML
    private void Verificar(ActionEvent event) {
        Mascota m = Mascota.searchByNombre(mascotas, txtMascota.getText());
        Concurso c = Concurso.searchByNombre(concursos, txtConcurso.getText());
        if((m == null) &(c == null))
        {
            txtMascota.clear();
            txtConcurso.clear();
        }
        else
        {
            btnEnviar.setVisible(true);
            lblValor.setVisible(true);
            lblAno.setVisible(true);
            lblDia.setVisible(true);
            lblMes.setVisible(true);
            txtValor.setVisible(true);
            txtAno.setVisible(true);
            txtDia.setVisible(true);
            txtMes.setVisible(true);
            txtMascota.setVisible(false);
            lblMascota.setVisible(false);
            txtConcurso.setVisible(false);
            lblConcurso.setVisible(false);
            btnVerificar.setVisible(false);
        }
    }
    
}
