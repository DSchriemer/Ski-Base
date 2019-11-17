package com.example.skibase;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Button;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Button buttonA;
    TextView txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonA = (Button)findViewById(R.id.buttonA);
        txt = (TextView)findViewById(R.id.txt);

    }
}
