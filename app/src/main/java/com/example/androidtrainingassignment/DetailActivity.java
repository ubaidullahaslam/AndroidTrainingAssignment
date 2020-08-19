package com.example.androidtrainingassignment;

import android.content.Intent;
import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        final Intent intent = getIntent();
        String tittle = intent.getStringExtra("tittle");
        String imag = intent.getStringExtra("imag");
        TextView tittleView = findViewById(R.id.title);
        ImageView imageView = findViewById(R.id.img);
        tittleView.setText(tittle);
        Picasso.with(this)
                .load(imag)
                .into(imageView);
         imageView = findViewById(R.id.img);

    }

}
