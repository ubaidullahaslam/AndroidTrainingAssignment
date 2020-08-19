package com.example.androidtrainingassignment;

import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView list = findViewById(R.id.list_view);
        CustomAdapter customAdapter = new CustomAdapter(this, DAO.getData());
        list.setAdapter(customAdapter);
    }
}
