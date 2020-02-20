package com.example.skibase;

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

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button getBtn;
    TextView result;
    TextView tmp;
    TextView am1;
    TextView pm1;
    TextView n1;
    TextView am2;
    TextView pm2;
    TextView n2;
    TextView am3;
    TextView pm3;
    TextView n3;
    TextView w1;
    TextView w2;
    TextView w3;
    TextView s1;
    TextView s2;
    TextView s3;
    RadioButton radioButton;
    ImageView currentweather;
    TextView condition1;
    TextView Resort;

    String hill;

    Spinner spinner;

    Button Profile_Button;
    Button Condition_Button;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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




        Spinner spinner = (Spinner) findViewById(R.id.spinner);




        ArrayAdapter<String> myAdaptor = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.Mountains));
        myAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myAdaptor);

        spinner.setOnItemSelectedListener(this);


    }

    public void openActivity1(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openActivity2(){
        Intent intent = new Intent(this, Main4Activity.class);
        startActivity(intent);
    }



   // @Override
    //public void onClick(View view) {
    //    if(view.getId()==R.id.buttonA){
    //        txt.setText("button clicked");
    //    }
    //}

    private void getWebsite()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final StringBuilder wind = new StringBuilder();
                final StringBuilder temp = new StringBuilder();
                final StringBuilder conditions = new StringBuilder();
                final StringBuilder current = new StringBuilder();




                try {

                    String url = "";
                    condition1 = (TextView) findViewById(R.id.condition1);
                    Resort = (TextView) findViewById(R.id.Resort);

                    if (hill.equals("Fernie")) {
                        url = "https://www.snow-forecast.com/resorts/Fernie/6day/mid";
                        Resort.setText("Fernie Alpine Resort");
                    }
                    else if (hill.equals("Big White")) {
                        url = "https://www.snow-forecast.com/resorts/Big-White/6day/mid";
                        Resort.setText("Big White Ski Resort");
                    }
                    else if (hill.equals("Whistler")) {
                        url = "https://www.snow-forecast.com/resorts/Whistler-Blackcomb/6day/mid";
                        Resort.setText("Whistler Black Comb");
                    }
                    else if (hill.equals("Cypress")) {
                        url = "https://www.snow-forecast.com/resorts/Cypress-Mountain/6day/mid";
                        Resort.setText("Cypress");
                    }
                    else if (hill.equals("Grouse Mountain")) {
                        url = "https://www.snow-forecast.com/resorts/Grouse-Mountain/6day/mid";
                        Resort.setText("Grouse Mountain");
                    }
                    else if (hill.equals("Kicking Horse")) {
                        url = "https://www.snow-forecast.com/resorts/Kicking-Horse/6day/mid";
                        Resort.setText("Kicking Horse");
                    }
                    else if (hill.equals("Mount Washington")) {
                        url = "https://www.snow-forecast.com/resorts/Mount-Washington/6day/mid";
                        Resort.setText("Mount Washington");
                    }
                    else if (hill.equals("Mount Seymour")) {
                        url = "https://www.mountain-forecast.com/peaks/Mount-Seymour";
                        Resort.setText("Mount Seymour");
                    }
                    else if (hill.equals("Powder King")) {
                        url = "https://www.snow-forecast.com/resorts/PowderKing/6day/mid";
                        Resort.setText("Powder King");
                    }
                    else if (hill.equals("Revelstoke")) {
                        url = "https://www.snow-forecast.com/resorts/Revelstoke/6day/mid";
                        Resort.setText("Revelstoke");
                    }
                    else if (hill.equals("Silver Star")) {
                        url = "https://www.mountain-forecast.com/peaks/Silver-Star-Mountain";
                        Resort.setText("Silver Star");
                    }
                    else if (hill.equals("Sun Peaks")) {
                        url = "https://www.snow-forecast.com/resorts/Sun-Peaks/6day/mid";
                        Resort.setText("Sun Peaks");
                    }
                    else if (hill.equals("Squaw Valley")) {
                        url = "https://www.snow-forecast.com/resorts/Squaw-Valley-USA/6day/mid";
                        Resort.setText("Squaw Valley");
                    }
                    else if (hill.equals("Purgatory")) {
                        url = "https://www.snow-forecast.com/resorts/Purgatory-Resort/6day/mid";
                        Resort.setText("Purgatory");
                    }
                    else if (hill.equals("Snowmass")) {
                        url = "https://www.snow-forecast.com/resorts/Snowmass/6day/mid";
                        Resort.setText("Snowmass");
                    }
                    else if (hill.equals("Sun Valley")) {
                        url = "https://www.snow-forecast.com/resorts/ShigaKogenSunValley/6day/mid";
                        Resort.setText("Sun Valley");
                    }
                    else if (hill.equals("Buttermilk")) {
                        url = "https://www.snow-forecast.com/resorts/Buttermilk/6day/mid";
                        Resort.setText("Buttermilk");
                    }
                    else if (hill.equals("Telluride")) {
                        url = "https://www.snow-forecast.com/resorts/Telluride/6day/mid";
                        Resort.setText("Telluride");
                    }
                    else if (hill.equals("Verbier")) {
                        url = "https://www.snow-forecast.com/resorts/Verbier/6day/mid";
                        Resort.setText("Verbier");
                    }
                    else if (hill.equals("Grindelwald")) {
                        url = "https://www.snow-forecast.com/resorts/Grindelwald/6day/mid";
                        Resort.setText("Grindelwald");
                    }
                    else if (hill.equals("Les Arcs")) {
                        url = "https://www.snow-forecast.com/resorts/Les-Arcs/6day/mid";
                        Resort.setText("Les Arcs");
                    }
                    else if (hill.equals("Morzine")) {
                        url = "https://www.snow-forecast.com/resorts/Morzine/6day/mid";
                        Resort.setText("Morzine");
                    }
                    else if (hill.equals("Whistler")) {
                        url = "https://www.snow-forecast.com/resorts/Whistler-Blackcomb/6day/mid";
                        Resort.setText("Whistler Black Comb");
                    }
                    else if (hill.equals("Méribel")) {
                        url = "https://www.snow-forecast.com/resorts/Meribel/6day/mid";
                        Resort.setText("Méribel");
                    }
                    else if (hill.equals("Alpe d'Huez")) {
                        url = "https://www.snow-forecast.com/resorts/Alpe-d-Huez/6day/mid";
                        Resort.setText("Alpe d'Huez");
                    }
                    else if (hill.equals("Serre Chevalier")) {
                        url = "https://www.snow-forecast.com/resorts/Serre-Chevalier/6day/mid";
                        Resort.setText("Serre Chevalier");
                    }
                    else if (hill.equals("Arber")) {
                        url = "https://www.snow-forecast.com/resorts/Whistler-Blackcomb/6day/mid";
                        Resort.setText("Arber");
                    }
                    else if (hill.equals("Oberaudorf Hocheck")) {
                        url = "https://www.snow-forecast.com/resorts/Oberaudorf/6day/mid";
                        Resort.setText("Oberaudorf Hocheck");
                    }
                    else if (hill.equals("Ochsenkopf")) {
                        url = "https://www.snow-forecast.com/resorts/Ochsenkopf/6day/mid";
                        Resort.setText("Ochsenkopf");
                    }
                    else {
                        System.out.println("ERROR No Selection");
                    }

                    Document document = Jsoup.connect(url).get();

                    wind.setLength(0);
                    temp.setLength(0);
                    conditions.setLength(0);



                    //String question = document.select("#question .post-text").text();
                    //builder2.append("Question: " + question).append("\n");


                    LocalTime l = LocalTime.now();
                    //temp.append(l.getHour());
                    //l = l.getHour();

                    //temp.append(hours).append("\n");

                    //Date currentTime = Calendar.getInstance().getTime();
                    //temp.append(currentTime);

                    Elements outsidenow = document.select("div.forecast-table-phrases__container");
                    for (Element answer : outsidenow) {
                        current.append(answer.text()).append("\n");
                    }

                    Elements winders = document.select("div.forecast-table-wind__container");
                    for (Element answer : winders) {
                        wind.append(answer.text()).append("\n");
                    }
                    Elements temps = document.select("div.forecast-table-temp__container");
                    for (Element answerer : temps) {
                        temp.append(answerer.text()).append("\n");
                    }


                    Elements conditioners = document.select("div.forecast-table-snow__container");
                    for (Element answerer : conditioners) {
                        conditions.append(answerer.text()).append("\n");
                    }

                    //printScreen(wind,temp,conditions);

                }
                catch (IOException e) {
                    wind.append("error").append(e.getMessage()).append("\n");
                    System.out.println(e.getMessage());
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        //Weather UI



                        int conditioncount = 0;
                        String weather = "";

                        //^[ A-Za-z]+$

                        for(int i = 0; i<70;i++)
                        {


                            if (conditioncount <= 0)
                            {
                                if((String.valueOf(current.charAt(i))).matches("^[ A-Za-z]+$"))
                                {
                                    //System.out.println("Good: ");// + String.valueOf(temp.charAt(i)));
                                    weather += current.charAt(i);

                                    //i++;

                                }else{

                                    conditioncount++;
                                }


                            }
                        }

                        currentweather = (ImageView) findViewById(R.id.currentweather);

                        if (weather.equals("light snow")) {
                            currentweather.setImageResource(R.drawable.snow);
                            condition1.setText("Light Snow");
                        }
                        else if (weather.equals("mod. snow")) {
                            currentweather.setImageResource(R.drawable.snow);
                            condition1.setText("Moderate Snow");

                        }
                        else if (weather.equals("heavy snow")) {
                            currentweather.setImageResource(R.drawable.snow);
                            condition1.setText("Heavy Snow");
                        }
                        else if (weather.equals("snow shwrs")) {
                            currentweather.setImageResource(R.drawable.rain1);
                            condition1.setText("Snow Showers");
                        }
                        else if (weather.equals("some clouds")) {
                            currentweather.setImageResource(R.drawable.partial);
                            condition1.setText("Some Clouds");
                        }
                        else if (weather.equals("cloudy")) {
                            currentweather.setImageResource(R.drawable.clouds);
                            condition1.setText("Cloudy");
                        }else
                        {
                            currentweather.setImageResource(R.drawable.clear);
                            condition1.setText("Clear");
                        }







                        //end of Weather UI




















                        //TextView[] textViewArray = {am1,pm1,n1};
                        int tvcounter = 0;
                        int tvcounter2 = 0;


                        am1 = (TextView) findViewById(R.id.am1);
                        pm1 = (TextView) findViewById(R.id.pm1);
                        n1 = (TextView) findViewById(R.id.n1);
                        am1.setText("");
                        pm1.setText("");
                        n1.setText("");

                        //am2 = (TextView) findViewById(R.id.am2);
                       // pm2 = (TextView) findViewById(R.id.pm2);
                        //n2 = (TextView) findViewById(R.id.n2);
                        //am3 = (TextView) findViewById(R.id.am3);
                        //pm3 = (TextView) findViewById(R.id.pm3);
                        //n3 = (TextView) findViewById(R.id.n3);

                        TextView[] textViewArray = {am1,pm1,n1};
                        TextView[] textViewArray2 = {am2,pm2,n2};

                        int coldCount =0;


                        //am1.setText(String.valueOf(temp.charAt(0)));

                        //tmp.setText("y");

                        for(int i = 0; i<70;i++)
                        {
                            System.out.println("HERE: " + i + " " + (temp.charAt(i)));

                            if (tvcounter <= 2)
                            {
                                if((String.valueOf(temp.charAt(i))).matches(".*[0-9].*") || (String.valueOf(temp.charAt(i)).matches("-")))
                                {
                                    System.out.println("Good: ");// + String.valueOf(temp.charAt(i)));
                                    textViewArray[tvcounter].append(String.valueOf(temp.charAt(i)));

                                    //i++;

                                }else{
                                    System.out.println("next: ");

                                    tvcounter++;
                                }


                            }
                        } //end of temperature

                        //beginning of wind

                        w1 = (TextView) findViewById(R.id.w1);
                        w2 = (TextView) findViewById(R.id.w2);
                        w3 = (TextView) findViewById(R.id.w3);
                        w1.setText("");
                        w2.setText("");
                        w3.setText("");

                        int windCounter = 0;

                        TextView[] windArray = {w1,w2,w3};

                        //w1.append(String.valueOf(wind.charAt(0)));
                        for(int i = 0; i<20;i++)
                        {
                            System.out.println("HERE: " + i + " " + (wind.charAt(i)));

                            if (windCounter <= 2)
                            {
                                if((String.valueOf(wind.charAt(i))).matches(".*[0-9].*") || (String.valueOf(wind.charAt(i)).matches("-")))
                                {
                                    System.out.println("Good: ");// + String.valueOf(temp.charAt(i)));
                                    windArray[windCounter].append(String.valueOf(wind.charAt(i)));

                                    //i++;

                                }else{
                                    System.out.println("next: ");

                                    windCounter++;
                                }


                            }
                        } //end of wind

                        //beginning of wind

                        s1 = (TextView) findViewById(R.id.s1);
                        s2 = (TextView) findViewById(R.id.s2);
                        s3 = (TextView) findViewById(R.id.s3);
                        s1.setText("");
                        s2.setText("");
                        s3.setText("");

                        int snowCounter = 0;

                        TextView[] snowArray = {s1,s2,s3};

                        //w1.append(String.valueOf(wind.charAt(0)));
                        for(int i = 0; i<7;i++)
                        {


                            if (snowCounter < 3)
                            {
                                System.out.println("snow: " + i + " " + (conditions.charAt(i)));
                                if((String.valueOf(conditions.charAt(i))).matches(".*[0-9].*") || (String.valueOf(conditions.charAt(i)).matches("-")))
                                {
                                    System.out.println("Good: ");// + String.valueOf(temp.charAt(i)));
                                    snowArray[snowCounter].append(String.valueOf(conditions.charAt(i)));

                                    //i++;

                                }else{
                                    System.out.println("next: ");
                                    snowCounter++;


                                }



                            }
                        } //end of wind

                        coldWeather(textViewArray, windArray);



                    }

                });




            }
        }).start();

    }


    public void coldWeather(TextView a[], TextView b[]) {


        am2 = (TextView) findViewById(R.id.am2);
        pm2 = (TextView) findViewById(R.id.pm2);
        n2 = (TextView) findViewById(R.id.n2);
        am2.setText("");
        pm2.setText("");
        n2.setText("");

        TextView[] coldArray = {am2,pm2,n2};

        for (int i = 0; i< 3; i++) {



            int num = Integer.valueOf(a[i].getText().toString());
            int num2 = Integer.valueOf(b[i].getText().toString());

            //System.out.println("NUMBER: " + num + "MINUS: " + (num2/5) + "equals " + (num - (num2/5)));

            int low = num - (num2 / 5) - 1;

            coldArray[i].setText(String.valueOf(low));
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        String text = adapterView.getItemAtPosition(i).toString();
        System.out.println(text);

        hill = text;

        getWebsite();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
