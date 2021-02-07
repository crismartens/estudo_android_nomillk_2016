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
import br.edu.usj.nomilk.adapter.AdapterLocal;
import br.edu.usj.nomilk.dao.LocalDAO;
import br.edu.usj.nomilk.entity.MeuLocal;


public class MeuLocalActivity extends Activity {

    private ListView listView;
    private AdapterLocal adapterLocal;
    private ArrayList<MeuLocal> itens;
    private LocalDAO localDAO;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_meulocal);

        listView = (ListView) findViewById(R.id.meuslocais);

        localDAO = new LocalDAO(this);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView ad, View view, final int position, long id) {


                AlertDialog.Builder alerta = new AlertDialog.Builder(MeuLocalActivity.this);
                alerta.setMessage(R.string.editarlocal);
                alerta.setCancelable(true);

                alerta.setNeutralButton("EXCLUIR", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {

                        MeuLocal local = adapterLocal.getItem(position);
                        localDAO.remover(String.valueOf(local.getId()));
                        MeuLocalActivity.this.recreate();


                        Toast t = Toast.makeText(MeuLocalActivity.this, R.string.localremove, Toast.LENGTH_SHORT);
                        t.show();

                    }
                });

                alerta.setPositiveButton("CURTI", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        MeuLocal local = adapterLocal.getItem(position);
                        local.setStatus("CURTI");
                        localDAO.update(local);

                        adapterLocal.notifyDataSetChanged();

                    }
                });

                alerta.setNegativeButton("NÃO CURTI", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        MeuLocal local = adapterLocal.getItem(position);
                        local.setStatus("NÃO CURTI");
                        localDAO.update(local);

                        adapterLocal.notifyDataSetChanged();

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
        itens = new ArrayList<MeuLocal>();
        itens = (ArrayList<MeuLocal>) localDAO.listarTodos() ;

        adapterLocal = new AdapterLocal(this, itens);

        listView.setAdapter(adapterLocal);
    }

    public void voltarOnClick(View view) {
        Intent intent = new Intent(this,AcoesActivity.class);
        startActivity(intent);
    }
}
