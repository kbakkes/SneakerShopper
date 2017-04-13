//package com.sneakershopper.karim.sneakershopper;
//
//import android.content.pm.PackageManager;
//import android.location.Location;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v4.app.ActivityCompat;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Log;
//
//
//
//import com.google.android.gms.common.ConnectionResult;
//import com.google.android.gms.common.api.GoogleApiClient;
//import com.google.android.gms.location.LocationListener;
//
////import com.google.android.gms.location.LocationListener;
////import com.google.android.gms.location.LocationRequest;
////import com.google.android.gms.location.LocationServices;
//
//
//public abstract class LocationActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {
//
//    GoogleApiClient mGoogleApiClient;
//    private Location mLastLocation;
//    private LocationRequest mLocationRequest;
//    private static final String LOG_TAG = "GPS APP";
//    private static final int REQUEST_CODE = 1;
//
//    private String[] permissions = {android.Manifest.permission.ACCESS_FINE_LOCATION};
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//        createLocationRequest();
//
//        // Create an instance of GoogleAPIClient.
//        if (mGoogleApiClient == null) {
//            mGoogleApiClient = new GoogleApiClient.Builder(this)
//                    .addConnectionCallbacks(this)
//                    .addOnConnectionFailedListener(this)
//                    .addApi(LocationServices.API)
//                    .build();
//        }
//
//    }
//
//    @Override
//    protected void onStart() {
//        mGoogleApiClient.connect();
//        super.onStart();
//    }
//
//    @Override
//    protected void onPause() {
//        stopLocationUpdates();
//        super.onPause();
//    }
//
//    @Override
//    protected void onStop() {
//        mGoogleApiClient.disconnect();
//        super.onStop();
//    }
//
//
//
//    protected void stopLocationUpdates() {
//        LocationServices.FusedLocationApi.removeLocationUpdates(
//                mGoogleApiClient, this);
//    }
//
//
//    protected void createLocationRequest() {
//        LocationRequest mLocationRequest = new LocationRequest();
//        mLocationRequest.setInterval(10000);
//        mLocationRequest.setFastestInterval(5000);
//        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
//    }
//
//    protected void startLocationUpdates() {
//        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//
//            return;
//        }
//        LocationServices.FusedLocationApi.requestLocationUpdates(
//                mGoogleApiClient, mLocationRequest, this);
//    }
//
//
//    @Override
//    public void onConnected(@Nullable Bundle bundle) {
//        // Als er connectie is
//        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            Log.d(LOG_TAG, "No permission");
//            ActivityCompat.requestPermissions(this, permissions, REQUEST_CODE);
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//
//            Log.d(LOG_TAG, "No permission");
//            return;
//        }
//        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
//                mGoogleApiClient);
//        if (mLastLocation != null) {
//            Log.d(LOG_TAG, "Locatie bekend:  " + mLastLocation);
//        } else {
//            Log.d(LOG_TAG, "locatie is onbekend");
//        }
//
//        startLocationUpdates();
//    }
//
//    @Override
//    public void onConnectionSuspended(int i) {
//        Log.d(LOG_TAG, "There is no connection");
//    }
//
//    @Override
//    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
//        // Wanneer verbinden maken mislukt is
//        Log.d(LOG_TAG, "Connecting Failed");
//    }
//
//    @Override
//    public void onLocationChanged(Location location) {
//        // Wanneer de locatie veranderd is
//        Log.d(LOG_TAG, "Nieuwe Locatie" + mLastLocation);
//        mLastLocation = location;
//
//
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        if (grantResults.length > 0
//                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//
//            startLocationUpdates();
//
//        } else {
//
//            Log.d(LOG_TAG, "No permission");
//        }
//    }
//
//
//}
//
//
//
//
//
//
//
//    }
//}
