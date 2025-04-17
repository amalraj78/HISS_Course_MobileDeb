package com.example.p19072024;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
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
    ArrayList<Integer> indx = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //LinearLayout
        LinearLayout ll1 = (LinearLayout) findViewById(R.id.ll1);

        //size
        LinearLayout.LayoutParams size = new LinearLayout.LayoutParams(200, 200);
        size.setMargins(10, 10, 10, 10);
//
        //no.1
        for (int i = 0; i < 5; i++) {
            indx.add(i);
            box.add(new TextView(this));
            box.get(i).setText((i + 1) + "");
            box.get(i).setLayoutParams(size);
            box.get(i).setBackgroundColor(Color.BLACK);
            box.get(i).setTextColor(Color.WHITE);
            box.get(i).setTextSize(50f);
            box.get(i).setGravity(Gravity.CENTER);
            box.get(i).setId((int) (i + 1));
        }

        Collections.shuffle(indx);
        for (int i = 0; i < 5; i++)
            ll1.addView(box.get(indx.get(i)));

        box_click bc = new box_click();
        for (int i = 0; i < 5; i++)
            box.get(i).setOnClickListener(bc);
    }

    String display = "";

    class box_click implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            TextView tv1 = (TextView) findViewById(R.id.tv1);
            if (display.length() < 5)
                display += (view.getId() + "");
            tv1.setText(display);
            if (display.length() == 5) {
                if (display.equals("12345")) {
                    tv1.setText("TRUE");
                } else tv1.setText("FALSE");
            }
        }
    }
}


