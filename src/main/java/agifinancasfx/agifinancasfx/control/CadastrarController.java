package agifinancasfx.agifinancasfx.control;
import agifinancasfx.agifinancasfx.DAO.UsuarioDAO;
import agifinancasfx.agifinancasfx.Model.Usuario;
import agifinancasfx.agifinancasfx.control.principal.InicioController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.sql.SQLException;

import static agifinancasfx.agifinancasfx.control.GeradorCenas.primaryStage;

public class CadastrarController {
    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnFazerLogin;

    @FXML
    private Label lblNovoUsuario;

    @FXML
    private Label lblPossuiCadastro;

    @FXML
    private TextField txtCPF;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNome;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private PasswordField txtPasswordAgain;

    @FXML
    private TextField txtSobrenome;

    @FXML
    void cadastrarUsuario(ActionEvent event) throws SQLException {
        String nome = txtNome.getText().trim();
        String email = txtEmail.getText().trim().toLowerCase();
        String password = txtPassword.getText();
        String passwordagain = txtPasswordAgain.getText();
        InicioController.cadastrarUsuario(nome, email, password, passwordagain);
    }
    // Método para limpar os campos após um cadastro bem-sucedido
    public void limparCampos() {
        txtNome.clear();
        txtEmail.clear();
        txtPassword.clear();
        txtPasswordAgain.clear();
    }

    @FXML
    void fazerLogin(ActionEvent event) {
        try {
            GeradorCenas.loadScene(primaryStage, "Login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

