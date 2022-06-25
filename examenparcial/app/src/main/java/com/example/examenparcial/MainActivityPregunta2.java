package com.example.examenparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivityPregunta2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pregunta2);

        Intent intent = getIntent();

        int x = intent.getIntExtra("x",0);
        int y = intent.getIntExtra("y",0);

        //ESCALADO DE X
        if (x>1400 || x<100){
            Toast.makeText(MainActivityPregunta2.this,"LA ALTURA SE A REESCALADO ",Toast.LENGTH_SHORT).show();
        }
        //while (x<50){
          //  x = x*2;
        //}
        while (x>1400){
            x = x/2;
        }

        //ESCALADO DE Y
        if (y>900 || y<100){
            Toast.makeText(MainActivityPregunta2.this,"LA BASE SE A REESCALADO ",Toast.LENGTH_SHORT).show();
        }
        //while (y<50){
          //  y = y*2;
        //}
        while (y>1000){
            y = y/2;
        }

        setContentView(new Rectangulo(MainActivityPregunta2.this,x,y));
        Toast.makeText(MainActivityPregunta2.this,"Recuperado X: "+x+" Recuperado Y: "+y,Toast.LENGTH_LONG).show();
    }
}