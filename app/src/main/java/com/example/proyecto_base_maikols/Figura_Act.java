package com.example.proyecto_base_maikols;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import Objetos.Productos;

public class Figura_Act extends AppCompatActivity {

    private TextView nombre,codigo,categoria,precio,adic,total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_figura);


        nombre = (TextView) findViewById(R.id.tvNombre);
        codigo = (TextView) findViewById(R.id.tvCod);
        categoria = (TextView) findViewById(R.id.tvCat);
        precio = (TextView) findViewById(R.id.tvPre);
        adic = (TextView) findViewById(R.id.tvAd);
        total = (TextView) findViewById(R.id.tvTo);

        Productos pro = new Productos();

        nombre.setText(pro.getAnime()[0]);
        codigo.setText("Codigo Pedido: "+pro.getCodigo()[0]);
        categoria.setText("Categoria: "+pro.getCategoria()[0]);
        adic.setText("Adicional por Entrega: $"+pro.getAdicional()[0]);
        precio.setText("Precio: $"+pro.getPrecio()[0]);

        int pre,ad;
        pre = pro.getPrecio()[0];
        ad = pro.getAdicional()[0];
        int tot = pro.add(pre,ad);

        total.setText("Total: $"+tot);
    }

    public void Volver(View view){
        Intent i = new Intent(getBaseContext(), Home_Act.class);
        startActivity(i);

    }
}