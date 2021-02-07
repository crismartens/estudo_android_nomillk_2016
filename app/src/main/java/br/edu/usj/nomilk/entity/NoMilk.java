package br.edu.usj.nomilk.entity;

import java.util.ArrayList;
import java.util.List;

public class NoMilk {

    public NoMilk(){}

    public boolean verify (Usuario user){
        return true;
    }

    public void logar (Usuario user){}


    public List<Região> listaRegião() {

        List<Região> região = new ArrayList<Região>();
        região.add(new Região ("Grande Florianópolis"));
        região.add(new Região ("Região 2"));
        região.add(new Região ("Região 3"));
        região.add(new Região ("Região 4"));
        região.add(new Região ("Região 5"));

        return região;
    }

    public List<Estabelecimento> getEstabelecimentos(Região região) {
        List<Estabelecimento> estabelecimento = new ArrayList<Estabelecimento>();

        if (região.getRegiao().equals("Grande Florianópolis")){
            estabelecimento.add(new Estabelecimento(("Estabelecimento 01")));
            estabelecimento.add(new Estabelecimento(("Estabelecimento 02")));
            estabelecimento.add(new Estabelecimento(("Estabelecimento 03")));
        }

        if (região.getRegiao().equals("Região 2")){
            estabelecimento.add(new Estabelecimento(("Estabelecimento 04")));
            estabelecimento.add(new Estabelecimento(("Estabelecimento 05")));
            estabelecimento.add(new Estabelecimento(("Estabelecimento 06")));
        }

        if (região.getRegiao().equals("Região 3")){
            estabelecimento.add(new Estabelecimento(("Estabelecimento 07")));
            estabelecimento.add(new Estabelecimento(("Estabelecimento 08")));
            estabelecimento.add(new Estabelecimento(("Estabelecimento 09")));
        }

        if (região.getRegiao().equals("Região 4")){
            estabelecimento.add(new Estabelecimento(("Estabelecimento 10")));
            estabelecimento.add(new Estabelecimento(("Estabelecimento 11")));
            estabelecimento.add(new Estabelecimento(("Estabelecimento 12")));
        }

        if (região.getRegiao().equals("Região 5")){
            estabelecimento.add(new Estabelecimento(("Estabelecimento 13")));
            estabelecimento.add(new Estabelecimento(("Estabelecimento 14")));
            estabelecimento.add(new Estabelecimento(("Estabelecimento 15")));
        }

        return estabelecimento;

    }

    
}
