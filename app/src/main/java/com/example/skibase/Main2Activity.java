package com.example.skibase;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.Image;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;
import android.widget.TabHost;
import java.lang.*;
import android.os.Bundle;

import android.widget.RadioButton;
import android.widget.TabHost;


import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.sql.Time;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import android.os.Bundle;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;



public class Main2Activity extends AppCompatActivity {

    Button Profile_Button;
    Button Condition_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Profile_Button = (Button)findViewById(R.id.Profile_Button);
        Condition_Button = (Button)findViewById(R.id.Conditions_Button);

        Condition_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity1();
            }
        });

        Profile_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });


    }

    public void openActivity1(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openActivity2(){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

}


