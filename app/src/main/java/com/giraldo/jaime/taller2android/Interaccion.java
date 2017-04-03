package com.giraldo.jaime.taller2android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import CommonAndroid.Anadir;
import CommonAndroid.Nombre;

public class Interaccion extends AppCompatActivity implements View.OnClickListener, Observer {

    private ImageButton añadirOrbe1;
    private ImageButton añadirOrbe2;
    private ImageButton añadirOrbe3;
    private ImageButton añadirEnem1;
    private ImageButton añadirEnem2;
    private ImageButton añadirEnem3;
    private TextView user1, user2, user3;

    private String nombre1, nombre2, nombre3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_interaccion);
        definirBotones();

        user1 = (TextView) findViewById(R.id.userName1);
        user2 = (TextView) findViewById(R.id.userName2);
        user3 = (TextView) findViewById(R.id.userName3);

        Comunicacion.getInstancia().addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Nombre) {
            Nombre temp = (Nombre) arg;
            if (temp.getEmisor() == 1) {
                nombre1 = temp.getNombre();
                user1.post(new Runnable() {
                    public void run() {
                        user1.setText(nombre1);
                    }
                });
            } else if (temp.getEmisor() == 2) {
                nombre2 = temp.getNombre();
                user2.post(new Runnable() {
                    public void run() {
                        user2.setText(nombre2);
                    }
                });
            } else if (temp.getEmisor() == 3) {
                nombre3 = temp.getNombre();
                user3.post(new Runnable() {
                    public void run() {
                        user3.setText(nombre3);
                    }
                });
            }
        }
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
            try {
                Comunicacion.getInstancia().enviar(new Anadir(1, 1));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Toast.makeText(getApplicationContext(), "Se añadió un enemigo clase 1", Toast.LENGTH_LONG).show();
        } else if (v.getId() == añadirEnem2.getId()) {
            try {
                Comunicacion.getInstancia().enviar(new Anadir(2, 1));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Toast.makeText(getApplicationContext(), "Se añadió un enemigo clase 2", Toast.LENGTH_LONG).show();
        } else if (v.getId() == añadirEnem3.getId()) {
            try {
                Comunicacion.getInstancia().enviar(new Anadir(3, 1));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Toast.makeText(getApplicationContext(), "Se añadió un enemigo clase 3", Toast.LENGTH_LONG).show();
        } else if (v.getId() == añadirOrbe1.getId()) {
            try {
                Comunicacion.getInstancia().enviar(new Anadir(1, 2));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Toast.makeText(getApplicationContext(), "Se añadió un orbe clase 1", Toast.LENGTH_LONG).show();
        } else if (v.getId() == añadirOrbe2.getId()) {
            try {
                Comunicacion.getInstancia().enviar(new Anadir(2, 2));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Toast.makeText(getApplicationContext(), "Se añadió un orbe clase 2", Toast.LENGTH_LONG).show();
        } else if (v.getId() == añadirOrbe3.getId()) {
            try {
                Comunicacion.getInstancia().enviar(new Anadir(2, 2));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Toast.makeText(getApplicationContext(), "Se añadió un orbe clase 3", Toast.LENGTH_LONG).show();
        }

    }


}
