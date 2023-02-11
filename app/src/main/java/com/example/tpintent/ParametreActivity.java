package com.example.tpintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ParametreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametre);
        Intent intent = getIntent();
        String loginTxt ="";
        if(intent!=null) {
        if(intent.hasExtra("KEYPARAMETRE")){
            loginTxt=intent.getStringExtra("KEYPARAMETRE");
        }
        TextView typeparametre = (TextView)findViewById(R.id.tv1);
        typeparametre.setText(loginTxt);
        }
    }
}