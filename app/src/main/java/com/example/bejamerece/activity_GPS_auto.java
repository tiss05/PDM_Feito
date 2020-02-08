package com.example.bejamerece;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class activity_GPS_auto extends FragmentActivity implements OnMapReadyCallback {

    //initialize variable
    private GoogleMap gMap;
    private Button btn_save;
    private Button next;
    Location currentLocation;
    FusedLocationProviderClient fusedLocationProviderClient;
    private static final int REQUEST_CODE = 101;
    private FirebaseDatabase mFirestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps_auto);
        next = (Button) findViewById(R.id.maps_next);
        //mFirestore = FirebaseFirestore.getInstance();



        next.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(activity_GPS_auto.this, Personal_Inf.class);
                startActivity(intent);
            }
        });


        //Location_Helper helper = new Location_Helper(currentLocation.getLongitude(),currentLocation.getLatitude());
        /*FirebaseDatabase.getInstance().getReference("Current Location").setValue(helper).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(activity_GPS_auto.this, "Location Saved", Toast.LENGTH_SHORT);}
                else{
                    Toast.makeText(activity_GPS_auto.this, "Location Not Saved", Toast.LENGTH_SHORT);


                }
            }
        });*/

        //Obtain the SupportMapFragment
        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.google_map);
        supportMapFragment.getMapAsync(this);

        //fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        //fetchLastLocation();

    }

    /*private void fetchLastLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]
                    {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);

            return;
        }
        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location != null){
                    currentLocation = location;
                    Toast.makeText(getApplicationContext(),currentLocation.getLatitude()
                    +""+currentLocation.getLongitude(),Toast.LENGTH_SHORT).show();
                    SupportMapFragment supportMapFragment = (SupportMapFragment)
                            getSupportFragmentManager().findFragmentById(R.id.google_map);
                    supportMapFragment.getMapAsync(activity_GPS_auto.this);
                }
            }
        });
    }*/





    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        //Assign Variable
        gMap = googleMap;

        gMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                //Creating Marker
                MarkerOptions markerOptions = new MarkerOptions();
                //Set Marker Position
                markerOptions.position(latLng);
                //Set Latitude and Longitude On MArker
                markerOptions.title(latLng.latitude + " : " + latLng.longitude);
                //Clear the previously click position
                gMap.clear();
                //Zoom the Marker
                gMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
                //Add Marker on Map
                gMap.addMarker(markerOptions);
            }
        });

    }



    /*@Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_CODE:
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    fetchLastLocation();
                }
                break;
        }
    }*/
}

