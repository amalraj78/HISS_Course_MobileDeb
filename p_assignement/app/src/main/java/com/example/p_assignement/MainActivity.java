package com.example.p_assignement;

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

        // LinearLayout-----------------------------------
        LinearLayout row1 = new LinearLayout(this);
        row1.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams row1_size = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        row1.setLayoutParams(row1_size);   // assign size
        //------------------------------------------------

        // TextView-------------------------------------
        // make size instance
        LinearLayout.LayoutParams tv_size = new LinearLayout.LayoutParams(200, 200);
        tv_size.setMargins(10, 10, 10, 10);

        for (int i = 0; i < 3; i++) {
            TextView tv1 = new TextView(this);
            tv1.setTextSize(50);
            tv1.setTextColor(Color.parseColor("#000000"));
            tv1.setBackgroundColor(Color.parseColor("#FF9800"));
            tv1.setGravity(Gravity.CENTER);
            tv1.setText((i + 1) + "");

            // assign size
            tv1.setLayoutParams(tv_size);
            //------------------------------------------------

            // Linearlayout row1 can have three textviews
            row1.addView(tv1);
        }


        // LinearLayout-----------------------------------
        LinearLayout row2 = new LinearLayout(this);
        row2.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams row2_size = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        row2.setLayoutParams(row2_size);   // assign size
        //------------------------------------------------

        // TextView-------------------------------------
        // make size instance
        for (int i = 0; i < 3; i++) {
            TextView tv1 = new TextView(this);
            tv1.setTextSize(50);
            tv1.setTextColor(Color.parseColor("#000000"));
            tv1.setBackgroundColor(Color.parseColor("#FF9800"));
            tv1.setGravity(Gravity.CENTER);
            tv1.setText((i + 1 + 3) + "");

            // assign size
            tv1.setLayoutParams(tv_size);
            //------------------------------------------------

            // Linearlayout row1 can have three textviews
            row2.addView(tv1);
        }

        LinearLayout row3 = new LinearLayout(this);
        row3.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams row3_size = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        row3.setLayoutParams(row3_size);   // assign size
        //------------------------------------------------

        // TextView-------------------------------------
        // make size instance
        for (int i = 0; i < 3; i++) {
            TextView tv1 = new TextView(this);
            tv1.setTextSize(50);
            tv1.setTextColor(Color.parseColor("#000000"));
            tv1.setBackgroundColor(Color.parseColor("#FF9800"));
            tv1.setGravity(Gravity.CENTER);
            tv1.setText((i + 1 + 6) + "");

            // assign size
            tv1.setLayoutParams(tv_size);
            //------------------------------------------------

            // Linearlayout row1 can have three textviews
            row3.addView(tv1);
        }

        // root linearlayout
        LinearLayout root_linear = new LinearLayout(this);
        root_linear.setOrientation(LinearLayout.VERTICAL);
        root_linear.setGravity(Gravity.CENTER);

        root_linear.addView(row1);
        root_linear.addView(row2);
        root_linear.addView(row3);

        // display
        setContentView(root_linear);

    }

}