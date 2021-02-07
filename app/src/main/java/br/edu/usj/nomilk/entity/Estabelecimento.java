package br.edu.usj.nomilk.entity;

public class Estabelecimento {

    private String nome;

    public Estabelecimento (String nome) {
        this.setNome(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString (){
        return nome;
    }
}
