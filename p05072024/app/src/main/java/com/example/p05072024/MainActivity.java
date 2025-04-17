package com.example.p05072024;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //displays defined layout on screen

        //make size for linearlayout
        LinearLayout.LayoutParams size = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams size1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 10);


        //LinearLayout
        LinearLayout root_layout = new LinearLayout(this); //make linearlayout
        root_layout.setBackgroundColor(Color.YELLOW);
        root_layout.setOrientation(LinearLayout.VERTICAL);

        for (int i=0; i<255; i++){
            //linear layout
            LinearLayout ll1 = new LinearLayout(this); //make linearlayout
            ll1.setBackgroundColor(Color.argb(255,50,i,100));

            //root_layout has a ll1
            root_layout.addView(ll1,size1);
        }

        setContentView(root_layout,size);
    }
}