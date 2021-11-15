package com.example.proyecto_base_maikols;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import Objetos.Productos;

public class Home_Act extends AppCompatActivity {

    private Productos produc = new Productos();
    VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        video = (VideoView) findViewById(R.id.vwAnime);

        video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ani1));
        MediaController control = new MediaController(this);
        video.setMediaController(control);
        video.start();

    }

    public void Productos(View view){
        Intent i = new Intent(this, Insumos_Act.class);
        Bundle bund = new Bundle();
        bund.putStringArray("anime",produc.getAnime());
        i.putExtras(bund);
        startActivity(i);
    }

    public void CerrarSesión(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void PedidoCompra(View view){
        Intent i = new Intent(this, PedidoC_Act.class);
        Bundle bunde = new Bundle();
        bunde.putStringArray("codigo",produc.getCodigo());
        i.putExtras(bunde);
        startActivity(i);

    }
    public void NuevoPedido(View view){
        Intent i = new Intent(this, NuevoP_Act.class);
        startActivity(i);

    }
    public void Ropa(View view){
        Intent i = new Intent(this, Ropa_Act.class);
        startActivity(i);

    }
    public void Figuara(View view){
        Intent i = new Intent(this, Figura_Act.class);
        startActivity(i);

    }
    public void Manga(View view){
        Intent i = new Intent(this, Manga_Act.class);
        startActivity(i);

    }
    public void Peluche(View view){
        Intent i = new Intent(this, Peluche_Act.class);
        startActivity(i);

    }

}