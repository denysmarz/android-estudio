package com.example.clas3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivityecuaciontrian extends AppCompatActivity {
    Button botonCalcular;
    EditText ed1,ed2,ed3,ed4,ed5,ed6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ecuaciontrian);

        botonCalcular =findViewById(R.id.button29);

        ed1 = findViewById(R.id.editTextTextPersonName6);//a
        ed2 = findViewById(R.id.editTextTextPersonName7);
        ed3 = findViewById(R.id.editTextTextPersonName8);
        ed4 = findViewById(R.id.editTextTextPersonName9);
        ed5 = findViewById(R.id.editTextTextPersonName10);
        ed6 = findViewById(R.id.editTextTextPersonName11);



        botonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int a = Integer.parseInt(ed1.getText().toString());//a
                int b = Integer.parseInt(ed2.getText().toString());
                int c = Integer.parseInt(ed3.getText().toString());
                int d = Integer.parseInt(ed4.getText().toString());
                int e = Integer.parseInt(ed5.getText().toString());
                int f = Integer.parseInt(ed6.getText().toString());


                Intent intent = new Intent( MainActivityecuaciontrian.this,triangraficadomostrar.class);

                intent.putExtra("a" , a );//a
                intent.putExtra("b" , b );
                intent.putExtra("c" , c );
                intent.putExtra("d" , d );
                intent.putExtra("e" , e );
                intent.putExtra("f" , f );

                startActivity(intent);
            }
        });
    }
}