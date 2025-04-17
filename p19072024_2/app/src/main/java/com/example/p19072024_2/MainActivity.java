package com.example.p19072024_2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ArrayList<TextView> box = new ArrayList<TextView>();
    String num = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Linearlayout
        LinearLayout ll1 = (LinearLayout)findViewById(R.id.ll1);

        // size
        TableLayout.LayoutParams size = new TableLayout.LayoutParams(200,200);
        size.setMargins(10,10,10,10);


        ArrayList<Integer> indx = new ArrayList<Integer>();  // for index of textview

        // no.1
        for(int i=0; i<5; i++) {
            indx.add(i);
            box.add(new TextView(this));
            box.get(i).setText((i+1)+"");
            box.get(i).setLayoutParams(size);
            box.get(i).setBackgroundColor(Color.BLACK);
            box.get(i).setTextColor(Color.WHITE);
            box.get(i).setTextSize(50f);
            box.get(i).setGravity(Gravity.CENTER);
            box.get(i).setId((int)(i+1));
        }
        Collections.shuffle(indx);   // indx = [5,2,3,1,5]

        TableLayout table1 = (TableLayout) findViewById(R.id.table1);
        //row1.addView(box.get(0), 200, 200);

        TextView tv1= (TextView) findViewById(R.id.tv1);

        for(int j=0; j<5; j++) {   // for each row
            TableRow row1 = new TableRow(this);
            int temp = (int) (Math.random() * 4);    // random for position on a row
            // Empty box
            for (int i = 0; i < 5; i++) {
                tv1.setText(temp + "");
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
        for(int i=0; i<5; i++) {
            box.get(i).setOnClickListener(bc);
        }


    }

    class box_click implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            TextView tv1 = (TextView) findViewById(R.id.tv1);
            if(num.length() < 5) {
                num += v.getId();
            }

            if(num.equals("12345")){
                tv1.setText("True");
            } else {
                tv1.setText("False");
            }
        }
    }

}