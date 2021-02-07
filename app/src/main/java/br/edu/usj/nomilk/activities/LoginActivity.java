package br.edu.usj.nomilk.activities;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.usj.nomilk.R;
import br.edu.usj.nomilk.entity.Usuario;
import br.edu.usj.nomilk.util.Constantes;

public class LoginActivity extends Activity {

    private EditText usuario;
    private EditText senha;
    private CheckBox somHabilitado;

    private MediaPlayer mp;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        usuario = (EditText) findViewById(R.id.usuario);
        senha = (EditText) findViewById(R.id.senha);

        somHabilitado = (CheckBox) findViewById(R.id.somHabilitado);

        mp = MediaPlayer.create(LoginActivity.this, R.raw.vaca);

    }

    public void entrarOnClick(View view) {

        Usuario user = new Usuario();

        user.setUser(usuario.getText().toString());
        user.setSenha(senha.getText().toString());

        Constantes.user.setUsuario(user);

        if (Constantes.NM.verify(Constantes.user)){

            if(somHabilitado.isChecked()) {
                mp.start();
            }

            Constantes.NM.logar(user);

            Intent intent = new Intent(this,AcoesActivity.class);
            startActivity(intent);

        }
        else{
            Toast t = Toast.makeText(this, R.string.userInvalido,
                    Toast.LENGTH_SHORT);
            t.show();
        }

    }

    public void onBackPressed() {
    }
}
