package com.sneakershopper.karim.sneakershopper;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    public final static String LOG_TAG = "Sneaker Shopper";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Button Declaration and Onclicklistners
        Button MapsButton = (Button)findViewById(R.id.button_maps);
        MapsButton.setOnClickListener(this);

        Button StoresButton = (Button)findViewById(R.id.stores_button);
        StoresButton.setOnClickListener(this);

        Button SettingsButton  = (Button)findViewById(R.id.settings_button);
        SettingsButton.setOnClickListener(this);

        Button QuitButton  = (Button)findViewById(R.id.quit_button);
        QuitButton.setOnClickListener(this);


        // setting font
        TextView title = (TextView)findViewById(R.id.home_title);
        Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/AmericanCaptain.ttf");
        title.setTypeface(typeFace);

        MediaPlayer mp =  MediaPlayer.create(this, R.raw.xolife);
        if (SettingsActivity.isSoundOn(this)) {
            Log.d(LOG_TAG, "Play Sound");
            mp.start();
            mp.setLooping(true); // set looping
        } else {
            mp.stop();
            Log.d(LOG_TAG, "Stop Sound");
        }





    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button_maps:
                Intent i = new Intent(this,MapsActivity.class);
                startActivity(i);
                break;
            case R.id.stores_button:
                Intent Stores = new Intent(this,StoresActivity.class);
                startActivity(Stores);
                break;
            case R.id.settings_button:
                Intent Settings = new Intent(this, SettingsActivity.class);
                startActivity(Settings);
                break;

        }
    }



//    public void button_settings(View v) {
//        Log.d(LOG_TAG, "Open Settings");
//
//        Intent i = new Intent(this, SettingsActivity.class);
//        startActivity(i);
//    }






}
