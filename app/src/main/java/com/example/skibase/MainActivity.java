package com.example.skibase;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import java.lang.*;

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

public class MainActivity extends AppCompatActivity {

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView) findViewById(R.id.result);
        getBtn = (Button) findViewById(R.id.launchBtn);
        getBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWebsite();
            }
        });

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


                try {

                    String url = "https://www.snow-forecast.com/resorts/Fernie/6day/mid";
                    Document document = Jsoup.connect(url).get();

                    //String question = document.select("#question .post-text").text();
                    //builder2.append("Question: " + question).append("\n");


                    LocalTime l = LocalTime.now();
                    //temp.append(l.getHour());
                    //l = l.getHour();

                    //temp.append(hours).append("\n");

                    //Date currentTime = Calendar.getInstance().getTime();
                    //temp.append(currentTime);

                    Elements winders = document.select("div.forecast-table-wind__container");
                    for (Element answer : winders) {
                        wind.append(answer.text()).append("\n");
                    }
                    Elements temps = document.select("div.forecast-table-temp__container");
                    for (Element answerer : temps) {
                        temp.append(answerer.text()).append("\n");
                    }


                    Elements conditioners = document.select("div.forecast-table-phrases__container");
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

                        //TextView[] textViewArray = {am1,pm1,n1};
                        int tvcounter = 0;
                        int tvcounter2 = 0;


                        am1 = (TextView) findViewById(R.id.am1);
                        pm1 = (TextView) findViewById(R.id.pm1);
                        n1 = (TextView) findViewById(R.id.n1);
                        am2 = (TextView) findViewById(R.id.am2);
                        pm2 = (TextView) findViewById(R.id.pm2);
                        n2 = (TextView) findViewById(R.id.n2);
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
                        }



                        for(int i = 0; i<100;i++)
                        {
                            System.out.println("HERE: " + i + " " + (temp.charAt(i)));

                            if (tvcounter2 <= 2)
                            {
                                    if ((String.valueOf(temp.charAt(i))).matches(".*[0-9].*") || (String.valueOf(temp.charAt(i)).matches("-"))) {
                                        System.out.println("Good: ");// + String.valueOf(temp.charAt(i)));
                                        if (coldCount >=21) {

                                            textViewArray2[tvcounter2].append(String.valueOf(temp.charAt(i)));

                                        }

                                        //i++;

                                    } else {
                                        System.out.println("next: ");
                                        coldCount++;
                                        tvcounter2++;
                                    }

                                }

                            }
                        }



                });




            }
        }).start();

    }

        /*
    public void printScreen(StringBuilder w, StringBuilder t, StringBuilder c)
    {
        am1 = (TextView) findViewById(R.id.am1);
        pm1 = (TextView) findViewById(R.id.pm1);
        n1 = (TextView) findViewById(R.id.n1);



        LocalTime l = LocalTime.now();

        if (l.getHour() > 20)
        {
            am1.setText(String.valueOf(temp.charAt(0)));
            pm1.setText(String.valueOf(temp.charAt(1)));
            n1.setText(String.valueOf(temp.charAt(2)));
        }



*/


}
