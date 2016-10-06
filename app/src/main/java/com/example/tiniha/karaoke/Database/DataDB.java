package com.example.tiniha.karaoke.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;

/**
 * Created by Tini Ha on 10/6/2016.
 */
public class DataDB {
    Connection eventoConexion;
    String name;

    public String getNameDB(Context context){
        eventoConexion = new Connection(context);

        try {
            eventoConexion.createDataBase();
        } catch (IOException e) {
        }

        if(eventoConexion.checkDataBase()){
            eventoConexion.openDataBase();
            SQLiteDatabase db = eventoConexion.getWritableDatabase();
            Cursor cursor = db.rawQuery("SELECT name FROM KARAOKE", null);
            while(cursor.moveToNext()){
                name = cursor.getString(0);
            }

            eventoConexion.close();

            return name;
        }else{
            return "ERROR";
        }
    }
}
