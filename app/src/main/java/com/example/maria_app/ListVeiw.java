package com.example.maria_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListVeiw extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_veiw);
        setTitle("My list");
        ListView listView = (ListView)findViewById(R.id.list);
        List<String> dataList = new ArrayList<String>();
        dataList.add("Java");
        dataList.add("Android");
        dataList.add("html");
        dataList.add("system secuity");
        dataList.add("c programming");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ListVeiw.this,
                android.R.layout.simple_list_item_multiple_choice, dataList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
                Object clickItemObj = adapterView.getAdapter().getItem(index);
                Toast.makeText(ListVeiw.this, "You clicked " + clickItemObj.toString(),

                        Toast.LENGTH_SHORT).show();
            }
        });
    }



}
