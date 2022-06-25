package com.example.examenparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivitypregunta1 extends AppCompatActivity {
    TextView LabelResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pregunta1);

        LabelResultado = findViewById(R.id.textView2);

        Intent intent = getIntent();

        int x = intent.getIntExtra("x",0);

    }

}