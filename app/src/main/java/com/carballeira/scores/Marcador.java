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

        ModeloMarcador datos = new ViewModelProvider(this).get(ModeloMarcador.class);
        TextView marcadorA = findViewById(R.id.scoreEquipoA);
        TextView marcadorB = findViewById(R.id.scoreEquipoB);
        marcadorA.setText(String.valueOf(datos.getPuntosA().getValue()));
        marcadorB.setText(String.valueOf(datos.getPuntosB().getValue()));

        final Observer<Integer> observador1 = new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                marcadorA.setText(String.valueOf(datos.getPuntosA().getValue()));
            }
        };

        datos.getPuntosA().observe(this, observador1);

        //TODO hacer lo del observer con los puntos B

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

        unoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO añadir la acción
//                datos.setPuntosB(datos.getPuntosB() + 1);
//                txt_puntosB.setText(String.valueOf(datos.getPuntosB()));
            }
        });

    }
}