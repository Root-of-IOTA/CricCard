package com.example.criccard;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private final int CONFIRMRESULT = 99;
    private Button editBtn,confirmBtn;


    ActivityResultLauncher<Intent> confirmationEnabler = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode()==CONFIRMRESULT){
                        Intent res = result.getData();
                        if(res != null) {

                        if(res.getBooleanExtra("Confirmation",true)){
                            confirmBtn.setEnabled(true);
                        }
                        }
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        confirmBtn = findViewById(R.id.confirm_btn);
        editBtn = findViewById(R.id.edit_btn);
        confirmBtn.setEnabled(false);
        editBtn.setOnClickListener((View view)->{
            Intent intent = new Intent(this,Toss.class);
            startActivity(intent);
        });

    }
}