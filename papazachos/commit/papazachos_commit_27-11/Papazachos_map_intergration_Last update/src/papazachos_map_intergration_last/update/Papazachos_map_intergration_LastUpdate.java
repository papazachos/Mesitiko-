package com.example.papazachos.myapplication;


import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
package papazachos_map_intergration_last.update;

/**
 *
 * @author Spiros2
 */
public class Papazachos_map_intergration_LastUpdate {
// Firebase Setup to Retrieve Data
   Query query = dbRef.child("Adds").orderByChild("vasirent").equalTo(rent);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Vasi2 vasi2 = (Vasi2) postSnapshot.getValue(Vasi2.class);
                        LatLng serres = new LatLng(Double.parseDouble(vasi2.getVasicountry()), Double.parseDouble(vasi2.getVasitk()));
                        String title = vasi2.getVasiaddress();
                        //mMap.addMarker(new MarkerOptions().position(serres).title(title));
                        MarkerOptions options = new MarkerOptions()
                                .title(vasi2.getVasiaddress())
                                .position(serres)
                                .snippet(vasi2.getVasifirstname() +" " + vasi2.getVasilastname() + " " + vasi2.getVasiemail()
                                +" " + vasi2.getVasitel() + " " + vasi2.getVasicomments());

                        /*if(mMap != null){
                            mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
                                @Override
                                public View getInfoWindow(Marker marker) {
                                    return null;
                                }

                                @Override
                                public View getInfoContents(Marker marker) {
                                    View v = getLayoutInflater().inflate(R.layout.info_window, null);
                                    TextView fname2 = (TextView) v.findViewById(R.id.fname2);
                                    TextView lname2 = (TextView) v.findViewById(R.id.lname2);
                                    TextView email2 = (TextView) v.findViewById(R.id.email2);
                                    TextView tel2 = (TextView) v.findViewById(R.id.tel2);
                                    TextView address2 = (TextView) v.findViewById(R.id.address2);
                                    TextView comment2 = (TextView) v.findViewById(R.id.comment2);

                                    LatLng ll = marker.getPosition();
                                    fname2.setText(vasi2.getVasifirstname());
                                    lname2.setText(vasi2.getVasilastname());
                                    email2.setText(vasi2.getVasiemail());
                                    tel2.setText(vasi2.getVasitel());
                                    address2.setText(vasi2.getVasiaddress());
                                    comment2.setText(vasi2.getVasicomments());



                                    return v;

                                }
                            });
                        }*/
                        mMap.addMarker(options);
                    }

            }
    
    
}
