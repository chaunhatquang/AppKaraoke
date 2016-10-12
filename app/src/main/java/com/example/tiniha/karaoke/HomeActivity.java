package com.example.tiniha.karaoke;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tiniha.karaoke.Custom.ItemKaraoke;
import com.example.tiniha.karaoke.Database.DatabaseHelper;
import com.example.tiniha.karaoke.Database.SQLDataSource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

//    SQLDataSource db;
//    List<KaraokeModel> list;
//    ListView lvshow;
    ItemKaraoke adapter;

    private ListView lvKara;
    private ArrayAdapter adapterKara = null;
    private List<KaraokeModel> mlist;
    List<String> list;
    DatabaseHelper mDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("Home");

        //        list = new ArrayList<KaraokeModel>();
//        db = new SQLDataSource(this);
//        list = db.ListSong();
//        adapter = new ItemKaraoke(this,R.layout.activity_home,list);
//        lvshow.setAdapter(adapter);

        // Find id list View
        lvKara = (ListView) findViewById(R.id.lv_content);
        list = new ArrayList<String>();
        mDBHelper = new DatabaseHelper(this);

        File database = getApplicationContext().getDatabasePath(DatabaseHelper.DATABASE_NAME);
        if(database.exists() == false) {
            mDBHelper.getReadableDatabase();
            //Copy db
            if(copyDatabase(this)) {
                Toast.makeText(this, "Copy database succes", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Copy data error", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        mlist = mDBHelper.getListKara();
        Toast.makeText(this, "Size kara " + mlist.size(), Toast.LENGTH_SHORT).show();

//        adapter = new ItemKaraoke(this,R.layout.activity_home,mlist);
//        lvKara.setAdapter(adapter);
    }
    private boolean copyDatabase(Context context) {
        try {

            InputStream inputStream = context.getAssets().open(DatabaseHelper.DATABASE_NAME);
            String outFileName = DatabaseHelper.DBLOCATION + DatabaseHelper.DATABASE_NAME;
            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[]buff = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buff)) > 0) {
                outputStream.write(buff, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            Log.w("MainActivity","DB copied");
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
