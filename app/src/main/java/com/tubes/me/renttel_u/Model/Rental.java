package com.tubes.me.renttel_u.Model;

/**
 * Created by USER on 26-Nov-16.
 */

public class Rental {
    private int id_rental;
    private String nama;
    private String email;
    private String alamat;
    private String hp;


    public Rental(int id_rental, String nama, String email, String alamat, String hp) {
        this.id_rental = id_rental;
        this.nama = nama;
        this.email = email;
        this.alamat = alamat;
        this.hp = hp;
    }

    public Rental(){

    }

    public int getId_rental() {
        return id_rental;
    }

    public void setId_rental(int id_rental) {
        this.id_rental = id_rental;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }


}
