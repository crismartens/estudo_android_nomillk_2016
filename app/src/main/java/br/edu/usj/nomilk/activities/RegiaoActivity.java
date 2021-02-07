package br.edu.usj.nomilk.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;


import br.edu.usj.nomilk.R;
import br.edu.usj.nomilk.adapter.AdapterRegiao;
import br.edu.usj.nomilk.entity.Região;
import br.edu.usj.nomilk.util.Constantes;

public class RegiaoActivity extends Activity {

    private ListView listView;
    private AdapterRegiao adapterRegiao;
    private ArrayList<Região> itens;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_regiao);

        listView = (ListView) findViewById(R.id.regioes);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView ad, View view, int position, long id) {
                Constantes.região =  new Região(adapterRegiao.getItem(position).toString());

                startActivity(new Intent(getBaseContext(),AcoesActivity.class));
            }
        });

        createListView();

    }

    private void createListView() {
        itens = new ArrayList<Região>();
        itens = (ArrayList<Região>) Constantes.NM.listaRegião();

        adapterRegiao = new AdapterRegiao(this, itens);

        listView.setAdapter(adapterRegiao);

    }

    public void voltarOnClick(View view) {
        Intent intent = new Intent(this,AcoesActivity.class);
        startActivity(intent);
    }
}
