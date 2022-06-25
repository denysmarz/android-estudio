package com.example.clas3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivityCalculadora extends AppCompatActivity {
    EditText edit1,concatenar;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,suma,resta,multiplicacion,division,igual,borrar;
    int resultado;int num1 = 0;int num2=0;int num3=0;int num4=0;
    String operador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OperacionesCal  op= new OperacionesCal(10);
        setContentView(R.layout.activity_main_calculadora);

        edit1 = findViewById(R.id.editTextTextPersonName5);

        b1 = findViewById(R.id.button12);
        b2 = findViewById(R.id.button13);
        b3 = findViewById(R.id.button14);
        b4 = findViewById(R.id.button15);
        b5 = findViewById(R.id.button16);
        b6 = findViewById(R.id.button17);
        b7 = findViewById(R.id.button18);
        b8 = findViewById(R.id.button19);
        b9 = findViewById(R.id.button20);
        b0 = findViewById(R.id.button21);


        suma = findViewById(R.id.button22);
        resta = findViewById(R.id.button23);
        multiplicacion = findViewById(R.id.button24);
        division = findViewById(R.id.button25);
        igual = findViewById(R.id.button26);
        borrar = findViewById(R.id.button30);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                concatenar = findViewById(R.id.editTextTextPersonName5);
                edit1.setText(concatenar.getText().toString() + "1");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                concatenar = findViewById(R.id.editTextTextPersonName5);
                edit1.setText(concatenar.getText().toString() + "2");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                concatenar = findViewById(R.id.editTextTextPersonName5);
                edit1.setText(concatenar.getText().toString() + "3");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                concatenar = findViewById(R.id.editTextTextPersonName5);
                edit1.setText(concatenar.getText().toString() + "4");
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                concatenar = findViewById(R.id.editTextTextPersonName5);
                edit1.setText(concatenar.getText().toString() + "5");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                concatenar = findViewById(R.id.editTextTextPersonName5);
                edit1.setText(concatenar.getText().toString() + "6");
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                concatenar = findViewById(R.id.editTextTextPersonName5);
                edit1.setText(concatenar.getText().toString() + "7");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                concatenar = findViewById(R.id.editTextTextPersonName5);
                edit1.setText(concatenar.getText().toString() + "8");
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                concatenar = findViewById(R.id.editTextTextPersonName5);
                edit1.setText(concatenar.getText().toString() + "9");
            }
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                concatenar = findViewById(R.id.editTextTextPersonName5);
                edit1.setText(concatenar.getText().toString() + "0");
            }
        });

        suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operador = "+";
                concatenar = findViewById(R.id.editTextTextPersonName5);
                num1 = Integer.parseInt(concatenar.getText().toString());

                op.Agregar(String.valueOf(num1));
                op.Agregar(operador);
                edit1.setText("");
            }
        });

        resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //op.Mostrar();
                operador = "-";
                concatenar = findViewById(R.id.editTextTextPersonName5);
                num1 = Integer.parseInt(concatenar.getText().toString());
                op.Agregar(String.valueOf(num1));
                op.Agregar(operador);
                edit1.setText("");
            }
        });

        multiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operador = "*";
                concatenar = findViewById(R.id.editTextTextPersonName5);
                num1 = Integer.parseInt(concatenar.getText().toString());

                op.Agregar(String.valueOf(num1));
                op.Agregar(operador);

                edit1.setText("");
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operador = "/";
                concatenar = findViewById(R.id.editTextTextPersonName5);
                num1 = Integer.parseInt(concatenar.getText().toString());
                op.Agregar(String.valueOf(num1));
                op.Agregar(operador);

                edit1.setText("");
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                concatenar = findViewById(R.id.editTextTextPersonName5);
                if(!concatenar.getText().toString().equals("")){
                    num1 = Integer.parseInt(concatenar.getText().toString());
                    op.Agregar(String.valueOf(num1));
                }
                edit1.setText("");
                op.Mostrar();
               edit1.setText(String.valueOf(op.Calcular()));
               op.Eliminar();
            }
        });

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit1.setText("");
                op.Eliminar();

            }
        });

    }
}