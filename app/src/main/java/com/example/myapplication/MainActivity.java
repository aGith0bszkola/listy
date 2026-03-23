package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> jezykiArrayList;
    private ArrayAdapter<String> arrayAdapter;
    private ListView listView;
    private EditText editText;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        jezykiArrayList = new ArrayList<>();
        jezykiArrayList.add("ruby");
        jezykiArrayList.add("pearl");
        jezykiArrayList.add("Kotlin");
        jezykiArrayList.add("go");
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,jezykiArrayList);
        listView =  findViewById(R.id.ListViewJezyki);
        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                view.setBackgroundColor(Color.GRAY);
                jezykiArrayList.remove(i);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        editText = findViewById(R.id.editTextJezyk);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jezyk = editText.getText().toString();
                jezykiArrayList.add(jezyk);
                arrayAdapter.notifyDataSetChanged();
            }
        });

    }
}