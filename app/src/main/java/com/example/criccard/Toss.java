package com.example.criccard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class Toss extends AppCompatActivity {

    private TextView toss;
    private Button batBtn,bowlBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toss);
        toss = findViewById(R.id.Toss_won_team);
        Random rand = new Random();
        String a = Integer.toString(rand.nextInt(2));
        toss.setText(a);
        batBtn = findViewById(R.id.Bat_btn);
        bowlBtn = findViewById(R.id.Bowl_btn);

        batBtn.setOnClickListener((View view)->{
            Intent intent = new Intent(this,TeamList.class);
            startActivity(intent);
        });

        bowlBtn.setOnClickListener((View view)->{
            String b = Integer.toString(rand.nextInt(2));
            toss.setText(b);
        });
    }
}