package com.tubes.me.renttel_u.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.tubes.me.renttel_u.Util.Constant.KEY_ALAMAT;
import static com.tubes.me.renttel_u.Util.Constant.KEY_BRAND;
import static com.tubes.me.renttel_u.Util.Constant.KEY_CREATED_AT;
import static com.tubes.me.renttel_u.Util.Constant.KEY_DESKRIPSI;
import static com.tubes.me.renttel_u.Util.Constant.KEY_EMAIL;
import static com.tubes.me.renttel_u.Util.Constant.KEY_HARGA;
import static com.tubes.me.renttel_u.Util.Constant.KEY_HP;
import static com.tubes.me.renttel_u.Util.Constant.KEY_ID_BOOKING;
import static com.tubes.me.renttel_u.Util.Constant.KEY_ID_MOTOR;
import static com.tubes.me.renttel_u.Util.Constant.KEY_ID_RENTAL;
import static com.tubes.me.renttel_u.Util.Constant.KEY_ID_USER;
import static com.tubes.me.renttel_u.Util.Constant.KEY_MERK;
import static com.tubes.me.renttel_u.Util.Constant.KEY_NAMA;
import static com.tubes.me.renttel_u.Util.Constant.KEY_NAMA_RENTAL;
import static com.tubes.me.renttel_u.Util.Constant.KEY_PASSWORD;
import static com.tubes.me.renttel_u.Util.Constant.TABLE_BOOKING;
import static com.tubes.me.renttel_u.Util.Constant.TABLE_MOTOR;
import static com.tubes.me.renttel_u.Util.Constant.TABLE_RENTAL;
import static com.tubes.me.renttel_u.Util.Constant.TABLE_USER;

/**
 * Created by USER on 26-Nov-16.
 */

public class BaseHelper extends SQLiteOpenHelper {
    // Logcat tag
    private static final String LOG = "BaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "dbrental";

    // Table Names




    // Table Create Statements
    // Todo table create statement
    private static final String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_USER + "("
            + KEY_ID_USER + " INTEGER PRIMARY KEY,"
            + KEY_NAMA + " TEXT,"
            + KEY_EMAIL + " TEXT,"
            + KEY_ALAMAT + "TEXT,"
            + KEY_HP + " TEXT,"
            + KEY_CREATED_AT + " DATETIME" + ")";

    // Tag table create statement
    private static final String CREATE_TABLE_RENTAL = "CREATE TABLE " + TABLE_RENTAL
            + "("
            + KEY_ID_RENTAL + " INTEGER PRIMARY KEY,"
            + KEY_NAMA_RENTAL + " TEXT,"
            + KEY_EMAIL + " TEXT,"
            + KEY_ALAMAT + " TEXT,"
            + KEY_HP + " TEXT,"
            + KEY_PASSWORD + " TEXT,"
            + KEY_CREATED_AT + " DATETIME" + ")";

    // Tag table create statement
    private static final String CREATE_TABLE_BOOKING = "CREATE TABLE " + TABLE_BOOKING + "("
            + KEY_ID_BOOKING + " INTEGER PRIMARY KEY,"
            + KEY_NAMA_RENTAL + " TEXT,"
            + KEY_ID_RENTAL + " INTEGER,"
            + KEY_CREATED_AT + " DATETIME" + ")";

    // todo_tag table create statement
    private static final String CREATE_TABLE_MOTOR = "CREATE TABLE " + TABLE_MOTOR + "("
            + KEY_ID_MOTOR + " INTEGER PRIMARY KEY,"
            + KEY_MERK + " TEXT,"
            + KEY_BRAND + " TEXT,"
            + KEY_HARGA + " DOUBLE,"
            + KEY_ID_RENTAL + " INTEGER,"
            + KEY_DESKRIPSI + " TEXT,"
            + KEY_CREATED_AT + " DATETIME" + ")";

    public BaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_RENTAL);
        db.execSQL(CREATE_TABLE_MOTOR);
        db.execSQL(CREATE_TABLE_BOOKING);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RENTAL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MOTOR);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOKING);

        // create new tables
        onCreate(db);
    }

    public String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
}
