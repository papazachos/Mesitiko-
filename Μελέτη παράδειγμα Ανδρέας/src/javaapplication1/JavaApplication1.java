/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Riko
 */
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.title(locality); //Θα βγάζει την χώρα στο marker.
        mMap.snippet("Τοποθέτηση σχολίου");
        mMap.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)); //Κίτρινο marker.
        mMap.icon(BitmapDescriptorFactory.fromResource(R.mipmap.iclauncher)); //Marker με το εικονίδιο του Android.
        mMap.draggable(true); //Για να μετακινηθεί το marker.
        LatLng serres = new LatLng(41.090923, 23.54132);
        mMap.addMarker(new MarkerOptions().position(serres).title("Serres"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(serres, 15.0f));

    }


}