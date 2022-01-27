/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.controllers.InterfazMascotaController;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 *
 * @author nick1
 */
public class FileChooserMascota extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // set title for the stage
        stage.getIcons().add(new Image("icons/icono.jpg"));
        stage.setTitle("Seleccionar");

        // create a File chooser
        FileChooser fil_chooser = new FileChooser();

        // create a Label
        Label label = new Label("no files selected");

        // create a Button
        Button button = new Button("Seleccionar imagen");
        fil_chooser.setInitialDirectory(new File(System.getProperty("user.home") + "\\Pictures"));
        // create an Event Handler
        EventHandler<ActionEvent> event
                = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {

                //filtro de extensiones
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("IMG files (*.jpg)", "*.jpg");
                FileChooser.ExtensionFilter extFilter2 = new FileChooser.ExtensionFilter("IMG files (*.png)", "*.png");
                fil_chooser.getExtensionFilters().add(extFilter);
                fil_chooser.getExtensionFilters().add(extFilter2);

                // get the file selected
                File file = fil_chooser.showOpenDialog(stage);

                if (file != null) {

                    label.setText(file.getAbsolutePath()
                            + "  ruta seleccionada");

                }
            }
        };
        button.setOnAction(event);

        // create a Button
        Button button1 = new Button("Guardar imagen");

        // create an Event Handler
        EventHandler<ActionEvent> event1
                = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {

                // get the file selected          
                File file = fil_chooser.showSaveDialog(stage);

                if (file != null) {
                    label.setText(file.getAbsolutePath()
                            + "  ruta de guardado");
                    String name = file.getName();
                    String extension = name.substring(1 + name.lastIndexOf(".")).toLowerCase();
                    ImageIO.write(img, extension, f1);
                }
            }
        };

        button1.setOnAction(event1);

        // create a VBox
        VBox vbox = new VBox(30, label, button, button1);

        // set Alignment
        vbox.setAlignment(Pos.CENTER);

        // create a scene
        Scene scene = new Scene(vbox, 800, 500);

        // set the scene
        stage.setScene(scene);

        stage.show();
    }

    private void saveTextToFile(String content, File file) {
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(content);
            writer.close();
        } catch (IOException ex) {

        }
    }
}
