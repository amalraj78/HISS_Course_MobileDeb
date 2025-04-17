package com.example.p23072024;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Context gthis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gthis = this;

        FrameLayout fl1 = (FrameLayout) findViewById(R.id.fl1);
//        makeball mb = new makeball();
//        fl1.addView(mb);

//        // define Animation(translate)
//        Animation ani = new TranslateAnimation(0, 300, 0,1000);
//        // duration
//        ani.setDuration( 3000 );
//        // offset
//        ani.setStartOffset(1000);
//        // stay
//        ani.setFillAfter(true);
//        // repeat
//        ani.setRepeatCount(3);
//        // start
//        mb.startAnimation(ani);

//        // define Animation(alpha)
//        Animation ani_a = new AlphaAnimation(1,0);
//        // duration
//        ani_a.setDuration(3000);
//        mb.startAnimation(ani_a);

//        // define Animation(scale)
//        Animation ani_s = new ScaleAnimation( 1,0.5f,1,0.5f );
//        // duration
//        ani_s.setDuration(2000);
//        mb.startAnimation(ani_s);

//        mb.setX(300f);
//        mb.setY(500f);
//
//        // defin Animation(rotate)
//        Animation ani_r = new RotateAnimation(0,30);
//        // duration
//        ani_r.setDuration(2000);
//        mb.startAnimation(ani_r);

        makebox box = new makebox();
        box.setBackgroundColor(Color.WHITE);
        fl1.addView(box, 200, 200);
        clickbox cb = new clickbox();
        box.setOnTouchListener(cb);  // when you click box

//        // rotate box
//        Animation ani_r2 = new RotateAnimation(0,360,
//                Animation.RELATIVE_TO_SELF, 0.5f,
//                Animation.RELATIVE_TO_SELF, 0.5f);
//        ani_r2.setDuration(5000);
//        box.startAnimation(ani_r2);
    }

    class clickbox implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent ev) {
            //Animation ani_s = new ScaleAnimation(1, 0.8f, 1,0.8f);
            Animation ani_s = new ScaleAnimation(1, 0.8f, 1,0.8f,
                    Animation.RELATIVE_TO_SELF, 0.5f,
                    Animation.RELATIVE_TO_SELF, 0.5f);
            Animation ani_s2 = new ScaleAnimation(0.8f, 1, 0.8f,1,
                    Animation.RELATIVE_TO_SELF, 0.5f,
                    Animation.RELATIVE_TO_SELF, 0.5f);

            if(ev.getAction()==MotionEvent.ACTION_DOWN) {
                ani_s.setDuration(500);
                ani_s.setFillAfter(true);
                v.startAnimation(ani_s);
            }
            if(ev.getAction()==MotionEvent.ACTION_UP){
                ani_s2.setDuration(500);
                ani_s2.setFillAfter(true);
                v.startAnimation(ani_s);
            }
            return true;
        }
    }

    // make box using class inherited from View. width:100, height:100
    class makebox extends View{
        makebox() {
            super(gthis);
        }
        public void onDraw(Canvas cv) {
            // paint
            Paint pt = new Paint();
            pt.setColor(Color.BLUE);
            pt.setStyle(Paint.Style.FILL);

            cv.drawRect(0,0,200,200, pt);
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
