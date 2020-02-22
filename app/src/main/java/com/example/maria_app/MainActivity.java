package com.example.maria_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button ni =(Button)findViewById(R.id.mu);
        ni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,first_Activity.class);
                startActivity(intent);
            }
        });
        Button M =(Button)findViewById(R.id.button2);
        M.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main5Activity.class);
                startActivity(intent);
            }
        });

    }
public void sendMessage(View view) {

    EditText message = (EditText)findViewById(R.id.message);
    Toast.makeText(this, "sending  message", Toast.LENGTH_SHORT).show();
    Intent intent = new Intent(this,DisplayMessageActivity.class);
    intent.putExtra("MESSAGE" ,message.getText().toString());
    startActivity(intent);
    message.setText("");

}
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
//respond to menu item selection
        switch (item.getItemId()) {
            case R.id.menu_settings:
                startActivity(new Intent(this, Main2Activity.class));
                return true;
            case R.id.menu_refresh:
                startActivity(new Intent(this, Main3Activity.class));
                return true;
            default:
                return true;
        }
    }



}
