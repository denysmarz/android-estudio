package com.example.clas3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivityInsertarFormulario extends AppCompatActivity {
    Button inserter;
    EditText nom,des,lag,log;

    Basededatos dataBase;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_insertar_formulario);

        inserter = findViewById(R.id.button33);
        nom = findViewById(R.id.editTextTextPersonName12);
        des = findViewById(R.id.editTextTextPersonName13);
        lag = findViewById(R.id.editTextTextPersonName14);
        log = findViewById(R.id.editTextTextPersonName15);



        inserter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                dataBase = new Basededatos(MainActivityInsertarFormulario.this,"MIBASES",null,1);
                //String nomb = nom.getText();
                String desc = des.getText().toString();
                String lat = lag.getText().toString();
                String longi = log.getText().toString();
                //insertar rows
                db = dataBase.getWritableDatabase();
                //CREATE TABLE lugares(id INTEGER PRIMARY KEY AUTOINCREMENT,nombre VARCHAR(45),descripcion VARCHAR(150),latitud VARCHAR(25),longitud VARCHAR(25));

                db.execSQL("INSERT INTO lugares(nombre,descripcion,latitud,longitud)VALUES("+"'"+nom.getText()+"'"+" , "+"'"+des.getText()+"'"+","+"'"+lag.getText()+"'"+","+"'"+log.getText()+"'"+");");
                Toast.makeText(MainActivityInsertarFormulario.this, "DATOS INSERTADOS CORRECTAMENTE", Toast.LENGTH_SHORT).show();
                //db.execSQL("INSERT INTO lugares(nombre,descripcion,latitud,longitud)VALUES('Potosi','Capital de Bolivia','-50.67','-80.54');");
                //db.execSQL("UPDATE lugares SET latitud='-11.722167' , longitud='-42.966759' WHERE nombre='El Alto';");

                Intent intent = new Intent( MainActivityInsertarFormulario.this,MainActivityFormulario.class);
                startActivity(intent);



            }
        });

    }
}