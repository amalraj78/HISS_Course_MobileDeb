package com.example.calc_simple;
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

    int var1, var2;
    String temp = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv1 = (TextView) findViewById(R.id.tv1);
        TextView tv2 = (TextView) findViewById(R.id.tv2);

        tv1_touch tv1t = new tv1_touch();
        tv2_touch tv2t = new tv2_touch();

        tv1.setOnTouchListener(tv1t);
        tv2.setOnTouchListener(tv2t);

        bt1_touch bt1t = new bt1_touch();
        Button bt1 = (Button) findViewById(R.id.bt1);
        bt1.setOnTouchListener(bt1t);
    }

    class bt1_touch implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent ev) {

            TextView tv3 = (TextView) findViewById(R.id.tv3);
            //tv3.setText( var1+var2+"" );

            tv3.setText((Integer.parseInt(temp) + 5) + "");

            return true;
        }
    }



    class tv1_touch implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent ev) {
            var1 = 1;

            if(ev.getAction() == 0) {
                temp += "1";
            }
            return true;
        }
    }
    class tv2_touch implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent ev) {
            var2 = 2;
            return true;
        }
    }

}