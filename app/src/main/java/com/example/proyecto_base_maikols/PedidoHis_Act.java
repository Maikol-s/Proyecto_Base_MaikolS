package com.example.proyecto_base_maikols;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.proyecto_base_maikols.database.AdminSQLiteOpenHelper;

import java.util.List;

import Objetos.PedidoC;

public class PedidoHis_Act extends AppCompatActivity {

    private ListView listAnime;
    ArrayAdapter<String> adap;
    private AdminSQLiteOpenHelper base;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido_his);

        listAnime = (ListView) findViewById(R.id.listAnime);

       // base = new AdminSQLiteOpenHelper(getApplicationContext());

       // ListarPedidos();
    }

   /* private void ListarPedidos() {
        List<PedidoC> listap = base.VerPedidoC();
        if (!listap.isEmpty()){
            listAnime.setVisibility(View.VISIBLE);
            ArrayAdapter<PedidoC> adaptador = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,listap);
            listAnime.setAdapter(adaptador);
        }
    }
    public void Volver(View view){
        Intent i = new Intent(getBaseContext(), Home_Act.class);
        startActivity(i);

    }*/

}