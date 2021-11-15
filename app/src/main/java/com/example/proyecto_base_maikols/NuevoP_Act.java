package com.example.proyecto_base_maikols;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.proyecto_base_maikols.database.AdminSQLiteOpenHelper;

public class NuevoP_Act extends AppCompatActivity {

    private EditText codigoN,nombre,categoria,anime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_pact);

        codigoN = (EditText) findViewById(R.id.editCodigo);
        nombre = (EditText) findViewById(R.id.editNom);
        categoria = (EditText) findViewById(R.id.editCant);
        anime = (EditText) findViewById(R.id.editDirec);

    }


    public void Insertar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "AnimeShop", null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String codigo,anim,categ ,nom;

        codigo = codigoN.getText().toString();
        nom = nombre.getText().toString();
        categ = categoria.getText().toString();
        anim = anime.getText().toString();

        int codi = Integer.parseInt(codigo);


        if (!anim.isEmpty() && !categ.isEmpty() && !nom.isEmpty() && !codigo.isEmpty()){
            ContentValues con = new ContentValues();
            con.put("codigo",codi);
            con.put("nombre",codigo);
            con.put("categoria",categ);
            con.put("anime",anim);
            bd.insert("Nuevo",null,con);
            bd.close();
            Clear();
            Toast.makeText(getBaseContext(),"Pedido de Nuevo Producto Realizado", Toast.LENGTH_SHORT).show();
        }
    }

    public void Mostrar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "AnimeShop", null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String codiP = codigoN.getText().toString();
        int codi = Integer.parseInt(codiP);

        if (!codiP.isEmpty()){
            Cursor cu = bd.rawQuery("SELECT nombre, categoria, anime FROM Nuevo WHERE codigo="+codi,null);
            if (cu.moveToFirst()){
                //  codigoP**
                nombre.setText(cu.getString(0));
                categoria.setText(cu.getString(1));
                anime.setText(cu.getString(2));
            }else{
                Toast.makeText(getBaseContext(),"NO hay Pedido al Codigo Asociada", Toast.LENGTH_SHORT).show();
            }



        }else{
            Toast.makeText(getBaseContext(),"El Codigo No Puede Venir Vacio", Toast.LENGTH_SHORT).show();
        }


    }

    public void Eliminar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "AnimeShop", null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String codiP = codigoN.getText().toString();
        int codi = Integer.parseInt(codiP);

        if (!codiP.isEmpty()){
            int delet = bd.delete("Nuevo","codigo="+codi, null);
            bd.close();
            Clear();
            if (delet == 1){
                Toast.makeText(getBaseContext(),"Eliminaste un Pedido de Nuevo Producto", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(getBaseContext(),"No Existe el Pedido que Desea Eliminar", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getBaseContext(),"El Codigo No Puede Venir Vacio", Toast.LENGTH_SHORT).show();
        }

    }

    public void Modificar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "AnimeShop", null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String codigo,anim,categ ,nom;

        codigo = codigoN.getText().toString().trim();
        nom = nombre.getText().toString();
        categ = categoria.getText().toString();
        anim = anime.getText().toString();

        int codi = Integer.parseInt(codigo);

        if (!anim.isEmpty() && !categ.isEmpty() && !codigo.isEmpty() && !nom.isEmpty()){
            ContentValues con = new ContentValues();
            con.put("codigo",codi);
            con.put("nombre",nom);
            con.put("categoria",categ);
            con.put("anime",anim);

            bd.update("Nuevo", con,"codigo="+codi, null);
            bd.close();
            Clear();
            Toast.makeText(getBaseContext(),"Has Actualizado tu Pedido", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getBaseContext(),"No hay Campo los Cuales Actualizar", Toast.LENGTH_SHORT).show();

        }

    }

    public void Volver(View view){
        Intent i = new Intent(getBaseContext(), Home_Act.class);
        startActivity(i);

    }
    public void Clear(){
        anime.setText("");
        codigoN.setText("");
        categoria.setText("");
        nombre.setText("");
    }

}