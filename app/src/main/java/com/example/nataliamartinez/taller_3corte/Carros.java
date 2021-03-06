package com.example.nataliamartinez.taller_3corte;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Carros extends AppCompatActivity {

    private ListView ls;
    private Resources res;
    private String [] opc;
    private Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carros);

        ls= (ListView)findViewById(R.id.lvCarros);
        res= this.getResources();
        opc=res.getStringArray(R.array.opciones);
        ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, opc);
        ls.setAdapter(adapter);

        //Definir el evento de ListView

        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        i=new Intent(Carros.this,Registar.class);
                        startActivity(i);
                        break;
                    case 1:
                        i=new Intent(Carros.this, Listar.class);
                        startActivity(i);
                        break;
                    case 2:
                        i=new Intent(Carros.this, Reportes.class);
                        startActivity(i);
                        break;
                }
            }
        });

    }

}
