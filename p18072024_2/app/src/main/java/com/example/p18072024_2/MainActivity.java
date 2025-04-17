package com.example.p18072024_2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    int counter = 0;
    float x_inc, y_inc;
    float x_vel=0, y_vel=0;

    Handler handle = new Handler(Looper.myLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // calling slave thread
        Thread thr = new Thread("anyname") {
            public void run() {
                for(;;) {

                    x_inc += x_vel;
                    y_inc += y_vel;

                    handle.post(new Runnable() {
                        @Override
                        public void run() {  // order to run this message in main thread.
                            ImageView iv = (ImageView)findViewById(R.id.ball);
                            iv.setX(x_inc);
                            iv.setY(y_inc);

                            FrameLayout fl1 = (FrameLayout)findViewById(R.id.fl1);
                            TextView tv1 = (TextView) findViewById(R.id.tv1);
                            tv1.setText( iv.getWidth() +"/" +  fl1.getWidth());

                            // ball touch the right wall.
                            if( (iv.getX() + 100) > fl1.getWidth() ) {
                                x_vel *= -1;
                            }

                        }
                    });

                    try {
                        Thread.sleep(10);  // 0.01 sec.
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            }
        };
        thr.start();

        Button bt1 = (Button) findViewById(R.id.bt1);  // left
        Button bt2 = (Button) findViewById(R.id.bt2);  // right
        Button bt3 = (Button) findViewById(R.id.bt3);  // up
        Button bt4 = (Button) findViewById(R.id.bt4);  // down

        btclick btc = new btclick();

        bt1.setOnClickListener( btc );
        bt2.setOnClickListener( btc );
        bt3.setOnClickListener( btc );
        bt4.setOnClickListener( btc );

    }

    class btclick implements View.OnClickListener{
        @Override
        public void onClick(View v) {

            if(v.getId() == R.id.bt1) {   // left click
                x_vel -= 0.5;
            } else if(v.getId() == R.id.bt2) {  // right click
                x_vel += 0.5;
            } else if(v.getId() == R.id.bt3) { // up click
                y_vel -= 0.5;
            } else {                // down click
                y_vel += 0.5;
            }

        }
    }





}