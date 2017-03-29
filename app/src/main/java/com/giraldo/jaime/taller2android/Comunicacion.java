package com.giraldo.jaime.taller2android;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Observable;

/**
 * Created by jaime on 29/03/2017.
 */

public class Comunicacion extends Observable implements Runnable {

    private static Comunicacion ref;
    public static final int PORT = 6000;
    public static final String en301Wifi = "172.30.171.109";
    private DatagramSocket s;

    private Comunicacion() {
        try {
            s = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

    }

    public static Comunicacion getInstancia() {
        if (ref == null) {
            ref = new Comunicacion();
            new Thread(ref).start();
        }
        return ref;
    }

    public void enviar(final Object info, String ipAdrs) throws IOException {
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    byte[] data = serialize(info);
                    InetAddress host = null;
                    host = InetAddress.getByName(en301Wifi);
                    DatagramPacket dPacket = new DatagramPacket(data, data.length, host, PORT);
                    s.send(dPacket);

                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }


    private DatagramPacket recibir() throws IOException {
        try {
            byte[] data = new byte[1024];
            DatagramPacket dPacket = new DatagramPacket(data, data.length);
            s.receive(dPacket);
            return dPacket;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private byte[] serialize(Object o) {
        byte[] info = null;
        try {
            ByteArrayOutputStream baOut = new ByteArrayOutputStream();
            ObjectOutputStream oOut = new ObjectOutputStream(baOut);
            oOut.writeObject(o);
            info = baOut.toByteArray();

            oOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return info;
    }

    private Object deserialize(byte[] b) {
        Object data = null;
        try {
            ByteArrayInputStream baOut = new ByteArrayInputStream(b);
            ObjectInputStream oOut = new ObjectInputStream(baOut);
            data = oOut.readObject();

            oOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }
}
