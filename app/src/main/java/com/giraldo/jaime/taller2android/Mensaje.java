package com.giraldo.jaime.taller2android;

import java.io.Serializable;

/**
 * Created by jaime on 29/03/2017.
 */

public class Mensaje implements Serializable {

    public String data;

    public Mensaje(String data) {
        this.data = data;
    }

    public String getContenido() {
        return data;
    }

    public void setContenido(String data) {
        this.data = data;
    }

}
