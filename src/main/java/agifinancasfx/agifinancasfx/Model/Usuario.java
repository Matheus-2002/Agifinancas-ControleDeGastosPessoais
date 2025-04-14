package agifinancasfx.agifinancasfx.Model;

import agifinancasfx.agifinancasfx.service.MensagemAlerta;
import agifinancasfx.agifinancasfx.service.exception.UsuarioInvalidoException;
import javafx.scene.control.Alert;

public class Usuario {
    private int idUsuario;
    private String nome;
    private String senha;
    private String email;

    public Usuario(String name, String email, String senha) throws UsuarioInvalidoException {
        setNome(name);
        setEmail(email);
        setSenha(senha);
    }

    public Usuario(String name, String email, int idUsuario){
        this.nome = name;
        this.email = email;
        this.idUsuario = idUsuario;
    }


    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) throws UsuarioInvalidoException {
        if (nome == null) {
            throw new UsuarioInvalidoException("Nome não pode ser vazio");
        } else {
            this.nome = nome;
        }
    }

    public String getSenha() {
        return senha;
    }

    private void setSenha(String senha) throws UsuarioInvalidoException {

        if (senha.length() >= 6) {
            this.senha = senha;
        } else {
            throw new UsuarioInvalidoException("Senha menor que 6 caracteres");
        }


    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) throws UsuarioInvalidoException {

        String regex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        if (email.matches(regex)) {
            this.email = email;
        } else {
            throw new UsuarioInvalidoException("Email está inválido, deve conter o seguinte padrão abc@seuemail.suaextensao");
        }



    }

}
