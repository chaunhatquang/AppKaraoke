package com.example.tiniha.karaoke;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Me on 10/6/2016.
 */

public class ItemKaraoke extends AppCompatActivity {
    ImageButton btnfavorite;
    boolean isLike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_karaoke);

        isLike = false;

        btnfavorite = (ImageButton) findViewById(R.id.btnfavorite);
        btnfavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isLike) {
                    btnfavorite.setImageResource(R.drawable.star_yellow);

                } else {
                    btnfavorite.setImageResource(R.drawable.star_white);
                }
                isLike = !isLike;
            }
        });
        // btnfavorite.setBackgroundColor(Color.YELLOW);

    }
}
