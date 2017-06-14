package com.sneakershopper.karim.sneakershopper;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class StoreActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        Resources res = getResources();
        final String[] stores = res.getStringArray(R.array.store_names);

        final ListView storelist = (ListView) findViewById(R.id.store_list);


        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                stores);


        storelist.setAdapter(adapter);
        storelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Log.d("Sneaker Shopper","Position: "+ position + " - Store: " + stores[position]);


                Intent i = new Intent(getApplicationContext(),LocationActivity.class);
                i.putExtra("position", position);
                startActivity(i);



            }
        });


    }






    }








