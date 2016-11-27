package com.tubes.me.renttel_u.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.tubes.me.renttel_u.Util.Constant.*;

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
    private static final String CREATE_TABLE_USER = "CREATE TABLE "
            + TABLE_USER + "(" + KEY_ID_USER + " INTEGER PRIMARY KEY," + KEY_NAMA
            + " TEXT," + KEY_EMAIL + " TEXT," + KEY_ALAMAT + "TEXT,"+ KEY_HP
            + " TEXT," + KEY_CREATED_AT + " DATETIME" + ")";

    // Tag table create statement
    private static final String CREATE_TABLE_RENTAL = "CREATE TABLE " + TABLE_RENTAL
            + "(" + KEY_ID_RENTAL + " INTEGER PRIMARY KEY,"
            + KEY_ID_BOOKING + " INTEGER," + KEY_ID_MOTOR + " INTEGER,"
            + KEY_ID_USER + " INTEGER,"
            + KEY_CREATED_AT + " DATETIME" + ")";

    // Tag table create statement
    private static final String CREATE_TABLE_BOOKING = "CREATE TABLE " + TABLE_BOOKING
            + "(" + KEY_ID_BOOKING + " INTEGER PRIMARY KEY," + KEY_NAMA_RENTAL + " TEXT,"
            + KEY_ID_RENTAL + " INTEGER,"
            + KEY_CREATED_AT + " DATETIME" + ")";

    // todo_tag table create statement
    private static final String CREATE_TABLE_MOTOR = "CREATE TABLE "
            + TABLE_MOTOR + "(" + KEY_ID_MOTOR + " INTEGER PRIMARY KEY,"
            + KEY_MERK + " TEXT," + KEY_BRAND + " TEXT," + KEY_HARGA + " DOUBLE,"
            + KEY_DESKRIPSI + " TEXT," + KEY_ID_RENTAL + " INTEGER,"
            + KEY_CREATED_AT + " DATETIME" + ")";

    public BaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
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

}
