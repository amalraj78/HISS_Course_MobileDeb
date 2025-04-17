package com.example.p17072024;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Context global_this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        global_this = this;    //

        FrameLayout fl1 = (FrameLayout)findViewById(R.id.fl1);
        fltouch ft = new fltouch();
        fl1.setOnTouchListener( ft );

//        Button bt1 = (Button) findViewById(R.id.bt1);
//        btclick btc = new btclick();
//        bt1.setOnClickListener(btc);
//
//        Button bt2 = (Button)findViewById(R.id.bt2);
//        bt2click btc2 = new bt2click();
//        bt2.setOnClickListener(btc2);

        Button bt1 = (Button) findViewById(R.id.bt1);
        Button bt2 = (Button) findViewById(R.id.bt2);
        btclick btc = new btclick();
        bt1.setOnClickListener(btc);
        //bt2.setOnClickListener(btc);
    }

    LinearLayout box;
    class btclick implements View.OnClickListener {
        @Override
        public void onClick(View v){
            FrameLayout fl1 = (FrameLayout)findViewById(R.id.fl1);
            if( v.getId() == R.id.bt1) {   // when you click bt1; making box
                box = new LinearLayout(global_this);
                LinearLayout.LayoutParams size = new LinearLayout.LayoutParams(100,100);
                box.setBackgroundColor(Color.YELLOW);
                box.setLayoutParams(size);
                box.setTranslationX(100f);
                box.setTranslationY(200f);
                fl1.addView(box);
            }
            if(v.getId() == R.id.bt2) {   // when you click bt2
                fl1.removeView(box);
            }
        }
    }



//    class bt2click implements View.OnClickListener {
//        @Override
//        public void onClick(View v) {
//            FrameLayout fl1 = (FrameLayout) findViewById(R.id.fl1);
//            fl1.removeView( box );
//        }
//    }
//
//    class btclick implements View.OnClickListener {
//        @Override
//        public void onClick( View v) {
//            box = new LinearLayout(global_this);
//            LinearLayout.LayoutParams size = new LinearLayout.LayoutParams(100,100);
//            box.setLayoutParams(size);
//            box.setBackgroundColor(Color.YELLOW);
//
//            FrameLayout fl1 = (FrameLayout) findViewById(R.id.fl1);
//            fl1.addView(box);
//        }
//    }




    class fltouch implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent ev) {

            if(ev.getAction() == 0) {   // down
                v.setBackgroundColor(Color.RED);   // v: framelayout fl1
            }
            if(ev.getAction() == 1) {  // up
                v.setBackgroundColor(Color.BLACK);   // v: framelayout fl1
            }

            TextView tv3 = (TextView) findViewById(R.id.tv3);
            tv3.setText( ev.getAction()+"" );

            TextView tv1 = (TextView) findViewById(R.id.tv1);
            TextView tv2 = (TextView) findViewById(R.id.tv2);

            if(ev.getAction() == 2) {    // moving
                tv1.setText(ev.getX() + "");
                tv2.setText(ev.getY() + "");
            }
            return true;
        }
    }
}