package com.example.p11072024;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //define tablelayout
        TableLayout table = new TableLayout(this);

        //define size about table
        TableLayout.LayoutParams table_size = new TableLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        table.setLayoutParams(table_size);

        //-------------------------------table row
        //define table row
        TableRow tr = new TableRow(this);

        //define size about tablerow
        TableRow.LayoutParams tr_size = new TableRow.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        tr.setLayoutParams(tr_size);

        //---------------------------------------button
//      //define button
//      Button bt = new Button(this);
//      //define size button
//      bt.setText("1");
//      TableRow.LayoutParams button_size = new TableRow.LayoutParams(200,200);
//      //assign the size to a button
//      bt.setLayoutParams(button_size);

//      Button bt2 = new Button(this);
//      bt2.setText("2");
//      TableRow.LayoutParams bt2_size = new TableRow.LayoutParams(200,200);
//      bt2.setLayoutParams(bt2_size);

        //avec une boucle for
//       TableRow.LayoutParams button_size = new TableRow.LayoutParams(200,200);
//       Button[] button_array = new Button[5];
//       int i;
//       for(i=0;i<5;i++){
//           button_array[i] = new Button(this);
//           button_array[i].setText((i+1)+"");
//           button_array[i].setLayoutParams(button_size);
//           tr.addView(button_array[i]);
//       }

        //exercice
        TableRow.LayoutParams tv_size = new TableRow.LayoutParams(200,200);
        tv_size.setMargins(10,10,10,10);
        TextView[] tv_array= new TextView[10];
        for (int i=0;i<10;i++){
            tv_array[i]=new TextView(this);
            tv_array[i].setText(i+"");
            tv_array[i].setBackgroundColor(Color.parseColor("#ff9800"));
            tv_array[i].setTextSize(50);
            tv_array[i].setGravity(Gravity.CENTER);
            tv_array[i].setLayoutParams(tv_size);
            //tr.addView(tv_array[i]);
        }

        TableRow.LayoutParams tr_size2 = new TableRow.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        TableRow[] array_tr= new TableRow[2];
        for (int j=0; j<2; j++){
            array_tr[j]= new TableRow(this);
            array_tr[j].setLayoutParams(tr_size2);
           // array_tr[j].addView(tv_array[0]);
            for (int i=0;i<5;i++){
                array_tr[j].addView(tv_array[i+ j*5]);
            }
            table.addView(array_tr[j]);
        };
        //arrange button
        //display table on screen
        setContentView(table);
    }
}