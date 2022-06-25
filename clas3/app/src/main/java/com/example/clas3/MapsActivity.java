package com.example.clas3;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.clas3.json.Geo;
import com.example.clas3.json.User;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.clas3.databinding.ActivityMapsBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    Basededatos dataBase;
    SQLiteDatabase db;

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    FirebaseFirestore db2 = FirebaseFirestore.getInstance();

    public static final String TAG= "Mifirebase";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */


    @Override
    public void onMapReady(GoogleMap googleMap) {
        String URL = "https://jsonplaceholder.typicode.com/";
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        webServiceAPI serviceHubService = retrofit.create(webServiceAPI.class);
        final Call<List<User>> call = serviceHubService.getUsers();

        call.enqueue(new Callback<List<User>>() {

            @Override

            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                mMap = googleMap;
                //mostrar WEB SERVICE
                if(response.isSuccessful()){

                    List<User> list = response.body();

                   int b = 1;
                    for(User obj:list){

                        String aux = obj.getAddress().getGeo().getLat();
                        String aux2 = obj.getAddress().getGeo().getLng();
                        double converlati = Double.parseDouble(aux);
                        double converlongi = Double.parseDouble(aux2);
                        LatLng sydney = new LatLng(converlati, converlongi);
                        mMap.addMarker(new MarkerOptions().position(sydney).title("Ubicacion WEB SERVICE "+b));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                        b++;
                    }
                }

                //mostrar datos de SQL
                String sqldatoslat = sqllat();
                String sqldatoslon = sqllon();
                String [] sqllat = sqldatoslat.split(" ");
                String [] sqllon = sqldatoslon.split(" ");
                Double [] lati2= new Double[20] ;
                Double [] logi2= new Double[20] ;
                for (int i = 0;i<sqllat.length;i++){
                    lati2[i]=Double.parseDouble( sqllat[i]);
                    logi2[i]=Double.parseDouble( sqllon[i]);
                    LatLng sql = new LatLng(lati2[i], logi2[i]);
                    mMap.addMarker(new MarkerOptions().position(sql).title("Ubicacion SQL "+(i+1)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(sql));
                }


                //mostrar FIRE BASE
                db2.collection("lugares")
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                                if (task.isSuccessful()) {
                                    int a =1;
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        Log.d(TAG, document.getId() + " => " + document.getData());
                                        String fireba = String.valueOf(document.getData());
                                        String [] firebase2 = fireba.split(",");
                                        String [] latitud = firebase2[1].split("=");
                                        String [] longitud = firebase2[2].split("=");
                                        double convercionlati = Double.parseDouble(latitud[1]);
                                        double convercionlongi = Double.parseDouble(longitud[1]);

                                        LatLng firebase = new LatLng(convercionlati, convercionlongi);
                                        mMap.addMarker(new MarkerOptions().position(firebase).title("Ubicacion FIREBASE "+(a)));
                                        mMap.moveCamera(CameraUpdateFactory.newLatLng(firebase));
                                        a++;
                                    }
                                } else {
                                    Log.w(TAG, "Error getting documents.", task.getException());
                                }
                            }
                        });

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }

    public String sqllat(){
        dataBase = new Basededatos(MapsActivity.this,"MIBASES",null,1);
        String sql = "SELECT * FROM lugares;";
        db = dataBase.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        String aux3 ="";
        if(cursor.moveToFirst()){
            do {
                aux3 += cursor.getString(Integer.parseInt(String.valueOf(cursor.getColumnIndex("latitud"))))+" ";
            }while(cursor.moveToNext());
        }
        return aux3;
    }
    public String sqllon(){
        dataBase = new Basededatos(MapsActivity.this,"MIBASES",null,1);
        String sql = "SELECT * FROM lugares;";
        db = dataBase.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        String aux3 ="";
        if(cursor.moveToFirst()){
            do {
                aux3 += cursor.getString(Integer.parseInt(String.valueOf(cursor.getColumnIndex("longitud"))))+" ";
            }while(cursor.moveToNext());
        }
        return aux3;
    }

}