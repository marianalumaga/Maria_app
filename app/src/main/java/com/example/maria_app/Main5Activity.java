package com.example.maria_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.InputStream;

public class Main5Activity extends AppCompatActivity {
    Button b;
    TextView see;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        see=findViewById(R.id.textView3);
        b=findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tx="";
                try{
                    InputStream inputStream=getAssets().open("maris.c");
                    int mar= inputStream.available();
                    byte[] by =new byte[mar];
                    inputStream.read(by);
                    inputStream.close();
                    tx=new String(by);


                } catch (Exception e) {
                    e.printStackTrace();
                }
         see.setText((CharSequence) tx);


            }
        });
    }
}
