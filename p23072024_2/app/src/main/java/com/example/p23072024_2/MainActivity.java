package com.example.p23072024_2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Context gthis;

    float ball_x_vel=0f;
    float refy = 0f;

    ArrayList< makeball > mb = new ArrayList<makeball>();   // mb = [instance, instance ..]

    Handler handle = new Handler(Looper.myLooper());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gthis = this;

        FrameLayout fl1 = (FrameLayout) findViewById(R.id.fl1);
        fltouch flt = new fltouch();
        fl1.setOnTouchListener(flt);



        // control the time
        Thread thr = new Thread("calling_job") {
            public void run() {
                for(;;) {

                    // send message to main thread from job thread
                    handle.post(new Runnable() {
                        @Override
                        public void run() {
                            // main thread should execute following message
                            //mb.get(0).setX( 100f );
                            if(mb.size() > 0) {
                                for(int i=0; i<mb.size(); i++) {
                                    mb.get(i).setX(mb.get(i).getX() + ball_x_vel);
                                }
                            }
                        }
                    });

                    try{
                        Thread.sleep(10);
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            }
        };
        thr.start();


    }



    class fltouch implements View.OnTouchListener{
        @Override
        public boolean onTouch(View v, MotionEvent ev) {

            FrameLayout fl1 = (FrameLayout) findViewById(R.id.fl1);

            if(ev.getAction() == 0){   // Down
                mb.add(new makeball());
                mb.get( mb.size()-1 ).setX( ev.getX() -100 );  //
                mb.get( mb.size()-1 ).setY( ev.getY() -100 );  //
                fl1.addView(mb.get( mb.size()-1 ), 200,200);
                refy = ev.getY();
            }

            TextView tv1 = (TextView) findViewById(R.id.tv1);
            if(ev.getAction() == 2){  // moving
                ball_x_vel = (refy - ev.getY())*0.1f;
                tv1.setText( ball_x_vel+"");
            }

            return true;
        }
    }




    class makeball extends View {
        makeball() {
            super(gthis);
        }
        public void onDraw(Canvas cv) {
            // paint
            Paint pt = new Paint();
            pt.setColor(Color.YELLOW);
            pt.setStyle(Paint.Style.FILL);

            // make circle
            cv.drawCircle( 100,100,100,pt );
        }
    }
}