package com.example.nataliamartinez.taller_3corte;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by NATALIA MARTINEZ on 6/05/2017.
 */

public class Adaptador extends BaseAdapter{
    private Context contexto;
    private ArrayList<Listado_Carros> Carros;

    public Adaptador(Context contexto, ArrayList<Listado_Carros> Carros) {
        this.contexto = contexto;
        this.Carros = Carros;
    }

    @Override
    public int getCount() {
        return Carros.size();
    }

    @Override
    public Object getItem(int position) {
        return Carros.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        //Declarar variables
        TextView placa,marca,modelo,precio;
        ImageView foto;
        LayoutInflater inflater; //prmite modificar las formas como por defectos se hacen las cosas.
        View itemView; //las listas que va a retornar por cada elemento.

        //Uso del Inflate

        //Primero se crea
        inflater = (LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //DAme perimiso para modificar la informacion
        itemView = inflater.inflate(R.layout.item_carros,null);

        //Captura de los objetos
        placa=(TextView)itemView.findViewById(R.id.txtPlacaCarros);
        marca=(TextView)itemView.findViewById(R.id.txtMarcaCarros);
        modelo=(TextView)itemView.findViewById(R.id.txtModeloCarro);
        precio=(TextView)itemView.findViewById(R.id.txtPrecioCarro);
        foto=(ImageView)itemView.findViewById(R.id.imgFoto);

        //pasar la informacion

        placa.setText(Carros.get(position).getPlaca());
        marca.setText(Carros.get(position).getMarca());
        modelo.setText(Carros.get(position).getModelo());
        precio.setText(Carros.get(position).getPrecio());
        foto.setImageResource(Integer.parseInt(Carros.get(position).getFoto()));

        //retornar itemview

        return itemView;

    }
}