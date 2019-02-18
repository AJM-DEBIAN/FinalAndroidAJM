package com.example.alumno.proyectofinal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by ALUMNO on 15/02/2019.
 */

public class dataManager {
    private SQLiteDatabase db;
    public static final String tableRowTitulo="titulo";
    public static final String tableRowDescripcion="descripcion";
    private static final String dbName="examen";
    private static final int dbVersion=1;
    private static final String tableName="directorio";

    public dataManager(Context context){
        MyCustomSQLiteOpenHelper helper= new MyCustomSQLiteOpenHelper(context);
        db = helper.getWritableDatabase();
    }

    public void insert(String titulo, String descripcion){

        String query = "INSERT INTO "+ tableName+ " ("+tableRowTitulo+","+tableRowDescripcion
                +") VALUES (" + "'"+titulo+"','"+descripcion+"');";

        Log.i("Insert",query);
        db.execSQL(query);

    }

    public void delete(String titulo){
        String queryDelete = "DELETE FROM "+tableName+ " WHERE " + tableRowTitulo+" = "+"'"+titulo+"';";
        Log.i("Delete",queryDelete);
        db.execSQL(queryDelete);
    }

    public Cursor search(String titulo){
        String querySearch = " Select "+tableRowTitulo+" From "+tableName+
                " where "+tableRowTitulo+" = "+"'"+titulo+"';";
        Log.i("Search",querySearch);
        Cursor c = db.rawQuery(querySearch,null);
        return c;
    }

    public Cursor selectAll(){
        String queryAll = " Select * FROM "+ tableName + ";";
        Log.i("ALL",queryAll);
        Cursor c = db.rawQuery(queryAll,null);
        return c;
    }

    private class MyCustomSQLiteOpenHelper extends SQLiteOpenHelper {
        public MyCustomSQLiteOpenHelper(Context context) {
            super(context, dbName, null, dbVersion);
        }
        @Override
        public void onCreate(SQLiteDatabase db){
            String newTableQuery = "Create TABLE "+tableName + " ("
                    + tableRowTitulo + " TEXT NOT NULL, "
                    + tableRowDescripcion + " TEXT NOT NULL);";
            Log.i("DB Creation",newTableQuery);
            Log.i("valores",""+db);
            db.execSQL(newTableQuery);
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

        }

    }
}

