package ec.edu.espol.proyectosegundoparcial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Interfaz"));
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(event -> {
        event.consume();
        SalirDelPrograma(stage);
        });
    }
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    private void SalirDelPrograma(Stage stage) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Salir");
        a.setHeaderText("Estas a punto de salir del programa!");
        a.setContentText("Quieres guardar antes de salir? ");
        if (a.showAndWait().get() == ButtonType.OK){
            stage.close();
        }
    }
    public static void main(String[] args) {
        launch();
    }

}