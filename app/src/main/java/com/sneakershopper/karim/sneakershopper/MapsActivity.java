package com.sneakershopper.karim.sneakershopper;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;




public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {



   final private double[] latlist = {
            51.920882 ,
            51.921054,
            51.920657

        };
    final private double[] longlist = {
            4.476588,
            4.477092,
            4.476827

    };

    int titleposition = 0;
    String[] stores =  {

    };


    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        Bundle bundle = getIntent().getExtras();
        titleposition = (Integer) bundle.get("position");

        Resources res = getResources();

        stores = res.getStringArray(R.array.store_names);



        Log.d("Shop Logger", "Lat: "+latlist[titleposition] +  " Long: " + longlist[titleposition]);
        Log.d("Shop Logger"," array position " + stores[titleposition]+ " Array Position: " + titleposition);



    }





    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng store = new LatLng(latlist[titleposition],longlist[titleposition]);
        mMap.setMinZoomPreference(18.0f);
        mMap.setMaxZoomPreference(25.0f);
        mMap.addMarker(new MarkerOptions().position(store).title("Store: " + stores[titleposition]));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(store));

    }
}
