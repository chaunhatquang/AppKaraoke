package com.example.tiniha.karaoke.Custom;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.tiniha.karaoke.KaraokeModel;
import com.example.tiniha.karaoke.R;

import java.util.List;

/**
 * Created by Me on 10/6/2016.
 */

public class ItemKaraoke extends ArrayAdapter<KaraokeModel> {
    Context context;
    int resource;
    List<KaraokeModel> objects;
    ImageButton btnfavorite;
    boolean isLike;

    public  ItemKaraoke(Context context, int resource,List<KaraokeModel> objects){
        super(context,resource,objects);

        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=View.inflate(context,resource,null);
        TextView tvid=(TextView) view.findViewById(R.id.txtCode);
        TextView tvsongname=(TextView) view.findViewById(R.id.txtSongName);
        TextView tvcomposer=(TextView) view.findViewById(R.id.txtComposer);
        TextView tvlyric=(TextView) view.findViewById(R.id.txtlyric);


        KaraokeModel item=objects.get(position);
        tvid.setText(item.get_code());
        tvsongname.setText(item.get_name_vn().toString());
        tvcomposer.setText(item.getAnthor_info().toString());
        tvlyric.setText(item.getLyric_vn().toString());

        isLike = false;


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

        return super.getView(position, convertView, parent);
    }







}
