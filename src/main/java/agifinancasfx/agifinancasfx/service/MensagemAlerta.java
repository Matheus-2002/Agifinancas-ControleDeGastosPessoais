package agifinancasfx.agifinancasfx.service;

import javafx.scene.control.Alert;

public class MensagemAlerta {
    public static void mostrarAlerta(String titulo, String mensagem, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();  // Exibe o alerta
    }
}
