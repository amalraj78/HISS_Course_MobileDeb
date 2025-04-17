package com.example.homework_16072024;
import android.os.Bundle;
import android.view.MotionEvent;
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

    int var1, var2, isAdd;
    String temp1 = "";
    String temp2 = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //calculator
        TextView tv1 = (TextView) findViewById(R.id.tv1);
        TextView tv2 = (TextView) findViewById(R.id.tv2);
        TextView tv3 = (TextView) findViewById(R.id.tv3);
        TextView tv4 = (TextView) findViewById(R.id.tv4);
        TextView tv5 = (TextView) findViewById(R.id.tv5);
        TextView tv6 = (TextView) findViewById(R.id.tv6);
        TextView tv7 = (TextView) findViewById(R.id.tv7);
        TextView tv8 = (TextView) findViewById(R.id.tv8);
        TextView tv9 = (TextView) findViewById(R.id.tv9);
        TextView tv0 = (TextView) findViewById(R.id.tv0);
        TextView tv_add = (TextView) findViewById(R.id.tv_add);
        TextView tv_eq = (TextView) findViewById(R.id.tv_eq);
        
        tv_touch tv = new tv_touch();
        tveq_touch tveqt = new tveq_touch();

        tv0.setOnClickListener(tv);
        tv1.setOnClickListener(tv);
        tv2.setOnClickListener(tv);
        tv3.setOnClickListener(tv);
        tv4.setOnClickListener(tv);
        tv5.setOnClickListener(tv);
        tv6.setOnClickListener(tv);
        tv7.setOnClickListener(tv);
        tv8.setOnClickListener(tv);
        tv9.setOnClickListener(tv);

        tv_add.setOnClickListener(tv);
        tv_eq.setOnClickListener(tveqt);

    }


    class tv_touch implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            TextView displayt = (TextView) findViewById(R.id.display);

            if (isAdd == 0) {
                if (v.getId() == R.id.tv0)
                    temp1 += "0";
                if (v.getId() == R.id.tv1)
                    temp1 += "1";
                if (v.getId() == R.id.tv2)
                    temp1 += "2";
                if (v.getId() == R.id.tv3)
                    temp1 += "3";
                if (v.getId() == R.id.tv4)
                    temp1 += "4";
                if (v.getId() == R.id.tv5)
                    temp1 += "5";
                if (v.getId() == R.id.tv6)
                    temp1 += "6";
                if (v.getId() == R.id.tv7)
                    temp1 += "7";
                if (v.getId() == R.id.tv8)
                    temp1 += "8";
                if (v.getId() == R.id.tv9)
                    temp1 += "9";
                if (v.getId() == R.id.tv_add) {
                    isAdd = 1;
                    displayt.setText("+");
                }
                displayt.setText((temp1)+"");
            } else {
                if (v.getId() == R.id.tv0)
                    temp2 += "0";
                if (v.getId() == R.id.tv1)
                    temp2 += "1";
                if (v.getId() == R.id.tv2)
                    temp2 += "2";
                if (v.getId() == R.id.tv3)
                    temp2 += "3";
                if (v.getId() == R.id.tv4)
                    temp2 += "4";
                if (v.getId() == R.id.tv5)
                    temp2 += "5";
                if (v.getId() == R.id.tv6)
                    temp2 += "6";
                if (v.getId() == R.id.tv7)
                    temp2 += "7";
                if (v.getId() == R.id.tv8)
                    temp2 += "8";
                if (v.getId() == R.id.tv9)
                    temp2 += "9";
                displayt.setText((temp2)+"");
            }

        }
    }


    class tveq_touch implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            var1=Integer.parseInt(temp1);
            var2=Integer.parseInt(temp2);

            //display
            TextView displayt = (TextView) findViewById(R.id.display);
            displayt.setText("="+(var1+var2)+"");
            var1=0;
            var2=0;
            temp1="";
            temp2="";
            isAdd=0;
            }
        }
    }
