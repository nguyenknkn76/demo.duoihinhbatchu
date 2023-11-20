package com.example.duoihinhbatchu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.duoihinhbatchu.api.getQuest;
//import com.example.duoihinhbatchu.db.DBHandler;
import com.example.duoihinhbatchu.object.Quest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new getQuest().execute();
    }

    public void playGame(View view) {
        startActivity(new Intent(this, PlayGameActivity.class));
    }
}