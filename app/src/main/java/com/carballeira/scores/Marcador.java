package com.carballeira.scores;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class Marcador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_marcador);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //LiveData

        Button unoA = findViewById(R.id.sumaUnoA);
        Button unoB = findViewById(R.id.sumaUnoB);
        Button dosA = findViewById(R.id.sumaDosA);
        Button dosB = findViewById(R.id.sumaDosB);
        Button tresA = findViewById(R.id.sumaTresA);
        Button tresB = findViewById(R.id.sumaTresB);

        //Datos del ViewModel
        ModeloMarcador datos = new ViewModelProvider(this).get(ModeloMarcador.class);
        TextView marcadorA = findViewById(R.id.scoreEquipoA);
        TextView marcadorB = findViewById(R.id.scoreEquipoB);
        marcadorA.setText(String.valueOf(datos.getPuntosA().getValue()));
        marcadorB.setText(String.valueOf(datos.getPuntosB().getValue()));

        //Obervador con el mismo tipo de datos que en el Mutable
        //Un obervador por cada dato a modificar
        final Observer<Integer> observador1 = new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                marcadorA.setText(String.valueOf(datos.getPuntosA().getValue()));
            }
        };
        //Se asigna el pbervador a los datos
        datos.getPuntosA().observe(this, observador1);

        final Observer<Integer> observador2 = new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                marcadorB.setText(String.valueOf(datos.getPuntosB().getValue()));
            }
        };

        datos.getPuntosB().observe(this, observador2);

        unoA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int marcadorActual = datos.getPuntosA().getValue();
                datos.setPuntosA(marcadorActual + 1);
                //sin live data
//                datos.setPuntosA(datos.getPuntosA() + 1);
//                txt_puntosA.setText(String.valueOf(datos.getPuntosA()));
            }
        });

        dosA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int marcadorActual = datos.getPuntosA().getValue();
                datos.setPuntosA(marcadorActual + 2);
            }
        });

        tresA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int marcadorActual = datos.getPuntosA().getValue();
                datos.setPuntosA(marcadorActual + 3);
            }
        });

        unoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int marcadorActual = datos.getPuntosB().getValue();
                datos.setPuntosB(marcadorActual + 1);
//                datos.setPuntosB(datos.getPuntosB() + 1);
//                txt_puntosB.setText(String.valueOf(datos.getPuntosB()));
            }
        });

        dosB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int marcadorActual = datos.getPuntosB().getValue();
                datos.setPuntosB(marcadorActual + 2);
            }
        });

        tresB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int marcadorActual = datos.getPuntosB().getValue();
                datos.setPuntosB(marcadorActual + 3);
            }
        });
    }
}