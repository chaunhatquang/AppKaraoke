package com.example.tiniha.karaoke.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Tini Ha on 10/7/2016.
 */
public class SQLDataSource  {
    SQLiteDatabase db;
    DatabaseHelper helper;
    public  SQLDataSource(Context context){
        helper=new DatabaseHelper(context);
        helper.createDatabase();
    }
}
