package br.edu.usj.nomilk.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import br.edu.usj.nomilk.R;
import br.edu.usj.nomilk.adapter.AdapterEstabelecimento;

import br.edu.usj.nomilk.dao.LocalDAO;
import br.edu.usj.nomilk.entity.Estabelecimento;
import br.edu.usj.nomilk.entity.MeuLocal;
import br.edu.usj.nomilk.util.Constantes;


public class EstabelecimentoActivity extends Activity{

    private ListView listView;
    private AdapterEstabelecimento adapterEstabelecimento;
    private ArrayList<Estabelecimento> itens;
    private LocalDAO localDAO;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_estabelecimento);

        listView = (ListView) findViewById(R.id.estabelecimentos);
        localDAO = new LocalDAO(this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView ad, View view, final int position, long id) {
                    AlertDialog.Builder alerta = new AlertDialog.Builder(EstabelecimentoActivity.this);
                    alerta.setMessage(R.string.add);
                    alerta.setCancelable(true);

                    alerta.setPositiveButton(R.string.curti, new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface arg0, int arg1) {

                            MeuLocal local =  new MeuLocal();
                            local.setEstabelecimento(adapterEstabelecimento.getItem(position).toString());
                            local.setStatus("CURTI");
                            local.setRegiao(Constantes.região.toString());

                            localDAO.salvar(local);

                            Toast t = Toast.makeText(EstabelecimentoActivity.this, R.string.localadd,Toast.LENGTH_SHORT);
                            t.show();
                        }
                    });

                    alerta.setNegativeButton(R.string.naocurti, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {

                            MeuLocal local =  new MeuLocal();
                            local.setEstabelecimento(adapterEstabelecimento.getItem(position).toString());
                            local.setStatus("NÃO CURTI");
                            local.setRegiao(Constantes.região.toString());

                            localDAO.salvar(local);

                            Toast t = Toast.makeText(EstabelecimentoActivity.this, R.string.localadd,Toast.LENGTH_SHORT);
                            t.show();
                        }
                    });
                    //cria o AlertDialog
                    alerta.create();
                    //Exibe
                    alerta.show();


                }
            });

        createListView();
    }

    private void createListView() {
        itens = new ArrayList<Estabelecimento>();
        itens = (ArrayList<Estabelecimento>) Constantes.NM.getEstabelecimentos(Constantes.região);

        adapterEstabelecimento = new AdapterEstabelecimento(this, itens);

        listView.setAdapter(adapterEstabelecimento);
    }

    public void voltarOnClick(View view) {
        Intent intent = new Intent(this,AcoesActivity.class);
        startActivity(intent);
    }
}
