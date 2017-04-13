package com.sneakershopper.karim.sneakershopper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String searchtag = "";

        String api_key =  "&api_key=01f76ebcfafd6b340107fce5d90e11cb";
        String auth_token = "&auth_token=72157681444745105-891691ad2f0eb369";

        String api_tag ="&tags=" + searchtag;

        String url = "https://api.flickr.com/services/rest/?method=flickr.photos.search"
                + api_key
                + api_tag
                + "&format=json&nojsoncallback=1"
                + auth_token
                + "&api_sig=bc6e37e18b04af1feb6f4fbf4c3227e2";

        Log.d("Sneaker Shopper", url);

        Button MapsButton = (Button)findViewById(R.id.button_maps);
        MapsButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button_maps:
                Intent i = new Intent(this,MapsActivity.class);
                startActivity(i);
                break;

        }
    }
}
