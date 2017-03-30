package com.giraldo.jaime.taller2android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

public class Interaccion extends AppCompatActivity implements View.OnClickListener {

    ImageButton añadirOrbe1;
    ImageButton añadirOrbe2;
    ImageButton añadirOrbe3;
    ImageButton añadirEnem1;
    ImageButton añadirEnem2;
    ImageButton añadirEnem3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_interaccion);

        definirBotones();
    }

    private void definirBotones() {
        añadirOrbe1 = (ImageButton) findViewById(R.id.addOrb1);
        añadirOrbe2 = (ImageButton) findViewById(R.id.addOrb2);
        añadirOrbe3 = (ImageButton) findViewById(R.id.addOrb3);
        añadirEnem1 = (ImageButton) findViewById(R.id.addEnem1);
        añadirEnem2 = (ImageButton) findViewById(R.id.addEnem2);
        añadirEnem3 = (ImageButton) findViewById(R.id.addEnem3);

        añadirOrbe1.setOnClickListener(this);
        añadirOrbe2.setOnClickListener(this);
        añadirOrbe3.setOnClickListener(this);

        añadirEnem1.setOnClickListener(this);
        añadirEnem2.setOnClickListener(this);
        añadirEnem3.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        if (v.getId() == añadirEnem1.getId()) {
            Toast.makeText(getApplicationContext(), "Se añadió un enemigo clase 1", Toast.LENGTH_LONG).show();
        } else if (v.getId() == añadirEnem2.getId()) {
            Toast.makeText(getApplicationContext(), "Se añadió un enemigo clase 2", Toast.LENGTH_LONG).show();
        } else if (v.getId() == añadirEnem3.getId()) {
            Toast.makeText(getApplicationContext(), "Se añadió un enemigo clase 3", Toast.LENGTH_LONG).show();
        } else if (v.getId() == añadirOrbe1.getId()) {
            Toast.makeText(getApplicationContext(), "Se añadió un orbe clase 1", Toast.LENGTH_LONG).show();
        } else if (v.getId() == añadirOrbe2.getId()) {
            Toast.makeText(getApplicationContext(), "Se añadió un orbe clase 2", Toast.LENGTH_LONG).show();
        } else if (v.getId() == añadirOrbe3.getId()) {
            Toast.makeText(getApplicationContext(), "Se añadió un orbe clase 3", Toast.LENGTH_LONG).show();
        }

    }
}
