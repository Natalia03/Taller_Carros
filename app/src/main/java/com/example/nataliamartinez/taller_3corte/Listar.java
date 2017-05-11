package com.example.nataliamartinez.taller_3corte;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Listar extends AppCompatActivity {
    private ListView listar;
    private ArrayList<Listado_Carros> Carros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);


        listar= (ListView)findViewById(R.id.lvListarC);
        Carros= Base_Datos.getOpe();   //personas que van registrado hasta el momento, las personas estan guardadas en datos.

        Adaptador adapter = new Adaptador(this,Carros); //nuestro propio adaptador
        listar.setAdapter(adapter);
    }
}
