
package vicky_commit_9.pkg12;

import android.location.Address;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
/**
 *
 * @author Vicky
 */
public class Vicky_commit_912 {
public class PinwheelMap extends FragmentActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, GoogleMap.OnMarkerClickListener{

    private void addItems() {

        // Firebase Setup to Retrieve Data

        String rent = spinner2.getSelectedItem().toString();
        String house = spinner3.getSelectedItem().toString();

        Query query = dbRef.child("Adds").orderByChild("vasirent").equalTo(rent);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Vasi2 vasi2 = (Vasi2) postSnapshot.getValue(Vasi2.class);
                    String lat1, lng1;
                    LatLng serres = new LatLng(Double.parseDouble(lat1 = vasi2.getVasicountry()), Double.parseDouble(lng1 = vasi2.getVasitk()));
                    String title = vasi2.getVasiaddress();
                        //mMap.addMarker(new MarkerOptions().position(serres).title(title));

                    float f = distance(lat , lng ,Double.parseDouble(lat1), Double.parseDouble(lng1));
                    String distf = String.format("%.02f", f);
                    MarkerOptions options = new MarkerOptions()
                                .title(vasi2.getVasiaddress() + "(" + distf + "km)" + vasi2.getVasifirstname() + " " + vasi2.getVasilastname())
                                .position(serres)
                                .snippet( vasi2.getVasiemail() + " " + vasi2.getVasitel() + " " + vasi2.getVasicomments());

                     mMap.addMarker(options);

                    }
            }
            
        public float distance (double lat, double lng, double lat1, double lng1 ){
            double  earthRadius = 3958.75;
            double latDiff = Math.toRadians(lat-lat1);
            double lngDiff = Math.toRadians(lng-lng1);
            double a = Math.sin(latDiff/2)*Math.sin(latDiff /2)+Math.cos(Math.toRadians(lat1))*Math.cos(Math.toRadians(lat))*
                    Math.sin(lngDiff/2)*Math.sin(lngDiff);
            double c=2*Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
            double distance = earthRadius*c;

            double meterConversion =  1.609;

            return new Float(distance * meterConversion).floatValue();
        }
      }
   }
  }
}
