package com.example.lpctest.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.lpctest.Entities.Pot;

public class DBManager {

    private DatabaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(Pot pot) {
        ContentValues contentValue = new ContentValues();

        contentValue.put(DatabaseHelper.NAME, pot.getName());
        contentValue.put(DatabaseHelper.creationDate,String.valueOf(pot.getCreationDate()));
        contentValue.put(DatabaseHelper.category, String.valueOf(pot.getCategory()));
        contentValue.put(DatabaseHelper.contributorsCount, String.valueOf(pot.getContributorsCount()));
        contentValue.put(DatabaseHelper.amount, String.valueOf(pot.getAmount()));

        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[] { DatabaseHelper._ID, DatabaseHelper.NAME, DatabaseHelper.creationDate,DatabaseHelper.category,DatabaseHelper.contributorsCount,DatabaseHelper.amount };
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }


}
