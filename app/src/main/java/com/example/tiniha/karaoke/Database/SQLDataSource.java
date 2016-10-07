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
        db= helper.openDatabase();
    }

    public List<KaraokeModel> ListSong() {
        List<KaraokeModel> list = new ArrayList<KaraokeModel>();
        String[] column = {DatabaseHelper.ROWID, DatabaseHelper.NAME_VN, DatabaseHelper.AUTHOR_INFO, DatabaseHelper.LYRIC_VN};
        Cursor c = db.query(DatabaseHelper.TABLE_SONG, column, null, null, null, null,null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            KaraokeModel item=new KaraokeModel();
            item.set_code(c.getInt(0));
            item.set_name_vn(c.getString(1));
            item.setAnthor_info(c.getString(2));
            item.setLyric_vn(c.getString(3));


            list.add(item);
            c.moveToNext();
        }
        return list;
    }
}
