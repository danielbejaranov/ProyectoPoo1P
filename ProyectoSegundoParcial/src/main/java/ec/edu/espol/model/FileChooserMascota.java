/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.io.File;
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
import javafx.stage.Stage;

/**
 *
 * @author nick1
 */
public class FileChooserMascota extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
         // set title for the stage
        stage.getIcons().add(new Image("ec/edu/espol/icons/icono.jpg"));
        stage.setTitle("Seleccionar");
 
        // create a File chooser
        FileChooser fil_chooser = new FileChooser();
 
        // create a Label
        Label label = new Label("no files selected");
 
        // create a Button
        Button button = new Button("Seleccionar imagen");
 
        // create an Event Handler
        EventHandler<ActionEvent> event =
        new EventHandler<ActionEvent>() {
 
            public void handle(ActionEvent e)
            {
                // get the file selected
                File file = fil_chooser.showOpenDialog(stage);
 
                if (file != null) {
                     
                    label.setText(file.getAbsolutePath()
                                        + "  selected");
                }
            }
        };
        button.setOnAction(event);
 
        // create a Button
        Button button1 = new Button("Guardar imagen");
 
        // create an Event Handler
        EventHandler<ActionEvent> event1 =
         new EventHandler<ActionEvent>() {
 
            public void handle(ActionEvent e)
            {
 
                // get the file selected
                File file = fil_chooser.showSaveDialog(stage);
 
                if (file != null) {
                    label.setText(file.getAbsolutePath()
                                        + "  selected");
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
}
