package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2;
    Button miboton, miboton2,miboton3,miboton4;
    TextView LabelResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.editTextTextPersonName1);
        ed2 = findViewById(R.id.editTextTextPersonName2);
        miboton = findViewById(R.id.button);
        miboton2 = findViewById(R.id.button2);
        miboton3 = findViewById(R.id.button3);
        miboton4 = findViewById(R.id.button4);

        LabelResultado = findViewById(R.id.textView);

        miboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(ed1.getText().toString());
                int y = Integer.parseInt(ed2.getText().toString());

               operaciones operaciones = new operaciones(x,y);
                LabelResultado.setText(String.valueOf(operaciones.suma()));
                //LabelResultado.setText(String.valueOf("12"));
            }
        });

        miboton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(ed1.getText().toString());
                int y = Integer.parseInt(ed2.getText().toString());

                operaciones operaciones = new operaciones(x,y);
                LabelResultado.setText(String.valueOf(operaciones.resta()));
                //LabelResultado.setText(String.valueOf("12"));
            }
        });

        miboton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(ed1.getText().toString());
                int y = Integer.parseInt(ed2.getText().toString());

                operaciones operaciones = new operaciones(x,y);
                LabelResultado.setText(String.valueOf(operaciones.multiplicar()));
                //LabelResultado.setText(String.valueOf("12"));
            }
        });

        miboton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(ed1.getText().toString());
                int y = Integer.parseInt(ed2.getText().toString());

                operaciones operaciones = new operaciones(x,y);
                LabelResultado.setText(String.valueOf(operaciones.dividir()));
                //LabelResultado.setText(String.valueOf("12"));
            }
        });
    }
}