package com.example.midtermexam_12072024;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
// setContentView(R.layout.activity_main);

// size for parent lienarlayout
        LinearLayout.LayoutParams linearsize0 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        // size for children linearlayout
        LinearLayout.LayoutParams linearsize = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        // size for textview
        LinearLayout.LayoutParams size = new LinearLayout.LayoutParams(200,200); // default px scale
        size.setMargins(5,5,5,5);

// define parent linearlayout
        LinearLayout ll0 = new LinearLayout(this);
        ll0.setOrientation(LinearLayout.VERTICAL);
        ll0.setGravity(Gravity.CENTER);

        //define child linearlayout array
        LinearLayout[] ll_child = new LinearLayout[4];

        //define child textview array

        for(int j=0; j<4; j++) { // for each row(linearlayout)
            ll_child[j] = new LinearLayout(this);
            ll_child[j].setOrientation(LinearLayout.HORIZONTAL);
            ll_child[j].setGravity(Gravity.CENTER);


//ViewGroup.LayoutParams textsize1 = new ViewGroup.LayoutParams(50,50); // for just text
            for (int i = 0; i < 4; i++) { // for each column(TextView)
                TextView tv2 = new TextView(this);
                tv2.setTextSize(50f); // default unit is "sp"
                tv2.setText((i + 1)+3*j + "");
                tv2.setTextColor(Color.BLACK);
                tv2.setBackgroundColor(Color.parseColor("#FF9800"));
                tv2.setGravity(Gravity.CENTER);
                ll_child[j].addView(tv2, size);
                //ll1.addView(tv2, size);
            }
            ll0.addView(ll_child[j], linearsize);
            //ll0.addView(ll_child[j], linearsize);
        }
        setContentView(ll0, linearsize0); // possible to use -> ll0.setLayoutParams(linearsize0); setContentView(ll0);
    }
}