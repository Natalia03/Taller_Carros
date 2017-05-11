package com.example.nataliamartinez.taller_3corte;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Carro_Economico extends AppCompatActivity {
    private ArrayList<Listado_Carros> Carros;
    private EditText precio;
    private Resources res;
    private TextView Placa, marca, modelo, color, preci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carro__economico);

        Carros = Base_Datos.getOpe();
        precio = (EditText) findViewById(R.id.txtPrecio);
        Placa = (TextView) findViewById(R.id.txtPlacaEconomico);
        marca = (TextView) findViewById(R.id.txtMarcaEconomico);
        modelo = (TextView) findViewById(R.id.txtModeloEconomico);
        color = (TextView) findViewById(R.id.txtColorEconomico);
        preci = (TextView) findViewById(R.id.txtPrecioEconomico);
        CarroEconomico();
    }

    public void CarroEconomico() {

        int x = 999999, z;
        String y;


        if (Carros.size() < 0) {
            //new AlertDialog.Builder(this).setMessage(res.getString(R.string.registrecarro)).show();
        } else {
            for (int i = 0; i < Carros.size(); i++) {
                y = Carros.get(i).getPrecio();
                z = Integer.parseInt(y);
                if (z < x) {
                    x = z;

                    Placa.setText(Carros.get(i).getPlaca());
                    marca.setText(Carros.get(i).getMarca());
                    modelo.setText(Carros.get(i).getModelo());
                    color.setText(Carros.get(i).getColor());
                    preci.setText(Carros.get(i).getPrecio());

                }


            }
        }

    }
}
