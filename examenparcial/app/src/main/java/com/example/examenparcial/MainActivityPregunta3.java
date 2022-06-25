package com.example.examenparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivityPregunta3 extends AppCompatActivity {
    TextView LabelResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pregunta3);

        LabelResultado = findViewById(R.id.textView);

        recovery();
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

                if (response.isSuccessful()) {

                    List<User> list = response.body();
                    String aux = "";
                    int x =0;
                    for (User obj : list) {
                        if(x<3){
                            aux +="TITULO: "+obj.getTitle()+"\n"+"ID: "+obj.getId()+"\n\n\n\n";
                        }
                        x++;
                    }
                    LabelResultado.setText(aux);
                }

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });

    }

}