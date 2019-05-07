package com.example.flickrapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Button btn;
    public static TextView data;
    public static ListView lv;

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");

        btn = (Button) findViewById(R.id.searchbutton);
        data = (TextView) findViewById(R.id.queryresult);
        lv = (ListView) findViewById(R.id.simpleListView);
       // https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=035a4f62b1537a0c672501f0d778739e&text=car&per_page=3&format=json&nojsoncallback=1


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fetchData process = new fetchData();
                process.execute();
            }
        });


    }
}
