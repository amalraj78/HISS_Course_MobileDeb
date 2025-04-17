package com.example.p17072024_exercice;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContentInfo;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Context global_this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        global_this=this;

        FrameLayout fl1 =(FrameLayout) findViewById(R.id.fl1);
        ftouch ft = new ftouch();
        fl1.setOnTouchListener(ft);
    }

    ArrayList<LinearLayout> box = new ArrayList<>()

    class ftouch implements View.OnTouchListener{
        @Override
        public boolean onTouch(View v, MotionEvent ev) {
            if(ev.getAction()==2){//down
                LinearLayout box = new LinearLayout(global_this);
                LinearLayout.LayoutParams size = new LinearLayout.LayoutParams(100,100);
                box.setLayoutParams(size);
                box.setBackgroundColor(Color.YELLOW);

                box.setX(ev.getX());
                box.setY(ev.getY());

                FrameLayout fl1 = (FrameLayout) findViewById(R.id.fl1);
                fl1.addView(box);

            }
            return true;
        }
    }
}
