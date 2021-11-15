package com.example.proyecto_base_maikols;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import Objetos.Productos;

public class Ropa_Act extends AppCompatActivity {

    private TextView nombre,codigo,categoria,precio,adic,total;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ropa);

        nombre = (TextView) findViewById(R.id.tvNombre);
        codigo = (TextView) findViewById(R.id.tvCod);
        categoria = (TextView) findViewById(R.id.tvCat);
        precio = (TextView) findViewById(R.id.tvPre);
        adic = (TextView) findViewById(R.id.tvAd);
        total = (TextView) findViewById(R.id.tvTo);

        Productos pro = new Productos();
        
        nombre.setText(pro.getAnime()[3]);
        codigo.setText("Codigo Pedido: "+pro.getCodigo()[3]);
        categoria.setText("Categoria: "+pro.getCategoria()[3]);
        adic.setText("Adicional por Entrega: $"+pro.getAdicional()[3]);
        precio.setText("Precio: $"+pro.getPrecio()[3]);
        
        int pre,ad;
        pre = pro.getPrecio()[3];
        ad = pro.getAdicional()[3];
        int tot = pro.add(pre,ad);

        total.setText("Total: $"+tot);


    }

    public void Volver(View view){
        Intent i = new Intent(getBaseContext(), Home_Act.class);
        startActivity(i);

    }
}