package com.example.login01221106GustavoH;

public class Usuario {
    private String usuarioEmail;
    private String senha;
    private String nome;
    private boolean autenticado;

    public Usuario(String usuarioEmail, String senha, String nome, boolean autenticado) {
        this.usuarioEmail = usuarioEmail;
        this.senha = senha;
        this.nome = nome;
        this.autenticado = autenticado;
    }

    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    public void setUsuarioEmail(String usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAutenticado() {
        return autenticado;
    }

    public void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }
}
