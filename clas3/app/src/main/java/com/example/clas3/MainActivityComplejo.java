package com.example.clas3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityComplejo extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4;
    Button botonsuma,botonresta,botonmultiplicacion,botondividir;
    TextView LabelResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_complejo);
        Intent intent = getIntent();

        String aux = intent.getStringExtra("Cadena");
        int d = intent.getIntExtra("Mientero",0);
        boolean MiBooleano = intent.getBooleanExtra("MiBoleano",true);


        Operaciones oper2 = (Operaciones)intent.getSerializableExtra("MiObjeto");
        Toast.makeText(MainActivityComplejo.this,"Recuperado: "+aux+"Entero "+d+oper2.suma(),Toast.LENGTH_SHORT).show();

        ed1 = findViewById(R.id.editTextTextPersonName);
        ed2 = findViewById(R.id.editTextTextPersonName2);
        ed3 = findViewById(R.id.editTextTextPersonName3);
        ed4 = findViewById(R.id.editTextTextPersonName4);

        botonsuma = findViewById(R.id.button6);
        botonresta = findViewById(R.id.button8);
        botonmultiplicacion = findViewById(R.id.button10);
        botondividir = findViewById(R.id.button11);
        LabelResultado = findViewById(R.id.textView2);

        botonsuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float a = Integer.parseInt(ed1.getText().toString());
                float b = Integer.parseInt(ed2.getText().toString());
                float c = Integer.parseInt(ed3.getText().toString());
                float d = Integer.parseInt(ed4.getText().toString());

                Operaciones operaciones = new Operaciones(a,b,c,d);
                LabelResultado.setText(String.valueOf(operaciones.suma()));
                //LabelResultado.setText(String.valueOf("12"));

            }
        });
        botonresta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float a = Integer.parseInt(ed1.getText().toString());
                float b = Integer.parseInt(ed2.getText().toString());
                float c = Integer.parseInt(ed3.getText().toString());
                float d = Integer.parseInt(ed4.getText().toString());

                Operaciones operaciones = new Operaciones(a,b,c,d);
                LabelResultado.setText(String.valueOf(operaciones.resta()));
                //LabelResultado.setText(String.valueOf("12"));
            }
        });//el hombre que comnocio el infinito
        botonmultiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float a = Integer.parseInt(ed1.getText().toString());
                float b = Integer.parseInt(ed2.getText().toString());
                float c = Integer.parseInt(ed3.getText().toString());
                float d = Integer.parseInt(ed4.getText().toString());

                Operaciones operaciones = new Operaciones(a,b,c,d);
                LabelResultado.setText(String.valueOf(operaciones.multiplicacion()));
                //LabelResultado.setText(String.valueOf("12"));
            }
        });
        botondividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float a = Integer.parseInt(ed1.getText().toString());
                float b = Integer.parseInt(ed2.getText().toString());
                float c = Integer.parseInt(ed3.getText().toString());
                float d = Integer.parseInt(ed4.getText().toString());

                Operaciones operaciones = new Operaciones(a,b,c,d);
                LabelResultado.setText(String.valueOf(operaciones.division()));
                //LabelResultado.setText(String.valueOf("12"));
            }
        });
    }

}