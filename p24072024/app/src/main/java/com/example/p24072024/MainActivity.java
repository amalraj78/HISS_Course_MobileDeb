package com.example.p24072024;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button clickevent
        Button bt = (Button) findViewById(R.id.bt1);
        Button bt2 = (Button) findViewById(R.id.bt2);

        btclick btc =  new btclick();
        bt.setOnClickListener(btc);
        bt2.setOnClickListener(btc);
    }

    class btclick implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            //open new activity using Intent class
            //implicit intent
            Intent intent = new Intent();
//            ComponentName com = new ComponentName("com.example.p24072024","com.example.p24072024.MainActivity1");
//            intent.setComponent(com);
//            startActivity(intent);

            //explicit intent
//            intent.setAction(Intent.ACTION_MAIN);
//            intent.addCategory(Intent.CATEGORY_APP_MAPS);

            if(view.getId() == R.id.bt1) {
                intent.setAction("android.intent.action.MAIN123");
                intent.putExtra("sendmessage1", "our project");
                startActivity(intent);
            }

            if(view.getId() == R.id.bt2) {
                intent.setAction("android.intent.action.game1");
                startActivity(intent);
            }
        }
    }
}