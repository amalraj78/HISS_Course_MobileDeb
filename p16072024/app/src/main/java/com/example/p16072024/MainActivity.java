package com.example.p16072024;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    Context global_this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //local this including proporties for class MainActivity
        //is copied to global_this
        global_this = this;

        EditText edx = (EditText) findViewById(R.id.edX);
        EditText edy = (EditText) findViewById(R.id.edY);
        FrameLayout fl1 = (FrameLayout) findViewById(R.id.fl1);



        Button bt_pos = (Button) findViewById(R.id.btpos);
        bt_touch_pos bttt = new bt_touch_pos(this,edx,edy,fl1);
        bt_pos.setOnTouchListener(bttt);

    }
}

class bt_touch_pos implements View.OnTouchListener{

    Context global_this;
    EditText global_et1;
    EditText global_et2;
    FrameLayout global_fl1;

    bt_touch_pos(Context this1,EditText edx, EditText edy,FrameLayout fl1){ //constructor //receives parameter(this)
        global_this = this1;
        global_et1 = edx;
        global_et2 =edy;
        global_fl1=fl1;
    }

    @Override
    public boolean onTouch(View v, MotionEvent ev){
        LinearLayout box = new LinearLayout(global_this);
        LinearLayout.LayoutParams size = new LinearLayout.LayoutParams(100,100);
        box.setBackgroundColor(Color.WHITE);

        float x = Float.parseFloat(global_et1.getText()+"");
        float y = Float.parseFloat(global_et2.getText()+"");

        box.setLayoutParams(size);
        box.setTranslationX(x);
        box.setTranslationY(y);


        global_fl1.addView(box);

        return true;
    }

//    class bt_touch2 implements View.OnTouchListener{
//        @Override
//        public boolean onTouch(View v, MotionEvent ev){
//            LinearLayout box = new LinearLayout(global_this);
//            LinearLayout.LayoutParams size = new LinearLayout.LayoutParams(100,100);
//            box.setBackgroundColor(Color.WHITE);
//            box.setLayoutParams(size);
//
//            FrameLayout fl1 = (FrameLayout) findViewById(R.id.fl1);
//            fl1.addView(box);
//
//            return true;
//        }
//    }

//    class bt_touch implements View.OnTouchListener{
//        @Override
//        public boolean onTouch(View v, MotionEvent ev){
//            EditText et = (EditText) findViewById(R.id.ed1);
//            String recv_text = et.getText()+"";
//
//            //display in recv_text
//            TextView tv = (TextView) findViewById(R.id.tv1);
//            tv.setText(recv_text);
//
//            return true;
//        }
//    }
//
//
//    class ll1_touch implements View.OnTouchListener{
//        @Override
//        public boolean onTouch(View v, MotionEvent ev){
//            TextView tv = (TextView) findViewById(R.id.tv1);
//
//            int event_num = ev.getAction();
//            switch (event_num){
//                case 0 :
//                    tv.setText("UP");
//                    break;
//                case 1 :
//                    tv.setText("DOWN");
//                    break;
//                case 2 :
//                    tv.setText("jsp");
//                    break;
//            }
//            return true;
//        }
//    }
}