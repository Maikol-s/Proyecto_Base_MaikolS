package com.example.proyecto_base_maikols;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import Objetos.Productos;

public class Insumos_Act extends AppCompatActivity {

    private Spinner productos;
    private TextView categoria,resultado;
    private RatingBar calificar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos);

        productos = (Spinner) findViewById(R.id.spnAnime);
        categoria = (TextView) findViewById(R.id.tvcategoria);
        resultado = (TextView) findViewById(R.id.tvprecio);
        calificar = (RatingBar) findViewById(R.id.rtbInsumo);


        Bundle bund = getIntent().getExtras();
        String[] listado = bund.getStringArray("anime");

        ArrayAdapter adapterProductos = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listado);
        productos.setAdapter(adapterProductos);
    }

    public void Calcular(View view){
        Productos produc = new Productos();

        if (productos.getSelectedItem().toString().equals(produc.getAnime()[0]) ){
            categoria.setText("Categoria: " + produc.getCategoria()[0] );
            int add = produc.add(produc.getPrecio()[0],produc.getAdicional()[0]);
            resultado.setText("El costo del Producto: "+produc.getAnime()[0]+ " Es de: " +add);

            calificar.setRating(4);
            float rat =calificar.getRating();
            Toast.makeText(this,"Calificacion del Producto:"+ rat, Toast.LENGTH_SHORT).show();
        }
        else if (productos.getSelectedItem().toString().equals(produc.getAnime()[1]) ){
            categoria.setText("Categoria: " + produc.getCategoria()[1] );
            int add = produc.add(produc.getPrecio()[1],produc.getAdicional()[1]);
            resultado.setText("El costo del Producto: "+produc.getAnime()[1]+ " Es de: " +add);

            calificar.setRating(5);
            float rat =calificar.getRating();
            Toast.makeText(this,"Calificacion del Producto:"+ rat, Toast.LENGTH_SHORT).show();
        }
        else if (productos.getSelectedItem().toString().equals(produc.getAnime()[2]) ){
            categoria.setText("Categoria: " + produc.getCategoria()[2] );
            int add = produc.add(produc.getPrecio()[2],produc.getAdicional()[2]);
            resultado.setText("El costo del Producto: "+produc.getAnime()[2]+ " Es de: " +add);

            calificar.setRating(3);
            float rat =calificar.getRating();
            Toast.makeText(this,"Calificacion del Producto:"+ rat, Toast.LENGTH_SHORT).show();
        }
        else {
            categoria.setText("Categoria: " + produc.getCategoria()[3] );
            int add = produc.add(produc.getPrecio()[3],produc.getAdicional()[3]);
            resultado.setText("El costo del Producto: "+produc.getAnime()[3]+ " Es de: " +add);

            calificar.setRating(5);
            float rat =calificar.getRating();
            Toast.makeText(this,"Calificacion del Producto:"+ rat, Toast.LENGTH_SHORT).show();
        }
    }



}