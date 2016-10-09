package com.example.tiniha.karaoke.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.system.ErrnoException;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Tini Ha on 10/7/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="V49.sqlite";
    public static final String TABLE_SONG="KARAOKE";
    public static final String ROWID="ROWID";
    public static final String CODE="CODE";
    public static final String SHORTNAME="SHORTNAME";
    public static final String NAME="NAME";
    public static final String NAME_VN="NAME_VN";
    public static final String LYRIC="LYRIC";
    public static final String LYRIC_VN="LYRIC_VN";
    public static final String AUTHOR_INFO="AUTHOR_INFO";

    Context context;
    String duonganDB="";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context=context;
        Log.e("Check dir","dir: "+context.getFilesDir()+" vs "+ Environment.getExternalStorageDirectory().getAbsolutePath());
        duonganDB= Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator+DATABASE_NAME;
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
            String outFileName = duonganDB + DATABASE_NAME;
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
    public SQLiteDatabase openDatabase(){
        return SQLiteDatabase.openDatabase(duonganDB,null,SQLiteDatabase.OPEN_READWRITE);
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

}
