package com.example.proyecto_base_maikols;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Insumos_Act extends AppCompatActivity {

    private Spinner productos;
    private TextView categoria,resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos);

        productos = (Spinner) findViewById(R.id.spnAnime);
        categoria = (TextView) findViewById(R.id.tvcategoria);
        resultado = (TextView) findViewById(R.id.tvprecio);


        Bundle bund = getIntent().getExtras();
        String[] listado = bund.getStringArray("anime");

        ArrayAdapter adapterProductos = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listado);
        productos.setAdapter(adapterProductos);
    }

    public void Calcular(View view){

    }



}