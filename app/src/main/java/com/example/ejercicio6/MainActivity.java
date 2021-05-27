package com.example.ejercicio6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText etNombre;
EditText etGoles;
Button Benviar;
Button bRecuperar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre= findViewById(R.id.etNombre);
        etGoles= findViewById(R.id.etGoles);
        Benviar= findViewById(R.id.Benviar);
        bRecuperar= findViewById(R.id.bRecuperar);

        SharedPreferences nombre =getSharedPreferences("goleador", Context.MODE_PRIVATE);
        SharedPreferences goles =getSharedPreferences("goles", Context.MODE_PRIVATE);
        etNombre.setText(nombre.getString("goleador",""));
        etGoles.setText(goles.getString("goles",""));
    }
public void Enviar(View view){

        String nombre=etNombre.getText().toString();
        String goles=etGoles.getText().toString();
        SharedPreferences guardar=getSharedPreferences("goleador", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=guardar.edit();
        editor.putString(nombre, goles);
        editor.commit();
        Toast.makeText(this,"guardado", Toast.LENGTH_LONG).show();
    }

public void Recuperar(View view){
    SharedPreferences recuperar=getSharedPreferences("goles",Context.MODE_PRIVATE);
    SharedPreferences.Editor editor=recuperar.edit();
    editor.putString("goles", etGoles.getText().toString());
    editor.commit();
    finish();
}

}