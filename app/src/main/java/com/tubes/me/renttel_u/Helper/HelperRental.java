package com.tubes.me.renttel_u.Helper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.tubes.me.renttel_u.Model.Rental;
import com.tubes.me.renttel_u.Model.User;

import java.util.ArrayList;
import java.util.List;

import static com.tubes.me.renttel_u.Util.Constant.KEY_ALAMAT;
import static com.tubes.me.renttel_u.Util.Constant.KEY_CREATED_AT;
import static com.tubes.me.renttel_u.Util.Constant.KEY_EMAIL;
import static com.tubes.me.renttel_u.Util.Constant.KEY_HP;
import static com.tubes.me.renttel_u.Util.Constant.KEY_ID_RENTAL;
import static com.tubes.me.renttel_u.Util.Constant.KEY_ID_USER;
import static com.tubes.me.renttel_u.Util.Constant.KEY_NAMA;
import static com.tubes.me.renttel_u.Util.Constant.KEY_NAMA_RENTAL;
import static com.tubes.me.renttel_u.Util.Constant.KEY_PASSWORD;
import static com.tubes.me.renttel_u.Util.Constant.TABLE_RENTAL;

/**
 * Created by USER on 26-Nov-16.
 */

public class HelperRental {
    private SQLiteDatabase Activedb;

    public HelperRental(SQLiteDatabase dbparam){
        this.Activedb = dbparam;
    }


    public long createRental(Rental todo, String date) {
        SQLiteDatabase db = this.Activedb;

        ContentValues values = new ContentValues();

        values.put(KEY_NAMA_RENTAL, todo.getNama());
        values.put(KEY_HP, todo.getHp());
        values.put(KEY_ALAMAT, todo.getAlamat());
        values.put(KEY_EMAIL, todo.getEmail());
        values.put(KEY_PASSWORD, todo.getPassword());
        values.put(KEY_CREATED_AT, date);

        long todo_id = db.insert(TABLE_RENTAL, null, values);

        return todo_id;
    }

    public User getRental(long id_rental) {
        SQLiteDatabase db = this.Activedb;

        String selectQuery = "SELECT  * FROM " + TABLE_RENTAL + " WHERE "
                + KEY_ID_RENTAL + " = " + id_rental;

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        User td = new User();
        td.setId_user(c.getInt(c.getColumnIndex(KEY_ID_USER)));
        td.setAlamat(c.getString(c.getColumnIndex(KEY_ALAMAT)));
        td.setEmail(c.getString(c.getColumnIndex(KEY_EMAIL)));
        td.setHp(c.getString(c.getColumnIndex(KEY_HP)));
        td.setNama(c.getString(c.getColumnIndex(KEY_NAMA)));

        return td;
    }

    public Rental getRentalLogin (String email, String passwd){
        SQLiteDatabase db = this.Activedb;

        String query = "SELECT * FROM " + TABLE_RENTAL + " WHERE " + KEY_EMAIL + " = \"" + email + "\" AND "+KEY_PASSWORD+" = \"" + passwd + "\"";
        Log.i("sql",query);
        Cursor c = db.rawQuery(query, null);

        if (c != null)
            c.moveToFirst();

        Rental rn = new Rental();
        rn.setNama(c.getString(c.getColumnIndex(KEY_NAMA_RENTAL)));
        rn.setAlamat(c.getString(c.getColumnIndex(KEY_ALAMAT)));
        rn.setEmail(c.getString(c.getColumnIndex(KEY_EMAIL)));
        rn.setHp(c.getString(c.getColumnIndex(KEY_HP)));
        rn.setId_rental(c.getInt(c.getColumnIndex(KEY_ID_RENTAL)));
        rn.setPassword(c.getString(c.getColumnIndex(KEY_PASSWORD)));

        return rn;
    }

    public List<Rental> getAllToDos() {
        List<Rental> todos = new ArrayList<Rental>();
        String selectQuery = "SELECT  * FROM " + TABLE_RENTAL;

        SQLiteDatabase db = this.Activedb;
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Rental td = new Rental();
                td.setId_rental(c.getInt((c.getColumnIndex(KEY_ID_RENTAL))));
                td.setNama((c.getString(c.getColumnIndex(KEY_NAMA_RENTAL))));
                td.setEmail(c.getString(c.getColumnIndex(KEY_EMAIL)));
                td.setAlamat(c.getString(c.getColumnIndex(KEY_ALAMAT)));
                td.setHp(c.getString(c.getColumnIndex(KEY_HP)));
                td.setPassword(c.getString(c.getColumnIndex(KEY_PASSWORD)));

                // adding to todo list
                todos.add(td);
            } while (c.moveToNext());
        }

        return todos;
    }

    // closing database
    public void closeDB() {
        SQLiteDatabase db = this.Activedb;
        if (db != null && db.isOpen())
            db.close();
    }
}
