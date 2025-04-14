package agifinancasfx.agifinancasfx.control;

import agifinancasfx.agifinancasfx.DAO.UsuarioDAO;
import agifinancasfx.agifinancasfx.Model.Usuario;
import agifinancasfx.agifinancasfx.control.principal.InicioController;
import agifinancasfx.agifinancasfx.service.MensagemAlerta;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.w3c.dom.events.EventException;

import java.io.IOException;
import java.sql.SQLException;

import static agifinancasfx.agifinancasfx.control.GeradorCenas.primaryStage;
import static agifinancasfx.agifinancasfx.control.GeradorCenas.usuarioAutenticado;

public class LoginController {
    @FXML
    private TextField emailText;
    @FXML
    private PasswordField passwordText;
    @FXML
    private Button btnSair;

    @FXML
    public void fazerLogin(ActionEvent actionEvent) throws SQLException {
        Usuario user = InicioController.fazerLogin(emailText.getText().toLowerCase(), passwordText.getText());
        try{
            if (user == null){
                emailText.clear();
                passwordText.clear();
            }
            else{
                usuarioAutenticado = user;
                GeradorCenas.loadScene(primaryStage, "Home");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    private void fazerCadastro(ActionEvent event) {
        try {
            primaryStage.setResizable(false);
            GeradorCenas.loadScene(primaryStage, "CadastroUsuario");
        } catch (IOException e) {
            System.out.println("Erro: "+e.getMessage());;
        }
    }

    @FXML
    private void sairDoApp(ActionEvent event) {
        Platform.exit();
    }
//    public void esqueceuSenha(ActionEvent event) {
//        try{
//            GeradorCenas cenas = new GeradorCenas();
//            cenas.gerarNovoStage("esqueceuSenha.fxml", "Redefinir senha", false, event);
//        } catch (Exception e) {
//            CriarAlertas.CriarAlerta("Erro", "Erro na solicitação", Alert.AlertType.ERROR);
//            e.printStackTrace();
//        }
//    }
}
