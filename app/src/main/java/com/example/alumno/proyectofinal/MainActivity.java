package com.example.alumno.proyectofinal;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;



    public class MainActivity extends AppCompatActivity {
        dataManager db;
        ListView lista1;
        ListView lista2;
        ArrayList<String> data = new ArrayList<>();
        ArrayList<String> data2 = new ArrayList<>();
        ArrayAdapter adaptador;
        ArrayAdapter title;
        ArrayAdapter description;
        Cursor c;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            lista1=(ListView)findViewById(R.id.list1);
            lista2=(ListView)findViewById(R.id.list2);
            db=new dataManager(this);


            fullDatos();

        }
// se esta crando el metodo para llenar las listas
        public void fullDatos(){
            c = db.selectAll();
            if (c.moveToFirst()){
                do {
                    data.add(c.getString(0));
                    data2.add(c.getString(1));
                }while(c.moveToNext());

                title=new ArrayAdapter(this,android.R.layout.simple_list_item_1, data);
                description=new ArrayAdapter(this,android.R.layout.simple_list_item_1, data2);
                lista1.setAdapter(title);
                lista2.setAdapter(description);

            }
        }
        @Override
        public void onResume(){
            super.onResume();
            data.clear();
            data2.clear();
            fullDatos();


        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {

                Intent intent=new Intent(getApplicationContext(),Crear.class);
                Toast.makeText(this, "Guardar", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                return true;
            }

            if (id == R.id.action_settings1) {

                Intent intent=new Intent(getApplicationContext(),Borrar.class);
                Toast.makeText(this, "Borrar", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                return true;
            }



            return super.onOptionsItemSelected(item);
        }
    }


