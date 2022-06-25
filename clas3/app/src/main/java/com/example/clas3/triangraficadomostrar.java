package com.example.clas3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class triangraficadomostrar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangraficadomostrar);

        Intent intent = getIntent();

        int a = intent.getIntExtra("a",0);
        int b = intent.getIntExtra("b",0);
        int c = intent.getIntExtra("c",0);
        int d = intent.getIntExtra("d",0);
        int e = intent.getIntExtra("e",0);
        int f = intent.getIntExtra("f",0);



        //setContentView(new Triangulo(ecuacionestriangulo));
        setContentView(new ecuacionestriangulo(triangraficadomostrar.this,a,b,c,d,e,f));

    }
}