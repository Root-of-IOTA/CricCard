package com.example.criccard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import java.util.Random;

public class Toss extends AppCompatActivity {

    private TextView toss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toss);
        toss = findViewById(R.id.Toss_won_team);
        Random rand = new Random();
        String a = Integer.toString(rand.nextInt(2));
        toss.setText(a);
    }
}