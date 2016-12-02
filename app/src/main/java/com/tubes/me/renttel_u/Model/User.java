package com.tubes.me.renttel_u.Model;

/**
 * Created by USER on 26-Nov-16.
 */

public class User {
    private int id_user;
    private String password;
    private String nama;
    private String email;
    private String alamat;
    private String hp;

    public User(int id_user, String nama, String email, String alamat, String hp) {
        this.id_user = id_user;
        this.nama = nama;
        this.email = email;
        this.alamat = alamat;
        this.hp = hp;
        this.setPassword(getPassword());
    }

    public User(){

    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
