package com.tubes.me.renttel_u.Model;

import java.util.Date;

/**
 * Created by USER on 26-Nov-16.
 */

public class Booking {
    private int id_user;
    private int id_motor;
    private int id_rental;
    private Date tanggal_mulai;
    private Date tanggal_selesai;


    public Booking(int id_user, int id_motor, int id_rental, Date tanggal_mulai, Date tanggal_selesai) {
        this.id_user = id_user;
        this.id_motor = id_motor;
        this.id_rental = id_rental;
        this.tanggal_mulai = tanggal_mulai;
        this.tanggal_selesai = tanggal_selesai;
    }

    public Booking(){

    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_motor() {
        return id_motor;
    }

    public void setId_motor(int id_motor) {
        this.id_motor = id_motor;
    }

    public int getId_rental() {
        return id_rental;
    }

    public void setId_rental(int id_rental) {
        this.id_rental = id_rental;
    }

    public Date getTanggal_mulai() {
        return tanggal_mulai;
    }

    public void setTanggal_mulai(Date tanggal_mulai) {
        this.tanggal_mulai = tanggal_mulai;
    }

    public Date getTanggal_selesai() {
        return tanggal_selesai;
    }

    public void setTanggal_selesai(Date tanggal_selesai) {
        this.tanggal_selesai = tanggal_selesai;
    }
}
