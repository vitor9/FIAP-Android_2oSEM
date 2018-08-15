package br.com.fiap.exerciciopersistencia;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplasActivity extends AppCompatActivity {

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splas);

        sp = getSharedPreferences("config", MODE_PRIVATE);

        boolean exibir = sp.getBoolean("exibir", true);
        int tempo = sp.getInt("tempo", 10000);
        if (exibir) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    abrirMain();
                }
            }, tempo);
        } else {
            abrirMain();
        }
    }

    void abrirMain() {
        Intent it = new Intent(SplasActivity.this, MainActivity.class);
        startActivity(it);
        finish();
    }
}
