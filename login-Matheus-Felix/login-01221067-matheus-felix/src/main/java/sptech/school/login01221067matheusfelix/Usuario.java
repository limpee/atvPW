package sptech.school.login01221067matheusfelix;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Usuario {
    private String usuario;
    private String senha;
    private String nome;
    private boolean autenticacao = false;

    public Usuario(String usuario, String senha, String nome) {
        this.usuario = usuario;
        this.senha = senha;
        this.nome = nome;
    }

    public boolean verificacaoSenha(String senhaVerificacao) {
        if (senhaVerificacao.equals(senha)) {
            return true;
        } else {
            return false;
        }

    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAutenticacao() {
        return autenticacao;
    }

    public void setAutenticacao(boolean autenticacao) {
        this.autenticacao = autenticacao;
    }
}
