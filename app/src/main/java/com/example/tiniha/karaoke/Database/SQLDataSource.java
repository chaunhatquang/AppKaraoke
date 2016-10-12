package com.example.tiniha.karaoke.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tiniha.karaoke.KaraokeModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tini Ha on 10/7/2016.
 */
public class SQLDataSource  {
    SQLiteDatabase db;
    DatabaseHelper helper;
    public  SQLDataSource(Context context){
        helper=new DatabaseHelper(context);
        helper.createDatabase();
        helper.openDatabase();
    }

    public List<KaraokeModel> ListSong() {
        List<KaraokeModel> list = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM KARAOKE_VN",null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            KaraokeModel item = new KaraokeModel(c.getString(0),c.getString(3),c.getString(5),c.getString(6));
            list.add(item);
            c.moveToNext();
        }
        return list;
    }
}
