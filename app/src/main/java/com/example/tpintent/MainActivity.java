package com.example.tpintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.input);
        ((Button)findViewById(R.id.intentxplicite)).setOnClickListener(this);
        ((Button)findViewById(R.id.intentxpliciteavectransmissiondedonne)).setOnClickListener(this);
        ((Button)findViewById(R.id.google)).setOnClickListener(this);
        ((Button)findViewById(R.id.parametresapplications)).setOnClickListener(this);
        ((Button)findViewById(R.id.appletelephonique)).setOnClickListener(this);
        ((Button)findViewById(R.id.envoiemail)).setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        Intent intent;
        switch(view.getId()){
            case R.id.intentxplicite:
                intent=new Intent(MainActivity.this,HomeAcitivity.class);
                startActivity(intent);
                break;
            case R.id.intentxpliciteavectransmissiondedonne:
                intent=new Intent(MainActivity.this,ParametreActivity.class);
                intent.putExtra("KEYPARAMETRE",editText.getText().toString());
                startActivity(intent);
                break;
            case R.id.google:
                intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.com"));
                startActivity(intent);
                break;
            case R.id.parametresapplications:
                intent = new Intent(Settings.ACTION_APPLICATION_SETTINGS);
                startActivity(intent);
            case R.id.appletelephonique:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:*101#"));
                if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                    !=PackageManager.PERMISSION_GRANTED){
                    return;
                }
                startActivity(intent);
                break;
            case R.id.envoiemail:
                intent = new Intent (Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"user@gmail.com","test@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT,"Reclamation client");
                intent.putExtra(Intent.EXTRA_TEXT,"réclmation client concernatn la clé 10");
                startActivity(Intent.createChooser(intent,"send"));
            default:break;
        }

    }
}