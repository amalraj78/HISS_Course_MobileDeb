package com.example.p18072024;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Context global_this;
    //float point_x,point_y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        global_this=this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt = (Button)findViewById(R.id.bt1);
        bt_click btc = new bt_click();
        bt.setOnClickListener(btc);
    }

    class frametouch

    class  bt_click implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            myview mv = new myview();
            Button newbt = new Button(global_this);
            FrameLayout fl1=(FrameLayout) findViewById(R.id.fl1);
            fl1.addView(newbt);
        }
    }

    class myview extends View{
        myview(){ //constructor
            super(global_this);//initialize View via global this
        }
        //define paint and brush using a paint class
        public void onDraw(Canvas cv){
            Paint pnt = new Paint();
            pnt.setColor(Color.BLUE);
            pnt.setStrokeWidth(20f);
            pnt.setStrokeCap(Paint.Cap.ROUND);
            pnt.setStyle(Paint.Style.FILL);

            cv.drawPoint(point_x,_point_y,pnt);
        }
    }
}