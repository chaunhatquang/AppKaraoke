package com.example.tiniha.karaoke;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.tiniha.karaoke.Custom.ItemKaraoke;
import com.example.tiniha.karaoke.Database.SQLDataSource;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    SQLDataSource db;
    List<KaraokeModel> list;
    ListView lvshow;
    ItemKaraoke adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("Home");
        list=new ArrayList<KaraokeModel>();
        db=new SQLDataSource(this);
        list=db.ListSong();
        adapter=new ItemKaraoke(this,R.layout.activity_home,list);
        lvshow.setAdapter(adapter);
    }
}
