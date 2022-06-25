package com.example.clas3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class triangulografico extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_graficos);
        Intent intent = getIntent();

        int x = intent.getIntExtra("x",0);
        int y = intent.getIntExtra("y",0);

        if (x>1400){
            Toast.makeText(triangulografico.this,"LA ALTURA SE A REESCALADO ",Toast.LENGTH_SHORT).show();
        }
        while (x>1400){
            x = x/2;
        }


        if (y>900){
            Toast.makeText(triangulografico.this,"LA BASE SE A REESCALADO ",Toast.LENGTH_SHORT).show();
        }
        while (y>900){
            y = y/2;
        }

        //if(x > 1400){
          //  x = x/2;
            //Toast.makeText(triangulografico.this,"TUS DATOS SE REESCALARON ",Toast.LENGTH_SHORT).show();
        //}
        //if(x > 2800){
          //  x = x/3;
            //Toast.makeText(triangulografico.this,"TUS DATOS SE REESCALARON ",Toast.LENGTH_SHORT).show();
        //}
        //if(x > 4200){
          //  x = x/4;
            //Toast.makeText(triangulografico.this,"TUS DATOS SE REESCALARON ",Toast.LENGTH_SHORT).show();
        //}


        setContentView(new Triangulo(triangulografico.this,x,y));
        Toast.makeText(triangulografico.this,"Recuperado X: "+x+" Recuperado Y: "+y,Toast.LENGTH_LONG).show();

    }


}