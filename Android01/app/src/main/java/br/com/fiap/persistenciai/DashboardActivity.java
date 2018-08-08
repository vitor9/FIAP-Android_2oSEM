package br.com.fiap.persistenciai;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DashboardActivity extends AppCompatActivity {

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        sp = getSharedPreferences("login", MODE_PRIVATE);
    }

    public void logout(View view) {
        SharedPreferences.Editor editor = sp.edit();

        editor.remove("usuario");
        editor.remove("senha");
        editor.remove("conectado");

        editor.commit();

        finish();

    }

}
