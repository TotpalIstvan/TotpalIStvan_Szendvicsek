package com.example.szendvicsek;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "szendvicsek.db";
    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "szendivcsek";
    private static final String COL_ID = "id";
    private static final String COL_NEV= "nev";
    private static final String COL_LEIRAS = "leiras";
    private static final String COL_ELKESZITES = "elkeszites";
    private static final String COL_AR = "ar";

    public DbHelper(Context context) {
        super(context, DB_NAME,null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " +TABLE_NAME +" (" +
                COL_ID + "INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_NEV + "TEXT NOT NULL," +
                COL_LEIRAS + "TEXT NOT NULL," +
                COL_ELKESZITES + "INTEGER NOT NULL," +
                COL_AR + "INTEGER NOT NULL," +
                "UNIQUE(" + COL_NEV + ") " +
                ");";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean felvetel(String nev, String leiras, String elkeszites, String ar) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NEV, nev);
        values.put(COL_LEIRAS, leiras);
        values.put(COL_ELKESZITES, elkeszites);
        values.put(COL_AR, ar);
        return db.insert(TABLE_NAME, null, values) != -1;
    }


   public Cursor listazas(String ar) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COL_AR + "< ?", new String[]{ar});
   }
}
