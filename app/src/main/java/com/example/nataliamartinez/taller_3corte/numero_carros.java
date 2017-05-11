package com.example.nataliamartinez.taller_3corte;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class numero_carros extends AppCompatActivity {

    private ArrayList<Listado_Carros> Carros;
    private TextView numero;
    private int Cont =0;
    private String numerocarros;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numero_carros);

        numero = (TextView)findViewById(R.id.txtNumerodeCarros);
        Carros = Base_Datos.getOpe();
        Cont = Carros.size();

        numerocarros = this.getResources().getString(R.string.numerodecarrosRegistrados)+""+String.valueOf(Cont);
        numero.setText(numerocarros);
    }
}
