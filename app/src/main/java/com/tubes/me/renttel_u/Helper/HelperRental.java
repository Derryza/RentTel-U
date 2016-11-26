package com.tubes.me.renttel_u.Helper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.tubes.me.renttel_u.Model.User;

import static com.tubes.me.renttel_u.Util.Constant.KEY_ALAMAT;
import static com.tubes.me.renttel_u.Util.Constant.KEY_EMAIL;
import static com.tubes.me.renttel_u.Util.Constant.KEY_HP;
import static com.tubes.me.renttel_u.Util.Constant.KEY_ID_RENTAL;
import static com.tubes.me.renttel_u.Util.Constant.KEY_ID_USER;
import static com.tubes.me.renttel_u.Util.Constant.KEY_NAMA;
import static com.tubes.me.renttel_u.Util.Constant.KEY_NAMA_RENTAL;
import static com.tubes.me.renttel_u.Util.Constant.TABLE_USER;

/**
 * Created by USER on 26-Nov-16.
 */

public class HelperRental {
    private SQLiteDatabase Activedb;

    public HelperRental(SQLiteDatabase dbparam){
        this.Activedb = dbparam;
    }


    public long createRental(User todo, long[] tag_ids) {
        SQLiteDatabase db = this.Activedb;

        ContentValues values = new ContentValues();
        values.put(KEY_ID_RENTAL, todo.getId_user());
        values.put(KEY_NAMA_RENTAL, todo.getAlamat());
        values.put(KEY_HP, todo.getHp());


        // insert row
        long todo_id = db.insert(TABLE_USER, null, values);


        return todo_id;
    }

    public User getUser(long user_id) {
        SQLiteDatabase db = this.Activedb;

        String selectQuery = "SELECT  * FROM " + TABLE_USER + " WHERE "
                + KEY_ID_USER + " = " + user_id;

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

    // closing database
    public void closeDB() {
        SQLiteDatabase db = this.Activedb;
        if (db != null && db.isOpen())
            db.close();
    }
}
