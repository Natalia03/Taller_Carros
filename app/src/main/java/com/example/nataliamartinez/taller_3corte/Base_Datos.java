package com.example.nataliamartinez.taller_3corte;

import java.util.ArrayList;

/**
 * Created by NATALIA MARTINEZ on 6/05/2017.
 */

public class Base_Datos {
    private static ArrayList<Listado_Carros> ope = new ArrayList<>();

    public static void GuardarCambio (Listado_Carros opciones){

        ope.add(opciones);
    }

    public static ArrayList<Listado_Carros>  getOpe(){
        return ope;
    }
}
