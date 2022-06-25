package com.example.clas3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivityFormulario extends AppCompatActivity {
    Button insertarr,leer;
    //Basededatos dataBase;
    //SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_formulario);
        insertarr =findViewById(R.id.button31);
        leer =findViewById(R.id.button32);

        insertarr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivityFormulario.this,MainActivityInsertarFormulario.class);
                startActivity(intent);
            }
        });

        leer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivityFormulario.this,MainActivityLeerFormulario.class);
                startActivity(intent);
            }
        });

        /* dataBase = new Basededatos(MainActivityFormulario.this,"MIBASEE",null,1);

        //insertar rows
        db = dataBase.getWritableDatabase();
        //CREATE TABLE lugares(id INTEGER PRIMARY KEY AUTOINCREMENT,nombre VARCHAR(45),descripcion VARCHAR(150),latitud VARCHAR(25),longitud VARCHAR(25));
        db.execSQL("INSERT INTO lugares(nombre,descripcion,latitud,longitud)VALUES('Sucre','Capital de Bolivia','-5.67','-64.54');");
        db.execSQL("INSERT INTO lugares(nombre,descripcion,latitud,longitud)VALUES('Potosi','Capital de Bolivia','-50.67','-80.54');");


        //recovery rows
        String sql = "SELECT * FROM lugares;";
        db = dataBase.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        String aux ="";
        if(cursor.moveToFirst()){
            do {
                aux += cursor.getString(Integer.parseInt(String.valueOf(cursor.getColumnIndex("nombre"))));
            }while(cursor.moveToNext());
            Toast.makeText(MainActivityFormulario.this, aux, Toast.LENGTH_SHORT).show();
            //db.execSQL("DROP  TABLE lugares;");


        }*/
    }
}