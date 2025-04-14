package agifinancasfx.agifinancasfx.control;

import agifinancasfx.agifinancasfx.Model.Usuario;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class GeradorCenas {
    public static Stage primaryStage;
    public static Usuario usuarioAutenticado;


    public static void loadScene(Stage stage , String fxml) throws IOException {
        FXMLLoader fxmlLoginLoader = new FXMLLoader(GeradorCenas.class.getResource("/view/" + fxml + ".fxml"));
        Parent root = fxmlLoginLoader.load();
        stage.setWidth(325);
        stage.setHeight(670);
        stage.setResizable(false);
        stage.centerOnScreen();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}