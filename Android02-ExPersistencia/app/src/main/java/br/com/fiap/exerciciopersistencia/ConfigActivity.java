package br.com.fiap.exerciciopersistencia;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.SeekBar;

public class ConfigActivity extends AppCompatActivity {

    SharedPreferences sp;

    CheckBox chkExibir;
    SeekBar skbTempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        chkExibir = findViewById(R.id.chkExibir);
        skbTempo = findViewById(R.id.skbTempo);
        sp = getSharedPreferences("config", MODE_PRIVATE);

        boolean exibir = sp.getBoolean("exibir",  true);
        int tempo = sp.getInt("tempo", 10000);

        chkExibir.setChecked(exibir);
        skbTempo.setProgress(tempo);
    }

    public void salvar(View view) {
        boolean exibir = chkExibir.isChecked();
        int tempo = skbTempo.getProgress();

        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("exibir", exibir);
        editor.putInt("tempo", tempo);
        editor.commit();
    }
}
