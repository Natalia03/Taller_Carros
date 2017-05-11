package com.example.nataliamartinez.taller_3corte;

import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.StringDef;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class Registar extends AppCompatActivity {
    private EditText placa;
    private EditText precio;
    private Spinner marca, modelo, color;
    private ArrayAdapter mark, modlo, kolor;
    private Resources res;
    private String [] ma,mo,co;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registar);

        res= this.getResources();
        placa= (EditText)findViewById(R.id.txtPlaca);
        precio= (EditText)findViewById(R.id.txtPrecio);
        marca= (Spinner)findViewById(R.id.cmxMarca);
        modelo=(Spinner)findViewById(R.id.cmxModelo);
        color=(Spinner)findViewById(R.id.cmxColor);

        ma = res.getStringArray(R.array.marcas);
        mo =res.getStringArray(R.array.modelos);
        co=res.getStringArray(R.array.color);

        mark = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, ma);
        modlo= new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, mo);
        kolor= new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, co);

        marca.setAdapter(mark);
        modelo.setAdapter(modlo);
        color.setAdapter(kolor);

    }

    public boolean Validad (){

        if(placa.getText().toString().isEmpty()){
            new AlertDialog.Builder(this).setMessage(res.getString(R.string.errorplaca)).show();
            return false;
        }
        if (precio.getText().toString().isEmpty()){
            new AlertDialog.Builder(this).setMessage(res.getString(R.string.errorprecio)).show();
            return false;
        }

        return true;

    }

    public void borrar (View v){ limpiar  ();}

    public void limpiar(){
        placa.setText("");
        precio.setText("");
        placa.requestFocus();
    }

    public void registar(View v){
        String foto="",pl,mar,mod,col,pre;
        pl=placa.getText().toString().trim();
        mar=marca.getSelectedItem().toString();
        mod=modelo.getSelectedItem().toString();
        col=color.getSelectedItem().toString();
        pre=precio.getText().toString().trim();
        foto=String.valueOf(fotos());

        if(Validad()){
            Listado_Carros lisCarros= new Listado_Carros (foto,pl,mar,mod,col,pre);
            lisCarros.Guardar();
            new AlertDialog.Builder(this).setMessage(res.getString(R.string.error)).show();
            limpiar();
        }



    }

    public int fotos(){
        int numero=6;
        int fotos[] = {R.drawable.ford,R.drawable.chevrolet,R.drawable.kia,R.drawable.mazda};
        if(marca.getSelectedItem().toString().equals(getString(R.string.ford))){
            numero=0;
        }
        if(marca.getSelectedItem().toString().trim().equals(getString(R.string.chevrolet))){
            numero=1;
        }
        if(marca.getSelectedItem().toString().trim().equals(getString(R.string.kia))){
            numero=2;
        }
        if(marca.getSelectedItem().toString().trim().equals(getString(R.string.mazda))){
            numero=3;
        }

        return fotos[numero];
    }







}
