package com.example.p24072024;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Color;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    Context gthis;

    Handler handle = new Handler(Looper.myLooper());
    makebar bar;
    float bar_vel = 0;
    boolean which=false;
    float ref_x=0;

    float parentwidth, parentheight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        gthis = this;

        FrameLayout fl1 = (FrameLayout) findViewById(R.id.fl1);
        frametouch ft = new frametouch();
        fl1.setOnTouchListener(ft);

        // call job thread
        Thread thr = new Thread("abc") {
            public void run() {
                for(;;) {

                    handle.post(new Runnable() {
                        @Override
                        public void run() {
                            // message to run in main thread;
                            if(bar != null) {
                                bar.setX(bar.getX() + bar_vel);
                            }
                        }
                    });

                    try{
                        Thread.sleep(50);
                    } catch (InterruptedException ie){
                        ie.printStackTrace();
                    }
                }
            }
        };
        thr.start();

    }

    class frametouch implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent ev) {

            FrameLayout fl1 = (FrameLayout)findViewById(R.id.fl1);

            TextView tv1 = (TextView) findViewById(R.id.tv1);
            tv1.setText(fl1.getWidth()+"");

            if(ev.getAction() == 0) {  // Down
                if(which == false) {
                    bar = new makebar();
                    fl1.addView(bar, 200, 40);
                    bar.setX( fl1.getWidth() / 2 - 100 );
                    bar.setY( fl1.getHeight() - 30);
                    which = true;
                }
                ref_x = ev.getX();
            }

            if(ev.getAction() == 2) {   // Move
                bar_vel = (ev.getX() - ref_x)*0.1f;
                tv1.setText(ev.getX() + " " + ref_x);
            }
            return true;
        }
    }

    class makebar extends View {
        makebar() {
            super(gthis);
        }
        public void onDraw(Canvas cv) {
            // paint
            Paint pt = new Paint();
            pt.setColor(Color.BLUE);
            pt.setStyle(Paint.Style.FILL);

            // make box
            cv.drawRect( 0,0, 200, 40 , pt);
        }
    }
}