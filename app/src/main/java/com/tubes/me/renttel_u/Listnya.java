package com.tubes.me.renttel_u;

/**
 * Created by USER on 13-Nov-16.
 */

public class Listnya {
    private int id;
    private String namamotor;
    private String namarental;
    private int harga;

    public Listnya(int id, String namamotor, String namarental, int harga) {
        this.id = id;
        this.namamotor = namamotor;
        this.namarental = namarental;
        this.harga = harga;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamamotor() {
        return namamotor;
    }

    public void setNamamotor(String namamotor) {
        this.namamotor = namamotor;
    }

    public String getNamarental() {
        return namarental;
    }

    public void setNamarental(String namarental) {
        this.namarental = namarental;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
