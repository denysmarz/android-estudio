package com.example.clas3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.clas3.json.User;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button botonSalir,botonComplejos,botonCalculadora,botonGraficos,botonFormulario,botonWebservice,botonMapa,triangulo,ecuaciontrian;
    ImageView imageView, imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonSalir = findViewById(R.id.button);
        botonComplejos = findViewById(R.id.button2);
        botonCalculadora = findViewById(R.id.button4);
        botonGraficos = findViewById(R.id.button9);
        botonFormulario = findViewById(R.id.button5);
        botonWebservice = findViewById(R.id.button3);
        botonMapa = findViewById(R.id.button7);
        triangulo = findViewById(R.id.button27);
        ecuaciontrian = findViewById(R.id.button28);
        //recovery();
//imagenes
        imageView = findViewById(R.id.imagen_view);
        imageView2 = findViewById(R.id.imagen_view2);
        //Picasso.get().load("https://i.imgur.com/DvpvklR.png").into(imageView);

        //Glide.with(this)
                //.load("https://i.imgur.com/DvpvklR.png")
                //.error(R.drawable.ic_launcher_background)
                //.into(imageView2);
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageReference = storage.getReferenceFromUrl("gs://pruebasis104-35029.appspot.com/imagenes/fondodepantalla.png");
        Glide.with(this)
                .load(storageReference)
                .error(R.drawable.ic_launcher_background)
                .into(imageView);





        botonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        botonComplejos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this,MainActivityComplejo.class);
                intent.putExtra("Cadena" ,"SIS104");
                intent.putExtra("Mientero" , 85 );
                intent.putExtra("MiBooleano",true);
                Operaciones operacion = new Operaciones(1,2,3,4);
                intent.putExtra("MiObjeto",operacion);
                startActivity(intent);
            }
        });

        ecuaciontrian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this,MainActivityecuaciontrian.class);
                startActivity(intent);
            }
        });

        triangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,triangulografico.class);

                intent.putExtra("x" , 8000 );
                intent.putExtra("y" , 10000 );

                startActivity(intent);
            }
        });

        botonCalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this,MainActivityCalculadora.class);
                startActivity(intent);
            }
        });
        botonFormulario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this,MainActivityFormulario.class);
                startActivity(intent);
            }
        });
        botonGraficos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this,MainActivityGraficos.class);
                startActivity(intent);
            }
        });

        botonMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this,MapsActivity.class);
                startActivity(intent);
            }
        });

        botonWebservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this,MainActivityFireBase.class);
                startActivity(intent);
            }
        });
    }
    public void recovery(){

        String URL = "https://jsonplaceholder.typicode.com/";
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        webServiceAPI serviceHubService = retrofit.create(webServiceAPI.class);
        final Call<List<User>> call = serviceHubService.getUsers();

        call.enqueue(new Callback<List<User>>() {

            @Override

            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                if(response.isSuccessful()){

                    List<User> list = response.body();
                    String aux = "";
                    for(User obj:list){
                        aux += obj.getEmail();
                    }
                    Toast.makeText(MainActivity.this,aux,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }
}
