package com.example.skibase;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import android.os.Bundle;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button getBtn;
    TextView result;


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
                final StringBuilder high = new StringBuilder();
                final StringBuilder low = new StringBuilder();
                final StringBuilder conditions = new StringBuilder();


                try {

                    String url = "https://skifernie.com/conditions/";
                    Document document = Jsoup.connect(url).get();

                    //String question = document.select("#question .post-text").text();
                    //builder2.append("Question: " + question).append("\n");

                    Elements answerers = document.select("div.fhigh");
                    for (Element answerer : answerers) {
                        builder2.append("Answerer: " + answerer.text()).append("\n");
                    }


                }
                catch (IOException e) {
                    builder2.append("error").append(e.getMessage()).append("\n");
                    System.out.println(e.getMessage());
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        result.setText(builder2.toString());
                    }
                });


            }
        }).start();

    }
}
