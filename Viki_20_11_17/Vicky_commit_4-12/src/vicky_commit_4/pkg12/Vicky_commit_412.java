package vicky_commit_4.pkg12;


import android.location.Location;

import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.widget.Button;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 *
 * @author Vicky
 */
public class Vicky_commit_412 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        case R.id.B_to:
        dataTranser = new Object[2];
        url = getDirectionsUrl();
        GetDirectionsData getDirectionsData = new GetDirectionsData();
        dataTransfer[0] = mMap;
        dataTransfer[1] = url;
        
        getDirectionsData.execute(dataTransfer);
        break;
        
    }
    
    
}
