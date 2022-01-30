/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import ec.edu.espol.model.Dueno;

import ec.edu.espol.model.Mascota;
import ec.edu.espol.proyectosegundoparcial.App;
import ec.edu.espol.util.Util;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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

    private String nombre, raza, tipo;
    private LocalDate fechaNacimiento;
    private int idImagen, idDueno, ano, mes, dia;

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

        int id = Util.nextID("mascotas.txt");
        idImagen = id;
        String nombre = txtNombres.getText();
        String raza = txtRaza.getText();
        String tipo = txtTipo.getText();
        dia = Integer.valueOf(txtDia.getText());
        mes = Integer.valueOf(txtMes.getText());
        ano = Integer.valueOf(txtAno.getText());
        fechaNacimiento = LocalDate.of(ano, mes, dia);
        Mascota m1 = new Mascota(id, idDueno, nombre, raza, tipo, fechaNacimiento);
        m1.saveFile("mascotas.txt");

        txtNombres.clear();
        txtRaza.clear();
        txtTipo.clear();
        txtDia.clear();
        txtMes.clear();
        txtAno.clear();
        lbl1.setVisible(true);
        lbl2.setVisible(true);
        imgMascota.setVisible(true);
    }

    public InterfazMascotaController() {
    }

    public String getNombre() {
        return nombre;
    }

    public static String getExtension(String filename) {
        String extension = "";

        int i = filename.lastIndexOf('.');
        if (i
                > 0) {
            extension = filename.substring(i + 1);
        }
        return extension;
    }

    @FXML
    private void regresarMenu(ActionEvent event) throws IOException {
        App.setRoot("Interfaz");
    }

    @FXML
    private void Verificar(ActionEvent event) {
        Dueno d = Dueno.searchByCorreo(duenos, txtCorreo.getText());
        if (d == null) {
            txtCorreo.clear();
        } else {
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
            this.idDueno = d.getId();

            imgMascota.setOnAction(e
                    -> {

                Mascota mascota = new Mascota();
                FileChooser fil_chooser = new FileChooser();
                fil_chooser.setInitialDirectory(new File(System.getProperty("user.home") + "\\Pictures"));
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("IMG files (*.jpg)", "*.jpg");
                FileChooser.ExtensionFilter extFilter2 = new FileChooser.ExtensionFilter("IMG files (*.png)", "*.png");
                fil_chooser.getExtensionFilters().add(extFilter);
                fil_chooser.getExtensionFilters().add(extFilter2);
                File file = fil_chooser.showOpenDialog(null);
                
                String extension = InterfazMascotaController.getExtension(file.getName());
                
                Path a = Paths.get("src/main/resources/img/" + this.idImagen+"."+extension);

                Path de = Paths.get(file.toURI());

                CopyOption[] options = new CopyOption[]{
                    StandardCopyOption.REPLACE_EXISTING,
                    StandardCopyOption.COPY_ATTRIBUTES
                };

                try {

                    Files.copy(de, a, options);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                Stage s1 = new Stage();
                try {
                    mascota.start(s1);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            });
        }
    }
}
