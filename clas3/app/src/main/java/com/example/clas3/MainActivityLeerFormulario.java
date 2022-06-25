package com.example.clas3;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityLeerFormulario extends AppCompatActivity {
    Basededatos dataBase;
    SQLiteDatabase db;
    TextView tabla,tabla2,tabla3,tabla4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_leer_formulario);

        tabla = findViewById(R.id.textView18);
        tabla2 = findViewById(R.id.textView19);
        tabla3 = findViewById(R.id.textView20);
        tabla4 = findViewById(R.id.textView21);
        dataBase = new Basededatos(MainActivityLeerFormulario.this,"MIBASES",null,1);
        //recovery rows
        String sql = "SELECT * FROM lugares;";
        db = dataBase.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        String aux ="";
        String aux2 ="";
        String aux3 ="";
        String aux4 ="";
        if(cursor.moveToFirst()){
            do {
                aux += cursor.getString(Integer.parseInt(String.valueOf(cursor.getColumnIndex("nombre"))))+"\n";
                aux2 += cursor.getString(Integer.parseInt(String.valueOf(cursor.getColumnIndex("descripcion"))))+"\n";
                aux3 += cursor.getString(Integer.parseInt(String.valueOf(cursor.getColumnIndex("latitud"))))+"\n";
                aux4 += cursor.getString(Integer.parseInt(String.valueOf(cursor.getColumnIndex("longitud"))))+"\n";


            }while(cursor.moveToNext());

            tabla.setText("NOMBRE\n"+aux);
            tabla2.setText("DESCRIPCION\n"+aux2);
            tabla3.setText("LATITUD\n"+aux3);
            tabla4.setText("LONGITUD\n"+aux4);
            //Toast.makeText(MainActivityLeerFormulario.this, aux, Toast.LENGTH_SHORT).show();
            //db.execSQL("DROP  TABLE lugares;");
        }
    }
}