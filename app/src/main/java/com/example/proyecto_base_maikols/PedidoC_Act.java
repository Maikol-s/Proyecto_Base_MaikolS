package com.example.proyecto_base_maikols;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyecto_base_maikols.database.AdminSQLiteOpenHelper;

import Objetos.PedidoC;

public class PedidoC_Act extends AppCompatActivity {

    private Spinner codigoP;
    private EditText cantidad,dirección,codP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido_cact);

        codigoP = (Spinner) findViewById(R.id.spnCodigo);
        cantidad = (EditText) findViewById(R.id.editCant);
        codP = (EditText) findViewById(R.id.editCod);
        dirección = (EditText) findViewById(R.id.editDirec);



        Bundle bund = getIntent().getExtras();
        String[] listado = bund.getStringArray("codigo");

        ArrayAdapter adapterCodigoP = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listado);
        codigoP.setAdapter(adapterCodigoP);



    }

    public void Insertar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Anime_Shop", null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String codigo,direc,canti ,cod;

        codigo = codigoP.getSelectedItem().toString().trim();
        cod = codP.getText().toString();
        canti = cantidad.getText().toString();
        direc = dirección.getText().toString();
        int cantida = Integer.parseInt(canti);
        int codi = Integer.parseInt(cod);


        if (!direc.isEmpty() && !canti.isEmpty() && !cod.isEmpty()){
            ContentValues con = new ContentValues();
            con.put("id",0);
            con.put("codigo",codigo);
            con.put("codP",codi);
            con.put("cantidad",cantida);
            con.put("direccion",direc);
            bd.insert("Pedido",null,con);
            bd.close();
            Clear();
            Toast.makeText(getBaseContext(),"Pedido Realizado", Toast.LENGTH_SHORT).show();
        }
    }

    public void Mostrar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "AnimeShopApp", null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String codiP = codP.getText().toString();
        int codi = Integer.parseInt(codiP);

        if (!codiP.isEmpty()){
            Cursor cu = bd.rawQuery("SELECT cantidad, direccion FROM Pedido WHERE codP="+codi ,null);
            if (cu.moveToFirst()){
              //  codigoP**
                cantidad.setText(cu.getString(0));
                dirección.setText(cu.getString(1));
            }else{
                Toast.makeText(getBaseContext(),"NO ha Pedido al Codigo Asociada", Toast.LENGTH_SHORT).show();
            }



        }else{
            Toast.makeText(getBaseContext(),"El Codigo No Puede Venir Vacio", Toast.LENGTH_SHORT).show();
        }


    }

    public void Volver(View view){
        Intent i = new Intent(getBaseContext(), Home_Act.class);
        startActivity(i);

    }
    public void Clear(){
        cantidad.setText("");
        codP.setText("");
        dirección.setText("");
    }
}
