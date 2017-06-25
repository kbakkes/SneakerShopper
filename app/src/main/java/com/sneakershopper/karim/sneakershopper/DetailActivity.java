package com.sneakershopper.karim.sneakershopper;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;



import com.google.android.gms.maps.GoogleMap;

public class DetailActivity extends AppCompatActivity {

    private GoogleMap mMap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Resources res = getResources();
        final String[] stores = res.getStringArray(R.array.store_names);

        TextView textView = (TextView)findViewById(R.id.detail_title);

        Bundle bundle = getIntent().getExtras();
        Integer titleposition = (Integer) bundle.get("position");
        textView.setText(stores[titleposition]);


    }





}
