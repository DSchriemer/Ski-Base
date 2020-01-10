package com.example.skibase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {

    EditText txtname, txtage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Toast.makeText(this, "Connected to Database", Toast.LENGTH_SHORT).show();




    }
}
