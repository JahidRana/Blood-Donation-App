package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Organization extends AppCompatActivity {
    TextView one,two,three,four,five;
    LinearLayout container1,container2,container3,container4,container5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization);
        Toolbar toolbar = findViewById(R.id.NonHomeActivity_Toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Organization");
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        five=findViewById(R.id.five);
        four=findViewById(R.id.four);
        container1=findViewById(R.id.container1);
        container2=findViewById(R.id.container2);
        container3=findViewById(R.id.container3);
        container4=findViewById(R.id.container4);
        container5=findViewById(R.id.container5);
        container1.setOnClickListener(view -> {
            String number =one.getText().toString().trim();
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + number));
            startActivity(intent);
            Log.i("CLickedddd","oka");
        });
        container2.setOnClickListener(view -> {
            String number =two.getText().toString().trim();
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + number));
            startActivity(intent);
            Log.i("CLickedddd","oka");
        });
        container3.setOnClickListener(view -> {
            String number =three.getText().toString().trim();
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + number));
            startActivity(intent);
            Log.i("CLickedddd","oka");
        });



    }
    @Override
    public boolean onNavigateUp() {
        onNavigateUp();
        return super.onNavigateUp();
    }

}