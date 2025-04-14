package agifinancasfx.agifinancasfx.control.principal;

import agifinancasfx.agifinancasfx.DAO.UsuarioDAO;
import agifinancasfx.agifinancasfx.Model.Usuario;
import agifinancasfx.agifinancasfx.control.CadastrarController;
import agifinancasfx.agifinancasfx.control.GeradorCenas;
import agifinancasfx.agifinancasfx.control.Senha;
import agifinancasfx.agifinancasfx.service.MensagemAlerta;
import agifinancasfx.agifinancasfx.service.exception.UsuarioInvalidoException;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.sql.SQLException;

import static agifinancasfx.agifinancasfx.control.GeradorCenas.primaryStage;

public class InicioController {
    private static UsuarioDAO userDAO;
    public static Usuario fazerLogin(String email, String senha){
        try {
            userDAO = new UsuarioDAO();
            Usuario user = userDAO.verificarUsuario(email, senha);
            return user;
        }catch (SQLException e){
            System.out.println("Erro: "+e.getMessage());
        }
        return null;
    }

    public static void cadastrarUsuario(String nome, String email, String senha, String senhaConfirmacao){
        if (!senha.equals(senhaConfirmacao)) {
            return;
        }
        String senhaHash = Senha.hashSenha(senha);
        try {
            Usuario user = new Usuario(nome, email, senhaHash);
            userDAO = new UsuarioDAO();
            userDAO.criarUsuario(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (UsuarioInvalidoException e) {
            MensagemAlerta.mostrarAlerta("Informações invalidas", e.getMessage(), Alert.AlertType.ERROR);
        }

    }
}
