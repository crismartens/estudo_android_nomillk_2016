package br.edu.usj.nomilk.entity;

public class Usuario {

    private String user;
    private String senha;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setUsuario(Usuario user){
        this.user = user.getUser();
        this.senha = user.getSenha();
    }
}
