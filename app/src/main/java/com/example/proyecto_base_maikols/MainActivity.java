package com.example.proyecto_base_maikols;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import Objetos.Administrador;

public class MainActivity extends AppCompatActivity {
    private EditText usuario,password;
    private TextView mensaje;
    private Administrador adm = new Administrador();
    private Button btn;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.pass);
        mensaje = (TextView) findViewById(R.id.msj);
        btn = (Button) findViewById(R.id.btn);
        pb = (ProgressBar) findViewById(R.id.pb);

        pb.setVisibility(View.INVISIBLE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Task().execute();
            }
        });

    }

    class Task extends AsyncTask<String, Void, String>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pb.setVisibility(View.VISIBLE);
            mensaje.setText("");
        }

        @Override
        protected String doInBackground(String... strings) {
            try {

                for (int i =0; i<10; i++){
                    Thread.sleep(1000);

                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            pb.setVisibility(View.INVISIBLE);
            String userObj = adm.getUser().toString().trim();
            String passObj = adm.getPass().toString().trim();

            String usu = usuario.getText().toString().trim();
            String contraseña = password.getText().toString().trim();

            switch (usu)
            {
                case "Maikol":
                    if (usu.equals(userObj) && contraseña.equals(passObj)){
                        mensaje.setText("");
                        Toast.makeText(getBaseContext(),"Sesion Iniciada", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getBaseContext(), Home_Act.class);
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
    public void Info(View view){
        Intent i = new Intent(this, Info_Act.class);
        startActivity(i);
    }


}