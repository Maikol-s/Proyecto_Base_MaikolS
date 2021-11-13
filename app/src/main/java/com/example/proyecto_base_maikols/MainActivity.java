package com.example.proyecto_base_maikols;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Objetos.Administrador;

public class MainActivity extends AppCompatActivity {
    private EditText usuario,password;
    private TextView mensaje;
    private Administrador adm = new Administrador();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.pass);
        mensaje = (TextView) findViewById(R.id.msj);
    }


    public void IniciarSesion(View view){
        String userObj = adm.getUser().toString().trim();
        String passObj = adm.getPass().toString().trim();

        String usu = usuario.getText().toString().trim();
        String contraseña = password.getText().toString().trim();

        switch (usu)
        {
            case "Maikol":
                if (usu.equals(userObj) && contraseña.equals(passObj)){
                    mensaje.setText("");
                    Toast.makeText(this,"Sesion Iniciada", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(this, Home_Act.class);
                    startActivity(i);
                }
                break;

            case "":
                if (usu.equals("") && contraseña.equals("")){
                    mensaje.setText("Por Favor Rellene los Campos");
                }
                break;

            default:
                if (!usu.equals(userObj) && !contraseña.equals(passObj)){
                    mensaje.setText("Algunos de los Campos son Incorrecto");
                }
                break;

        }

    }
    public void CerrarApp(View view){
        finish();
    }
    public void Facebook(View view){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.facebook.com/"));
        startActivity(i);
    }
    public void Youtube(View view){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.youtube.com/"));
        startActivity(i);
    }
    public void Twitter(View view){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.twitter.com/"));
        startActivity(i);
    }


}