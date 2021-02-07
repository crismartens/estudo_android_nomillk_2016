package br.edu.usj.nomilk.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import br.edu.usj.nomilk.R;
import br.edu.usj.nomilk.util.Constantes;

public class AcoesActivity extends Activity{

    private TextView região;
    private TextView usuário;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_acoes);

        região = (TextView) findViewById(R.id.regiao);
        usuário = (TextView) findViewById(R.id.nome);

        usuário.setText(Constantes.user.getUser());
        região.setText(Constantes.região.getRegiao());
    }

    public void pesquisarOnClick(View view) {
        Intent intent = new Intent(this,EstabelecimentoActivity.class);
        startActivity(intent);
    }

    public void alterarRegiaoOnClick(View view) {
        Intent intent = new Intent(this,RegiaoActivity.class);
        startActivity(intent);
    }

    public void logoutOnClick(View view) {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    public void locaisOnClick(View view) {
        Intent intent = new Intent(this,MeuLocalActivity.class);
        startActivity(intent);
    }

    public void onBackPressed() {
    }
}
