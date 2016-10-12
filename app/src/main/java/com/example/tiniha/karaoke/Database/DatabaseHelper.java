package com.example.tiniha.karaoke.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.system.ErrnoException;
import android.util.Log;

import com.example.tiniha.karaoke.KaraokeModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tini Ha on 10/7/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="kara.sqlite";
    public static final String DBLOCATION = "/data/data/com.example.tiniha.karaoke/databases/";
    private SQLiteDatabase mDatabase;

    Context context;
    String duonganDB="";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
    private void copyDataBase(){
        try {

            InputStream mInputStream = context.getAssets().open(DATABASE_NAME);
            String outFileName = DatabaseHelper.DBLOCATION + DatabaseHelper.DATABASE_NAME;
            OutputStream mOutputStream = new FileOutputStream(outFileName);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = mInputStream.read(buffer)) > 0) {
                mOutputStream.write(buffer, 0, length);
            }
            mOutputStream.flush();
            mOutputStream.close();
            mInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void openDatabase() {
        String dbPath = context.getDatabasePath(DATABASE_NAME).getPath();
        if(mDatabase != null && mDatabase.isOpen()) {
            return;
        }
        mDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void createDatabase(){
        boolean kt=kiemtraDB();
        if (kt){
            Log.d("ket noi","Da co DB");
        }else {
            Log.d("ketnoi","Chua co DB");
            this.getWritableDatabase();
            copyDataBase();
        }
    }

    private boolean kiemtraDB() {
        SQLiteDatabase kiemtraDB=null;

        try{
            kiemtraDB=SQLiteDatabase.openDatabase(duonganDB,null,SQLiteDatabase.OPEN_READONLY);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        if (kiemtraDB !=null){
            kiemtraDB.close();
        }
        return kiemtraDB !=null ? true:false;
    }

    public List<KaraokeModel> getListKara() {
        KaraokeModel kara = null;
        List<KaraokeModel> list = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM KARAOKE_VN", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            kara = new KaraokeModel(cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5));
            list.add(kara);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return list;
    }

    public void closeDatabase() {
        if(mDatabase!=null) {
            mDatabase.close();
        }
    }
}
