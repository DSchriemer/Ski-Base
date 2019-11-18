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
                final StringBuilder builder = new StringBuilder();


                try {
                    System.out.println("Trying here!!!");
                    Document doc = Jsoup.connect("http://www.ssaurel.com/blog").get();
                    System.out.println("Trying here1.5!!!");
                    String title = doc.title();
                    Elements links = doc.select("a[href]");
                    System.out.println("Trying here2!!!");
                    builder.append(title).append("\n");
                    System.out.println("Trying here3!!!");
                    for ( Element link : links){
                        System.out.println("ow ow ow!!!");
                        builder.append("\n").append("Link: ").append(link.attr("href"))
                                .append("\n").append("Text: ").append(link.text());
                    }
                }
                catch (IOException e) {
                    builder.append("error").append(e.getMessage()).append("\n");
                    System.out.println(e.getMessage());
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        result.setText(builder.toString());
                    }
                });


            }
        }).start();

    }
}
