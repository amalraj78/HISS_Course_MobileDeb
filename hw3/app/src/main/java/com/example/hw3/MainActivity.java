package com.example.hw3;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    // H.W. 1
    int globalsize = 5;  // the number of rows!!!

    ArrayList<TextView> box = new ArrayList<TextView>();
    String num = "";
    int counter = 0;

    Handler handle = new Handler(Looper.myLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Linearlayout
        LinearLayout ll1 = (LinearLayout) findViewById(R.id.ll1);

        // size
        TableLayout.LayoutParams size = new TableLayout.LayoutParams(200, 200);
        size.setMargins(10, 10, 10, 10);

        ArrayList<Integer> indx = new ArrayList<Integer>();  // for index of textview

        // no.1
        for (int i = 0; i < globalsize; i++) {
            indx.add(i);
            TextView textView = new TextView(this);
            textView.setText((i + 1) + "");
            textView.setLayoutParams(size);
            textView.setBackgroundColor(Color.BLACK);
            textView.setTextColor(Color.WHITE);
            textView.setTextSize(50f);
            textView.setGravity(Gravity.CENTER);
            textView.setTag(i + 1); // Use tag to store the index
            box.add(textView);
        }
        Collections.shuffle(indx);   // indx = shuffled list of indices

        TableLayout table1 = (TableLayout) findViewById(R.id.table1);

        TextView tv1 = (TextView) findViewById(R.id.tv1);

        for (int j = 0; j < globalsize; j++) {   // for each row
            TableRow row1 = new TableRow(this);
            int temp = (int) (Math.random() * 5);    // random for position on a row
            // Empty box
            for (int i = 0; i < 5; i++) { // fixed number of columns
                if (i == temp) {
                    row1.addView(box.get(indx.get(j)), 200, 200);
                } else {
                    TextView ebox = new TextView(this);
                    ebox.setBackgroundColor(Color.WHITE);
                    ebox.setText("");
                    ebox.setLayoutParams(size);
                    ebox.setTextSize(50f);
                    ebox.setGravity(Gravity.CENTER);
                    row1.addView(ebox, 200, 200);
                }
            }
            table1.addView(row1);
        }

        box_click bc = new box_click();
        for (int i = 0; i < globalsize; i++) {
            box.get(i).setOnClickListener(bc);
        }

        // thread +  handler  : for time
        Thread thr = new Thread("sample") {
            public void run() {
                for (; ; ) {
                    counter++;

                    // send message to main thread
                    handle.post(new Runnable() {
                        @Override
                        public void run() {
                            if (counter > 3) {
                                for (int i = 0; i < globalsize; i++) {
                                    box.get(i).setText("");
                                }
                            }
                        }
                    });

                    try {
                        Thread.sleep(1000);  // for every 1 sec.
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            }
        };
        thr.start();
    }

    class box_click implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            TextView tv1 = (TextView) findViewById(R.id.tv1);
            if (num.length() < globalsize) {
                num += v.getTag().toString();
                v.setBackgroundColor(Color.WHITE);
            }

            // Generate the expected string dynamically
            StringBuilder expected = new StringBuilder();
            for (int i = 1; i <= globalsize; i++) {
                expected.append(i);
            }

            if (num.equals(expected.toString())) {
                tv1.setText("True");
            } else {
                tv1.setText("False");
            }
        }
    }
}
