package com.tubes.me.renttel_u.Model;

/**
 * Created by USER on 26-Nov-16.
 */

public class Motor {
    private int id_motor;
    private String nama_motor;
    private int id_rental;
    private double harga;
    private String deskripsi;


    public Motor(int id_motor, String nama_motor, int id_rental, double harga, String deskripsi) {
        this.id_motor = id_motor;
        this.nama_motor = nama_motor;
        this.id_rental = id_rental;
        this.harga = harga;
        this.deskripsi = deskripsi;
    }

    public Motor(){

    }

    public int getId_motor() {
        return id_motor;
    }

    public void setId_motor(int id_motor) {
        this.id_motor = id_motor;
    }

    public String getNama_motor() {
        return nama_motor;
    }

    public void setNama_motor(String nama_motor) {
        this.nama_motor = nama_motor;
    }

    public int getId_rental() {
        return id_rental;
    }

    public void setId_rental(int id_rental) {
        this.id_rental = id_rental;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
