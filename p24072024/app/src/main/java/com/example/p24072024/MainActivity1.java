package com.example.p24072024;


import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceBundle){
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.activity_main1);

        TextView tv1 = (TextView) findViewById(R.id.tv1);

        //receive message from MainActiity
        Intent intent = getIntent();
        String recv = intent.getStringExtra("sendmessage1");
        tv1.setText(recv);
    }
}
