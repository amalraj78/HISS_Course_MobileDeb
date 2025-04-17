package com.example.firstapp;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void btclick(View v) { //when button1 is clicked, this method can run, we can insert event in this method
        //link to XML
        TextView tv = (TextView) findViewById(R.id.tv1); //findViewbyID find the ID in activity_main.xml

        //link to button
        Button bt = (Button) findViewById(R.id.butn1);

        bt.setText("Button2");
        tv.setText("Text2");

        //link to webview
        WebView web= (WebView) findViewById(R.id.web);
        web.loadUrl("https://google.com");
    }
}