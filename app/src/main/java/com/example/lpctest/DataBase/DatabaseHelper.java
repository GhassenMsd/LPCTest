package com.example.lpctest.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Table Name
    public static final String TABLE_NAME = "Pots";

    // Table columns
    public static final String _ID = "_id";
    public static final String NAME = "NAME";
    public static final String creationDate = "creationDate";
    public static final String category = "category";
    public static final String contributorsCount = "contributorsCount";
    public static final String amount = "amount";


    // Database Information
    static final String DB_NAME = "POT.DB";

    // database version
    static final int DB_VERSION = 1;

    // Creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + _ID
            + " TEXT PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT, " + creationDate + " TEXT, "+ category + " TEXT, "+contributorsCount + " TEXT, "+amount + " TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
