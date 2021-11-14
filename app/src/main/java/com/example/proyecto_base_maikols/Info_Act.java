package com.example.proyecto_base_maikols;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Info_Act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }

    public void Marcar(View view){
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+"958513120"));
        startActivity(i);
    }
    public void Maps(View view){
        Intent i = new Intent(this, MapsActivity.class);
        startActivity(i);
    }


}