package com.giraldo.jaime.taller2android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class Inicio extends AppCompatActivity implements View.OnClickListener {

    ImageButton instrucciones;
    ImageButton iniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_inicio);

        instrucciones = (ImageButton) findViewById(R.id.instruc);
        iniciar = (ImageButton) findViewById(R.id.iniciar);

        iniciar.setOnClickListener(this);
        instrucciones.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == instrucciones.getId()) {
            Intent instrucciones = new Intent("com.giraldo.jaime.taller2android.Instrucciones");
            startActivity(instrucciones);
        } else if (v.getId() == iniciar.getId()) {
            Intent instrucciones = new Intent("com.giraldo.jaime.taller2android.Interaccion");
            startActivity(instrucciones);
        }
    }
}
