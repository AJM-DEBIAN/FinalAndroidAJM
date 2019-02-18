package com.example.alumno.proyectofinal;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Borrar extends AppCompatActivity {
    private EditText borrar;
    dataManager db;
    ListView lista;
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        borrar=(EditText) findViewById(R.id.buscaet1);
        lista=(ListView)findViewById(R.id.lv1);
        bt=(Button)findViewById(R.id.borrar);

    }


    public void buscarFuncion(View v){
        ArrayList<String> data = new ArrayList<>();
        ArrayAdapter adaptador;
        Cursor c;

        db= new dataManager(this);

        c = db.search(borrar.getText().toString());
        if (c.moveToFirst()){
            do {
                data.add(c.getString(0));
            }while(c.moveToNext());
            adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1, data);
            lista.setAdapter(adaptador);

            if (!data.isEmpty()) {
                bt.setEnabled(true);
            }

        }

    }

    public void borrarFuncion(View v){
        db=new dataManager(this);
        db.delete(borrar.getText().toString());
        Toast.makeText(this, "Se ha borrado correctamente", Toast.LENGTH_SHORT).show();
        finish();
    }

}