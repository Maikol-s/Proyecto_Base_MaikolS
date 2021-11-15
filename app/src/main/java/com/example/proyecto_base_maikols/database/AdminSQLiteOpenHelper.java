package com.example.proyecto_base_maikols.database;

import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;



public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    private SQLiteDatabase db;

    private static final String TABLE_PEDIDO_COMPRA = "CREATE TABLE Pedido(codP int primary key, codigo TEXT, cantidad INTEGER, direccion TEXT);";
    private static final String TABLE_NUEVO_PEDIDO = "CREATE TABLE Nuevo(codigo int primary key, nombre TEXT, categoria TEXT, anime TEXT);";

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version ) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Creación de la Tabla Pedido de Compra
        db.execSQL(TABLE_PEDIDO_COMPRA);
        db.execSQL(TABLE_NUEVO_PEDIDO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}

