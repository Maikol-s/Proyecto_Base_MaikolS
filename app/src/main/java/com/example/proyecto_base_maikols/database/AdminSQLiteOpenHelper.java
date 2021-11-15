package com.example.proyecto_base_maikols.database;

import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;



public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    private SQLiteDatabase db;

    private static final String TABLE_PEDIDO_COMPRA = "CREATE TABLE Pedido(id INTEGER primary key autoincrement, codigo TEXT, codP INTEGER, cantidad INTEGER, direccion TEXT);";


    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version ) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Creación de la Tabla Pedido de Compra
        db.execSQL(TABLE_PEDIDO_COMPRA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}

