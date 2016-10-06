package com.example.tiniha.karaoke;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        Button btnfacebook=(Button)findViewById(R.id.btnfacebook);
        Button btngmail=(Button)findViewById(R.id.btngmail);

        final Intent intent=new Intent(MainActivity.this, HomeActivity.class);
        btnfacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
        final Intent intent1=new Intent(MainActivity.this, HomeActivity.class);
        btngmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent1);
            }
        });
    }
}
