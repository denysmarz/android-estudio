package com.example.clas3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Basededatos extends SQLiteOpenHelper {

    String SQL_CREATE = "CREATE TABLE lugares(id INTEGER PRIMARY KEY AUTOINCREMENT,nombre VARCHAR(45),descripcion VARCHAR(150),latitud VARCHAR(25),longitud VARCHAR(25));";
    String SQL_DROP = "DROP TABLE IF EXISTS lugares";

    public Basededatos(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
         sqLiteDatabase.execSQL(SQL_DROP);
         sqLiteDatabase.execSQL(SQL_CREATE);
    }
}
