package com.example.alumno.proyectofinal;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Crear extends AppCompatActivity {

    private EditText titulo;
    private EditText descripcion;
    private Button guardarBtn;
    dataManager db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("oncreate","oncreate");


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        db=new dataManager(this);
        titulo=(EditText)findViewById(R.id.titulo);
        descripcion=(EditText)findViewById(R.id.descripcion);
        guardarBtn=(Button)findViewById(R.id.btnGuardar);

    }


    public void guardar(View v){




        db.insert(titulo.getText().toString(),descripcion.getText().toString());
        Toast.makeText(this, "Se Guardo Correctamente", Toast.LENGTH_SHORT).show();
        titulo.setText("");
        descripcion.setText("");

    }

}
