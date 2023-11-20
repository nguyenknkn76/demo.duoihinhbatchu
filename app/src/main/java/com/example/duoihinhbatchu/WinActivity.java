package com.example.duoihinhbatchu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class WinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
    }

    public void tiepTuc(View view) {
//
        Intent intent = new Intent(this, PlayGameActivity.class);
        String okResult = getIntent().getStringExtra("okResult");
        Toast.makeText(this,"cau tra loi dung la" + okResult , Toast.LENGTH_SHORT).show();
        int cauSo = getIntent().getIntExtra("cauSo", 0);
        intent.putExtra("cauSo", cauSo);
        startActivity(intent);
        finish();
//        startActivity(new Intent(this, PlayGameActivity.class));
    }
}