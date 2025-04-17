package com.example.final_ecam;

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


import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Context gthis;

    Handler handle = new Handler(Looper.myLooper());
    makebar bar;
    float bar_vel = 0;
    boolean which = false;
    float ref_x = 0;

    makeball ball;
    float ball_vel_x = 0;
    float ball_vel_y = 0;

    float framewidth = 0;
    float frameheight = 0;

    float parentwidth, parentheight;

    TextView tv1;
    int score = 0;

    makeblock[] blocks = new makeblock[5];
    int[] blockPoints = {1, 2, 3, 4, 5};
    boolean[] blockExists = {true, true, true, true, true};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gthis = this;

        FrameLayout fl1 = (FrameLayout) findViewById(R.id.fl1);
        frametouch ft = new frametouch();
        fl1.setOnTouchListener(ft);

        tv1 = (TextView) findViewById(R.id.tv1);

        frameheight=fl1.getHeight();
        framewidth=fl1.getWidth();

        int int_frameheight = (int)frameheight;
        int int_framewidth = (int)framewidth;

        Random random = new Random();
        float x_rand = (float) Math.random();
        float y_rand = (float) Math.random();

        // Initialize blocks
        for (int i = 0; i < 5; i++) {
            blocks[i] = new makeblock(blockPoints[i]);
            fl1.addView(blocks[i], 200, 200);
            blocks[i].setX((x_rand * 850));
            blocks[i].setY((y_rand * 1000) + 50);
            x_rand = (float) Math.random();
            y_rand = (float) Math.random();
        }

        // call job thread
        Thread thr = new Thread("abc") {
            public void run() {
                for (;;) {

                    handle.post(new Runnable() {
                        @Override
                        public void run() {
                            // message to run in main thread;
                            if (bar != null) {
                                bar.setX(bar.getX() + bar_vel);
                            }
                            if (ball != null) {
                                ball.setX(ball.getX() + ball_vel_x);
                                ball.setY(ball.getY() + ball_vel_y);

                                // ball touch
                                if (ball.getX() + 100f > framewidth || ball.getX() < 0) {
                                    ball_vel_x *= -1;
                                }
                                if (ball.getY() < 0) {
                                    ball_vel_y *= -1;
                                }

                                //ball dont touch bar
                                if (ball.getY() + 100f > frameheight) {
                                    bar.setVisibility(View.INVISIBLE);
                                    ball.setVisibility(View.INVISIBLE);
                                }

                                // ball-bar collision
                                if ((ball.getY() + 100f > bar.getY()) && (ball.getX() + 50f > bar.getX()) && (ball.getX() + 50f < bar.getX() + 200f)) {
                                    ball_vel_y *= -1;
                                    tv1.setText("Score: " + score);
                                }

                                // ball-block collision
                                for (int i = 0; i < blocks.length; i++) {
                                    if (blockExists[i] && ball.getY() < blocks[i].getY() + 200f && ball.getY() + 100f > blocks[i].getY() && ball.getX() + 50f > blocks[i].getX() && ball.getX() + 50f < blocks[i].getX() + 200f) {
                                        ball_vel_y *= -1;
                                        score += blockPoints[i];
                                        tv1.setText("Score: " + score);
                                        blocks[i].setVisibility(View.INVISIBLE);
                                        blockExists[i] = false;
                                    }
                                }
                                }
                            }


                    });

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ie) {
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

            FrameLayout fl1 = (FrameLayout) findViewById(R.id.fl1);

            if (ev.getAction() == 0) {  // Down
                if (which == false) {
                    bar = new makebar();
                    fl1.addView(bar, 200, 40);
                    framewidth = fl1.getWidth();
                    frameheight = fl1.getHeight();
                    bar.setX(fl1.getWidth() / 2 - 100);
                    bar.setY(fl1.getHeight() - 30);
                    which = true;

                    ball = new makeball();
                    fl1.addView(ball, 100, 100);
                    ball.setX(ev.getX() - 50f);
                    ball.setY(ev.getY() - 50f);
                    ball_vel_x = (float) Math.random() * 10f;
                    ball_vel_y = (float) Math.random() * 30f;
                }
                ref_x = ev.getX();
            }

            if (ev.getAction() == 2) {   // Move
                bar_vel = (ev.getX() - ref_x) * 0.1f;
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
            cv.drawRect(0, 0, 200, 40, pt);
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
            // make ball
            cv.drawCircle(50, 50, 50, pt);
        }
    }

    class makeblock extends View {
        int points;

        makeblock(int points) {
            super(gthis);
            this.points = points;
        }

        public void onDraw(Canvas cv) {
            // paint
            Paint pt = new Paint();
            pt.setColor(Color.GREEN);
            pt.setStyle(Paint.Style.FILL);

            // make block
            cv.drawRect(0, 0, 200, 200, pt);

            // draw points
            pt.setColor(Color.WHITE);
            pt.setTextSize(100);
            cv.drawText(points+"",60,125, pt);
        }
    }
}
