package com.example.maria_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    BroadcastReceiver r=new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            int y = intent.getIntExtra("level", 0);
            ProgressBar bar = (ProgressBar) findViewById(R.id.progressBar2);
            bar.setProgress(y);
            TextView textView = (TextView) findViewById(R.id.bat);
            textView.setText("battery level is " + Integer.toString(y) + "%");

        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerReceiver(r,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

    }
    public void clickMe(View view){
        EditText txt=(EditText) findViewById(R.id.editText);
        int a=Integer.parseInt(txt.getText().toString());
        Intent inte =new Intent(this,MyBroadCastReceiver.class);
        //creating apending in and call the reciever
        PendingIntent pendingIntent= PendingIntent.getBroadcast(this.getApplicationContext(),0,inte,0);

        AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(a*1000),pendingIntent);
        Toast.makeText(this,"alarm set in"+a+"Seconds",Toast.LENGTH_LONG).show();

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

            case R.id.call:

                Intent intent2 = new Intent(Intent.ACTION_DIAL);
                intent2.setData( Uri.parse("tel:0752630654"));

               if (ActivityCompat.checkSelfPermission(MainActivity.this,
                       Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                   startActivity(intent2);
               }
                return true;
            //              }
            case R.id.c:
                Intent inten = new Intent(MainActivity.this,Main5Activity.class);
              startActivity(inten);

            case R.id.li:
                Intent in=new Intent(MainActivity.this,ListVeiw.class);
                startActivity(in);


            case R.id.email:

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("emailto:"));
                String to[] = {"nalumagamaria001@gmail.com", "kyorigarurab@gmail.com", "annetkansiime76@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL, to);
                intent.putExtra(Intent.EXTRA_SUBJECT, "hey girls");
                intent.putExtra(Intent.EXTRA_TEXT, "am around please");
                intent.setType("message/rfc822");
                startActivity(intent);
                return true;

            case R.id.menu_refresh:
                startActivity(new Intent(this, Main3Activity.class));
                return true;
            case R.id.rec:
                startActivity(new Intent(this,Recycler.class));
                return true;
            case R.id.mus:
                Intent sic =new Intent(MainActivity.this,first_Activity.class);
                startActivity(sic);
            default:
                return true;
        }
    }



}
