package com.example.examenparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button pregunta1,pregunta2,pregunta3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pregunta1 =findViewById(R.id.button);
        pregunta2 = findViewById(R.id.button2);
        pregunta3 = findViewById(R.id.button3);

        pregunta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent( MainActivity.this,MainActivitypregunta1.class);
                intent.putExtra("x" , 60 );
                startActivity(intent);
            }
        });

        pregunta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivityPregunta2.class);

                //Y ES LA BASE       X ES LA ALTURA
                intent.putExtra("x" , 60 );
                intent.putExtra("y" , 10000 );

                startActivity(intent);

            }
        });

        pregunta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this,MainActivityPregunta3.class);
                startActivity(intent);
            }
        });

    }
}