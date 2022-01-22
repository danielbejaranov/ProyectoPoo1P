module ec.edu.espol.proyectosegundoparcial {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ec.edu.espol.proyectosegundoparcial to javafx.fxml;
    exports ec.edu.espol.proyectosegundoparcial;
    opens ec.edu.espol.util to javafx.fxml;
    exports ec.edu.espol.util;
    opens ec.edu.espol.controllers to javafx.fxml;
    exports ec.edu.espol.controllers;
    opens ec.edu.espol.model to javafx.fxml;
    exports ec.edu.espol.model;
    
}
