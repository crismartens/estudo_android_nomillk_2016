package br.edu.usj.nomilk.entity;

import java.util.ArrayList;
import java.util.List;

public class Região {

    private String regiao;
    private List<MeuLocal> estabelecimentos;

    public Região (String região){
        this.setRegiao(região);
        setEstabelecimentos(new ArrayList<MeuLocal>());
    }


    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public List<MeuLocal> getEstabelecimentos() {
        return estabelecimentos;
    }

    public void setEstabelecimentos(List<MeuLocal> estabelecimentos) {
        this.estabelecimentos = estabelecimentos;
    }

    public String toString(){
        return regiao;
    }
}
