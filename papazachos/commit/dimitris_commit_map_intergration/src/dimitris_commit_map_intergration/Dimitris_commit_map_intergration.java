
package dimitris_commit_map_intergration;

/**
 *
 * @author Δημητρης
 */
public class Dimitris_commit_map_intergration {

     mMap.setMyLocationEnabled(true);




    //double latitude = myLocation.getLatitude();
    //double longitude = myLocation.getLongitude();
    //LatLng startingPosition = new LatLng(latitude, longitude);

    LatLng Serres = new LatLng(34, 151);
    createMarker();
    //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
}

private void createMarker() {
    Firebase ref = new Firebase("https://shining-fire-3472.firebaseio.com/locations");
    //Query queryRef = ref.orderByChild("latitude");
    ref.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                markerLocation marker = userSnapshot.getValue(markerLocation.class);
                Double lat = Double.parseDouble(marker.getLatitude());
                Double log = Double.parseDouble(marker.getLongtitude());
                LatLng latLng = new LatLng(lat, log);
                mMap.addMarker(new MarkerOptions().position(latLng));
            }
        }

        @Override
        public void onCancelled(FirebaseError firebaseError) {

        }
    });
}
}
Here is the appbuild gradle:

apply plugin: 'com.android.application'

android {
compileSdkVersion 23
buildToolsVersion "23.0.2"

defaultConfig {
    applicationId "com.test.googlemap"
    minSdkVersion 17
    targetSdkVersion 23
    versionCode 1
    versionName "1.0"
    multiDexEnabled true
}
buildTypes {
    release {
        minifyEnabled false
        proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
    }
}
packagingOptions {
    exclude 'META-INF/LICENSE'
    exclude 'META-INF/LICENSE-FIREBASE.txt'
    exclude 'META-INF/NOTICE'
    exclude 'META-INF/services/com.fasterxml.jackson.core.ObjectCodec'
}
dexOptions {
    preDexLibraries = false
    incremental = true;
    javaMaxHeapSize "4g"
}
}

dependencies {
compile fileTree(include: ['*.jar'], dir: 'libs')
testCompile 'junit:junit:4.12'
compile 'com.android.support:appcompat-v7:23.2.0'
compile 'com.google.android.gms:play-services:8.4.0'

compile files('libs/firebase-client-android-2.5.2.jar')

}
        
        
    }
    
}
