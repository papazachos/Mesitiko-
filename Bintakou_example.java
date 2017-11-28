
package bintakou_markers;


public class Bintakou_markers {

    
import android.location.Location;

private locationClient locationClient;
private GoogleMap map;
private LocationRequest request = LocationRequest.create().setInterval(5000).setFastestInterval(16);
private static final double Range = 0

private void setupMapifRequired(){
  if(map)==null){

      MapFragmet mapFragment = (MapFragment) getFragment().findFragmedbyId(R.id.map);
      map = mapFragment.getMap();
   }

if(map !=null) {
   map.setMyLocationEnabled(true);
}
}

@override
protected void onResume(){
  super.onResume();
  setupLocationClientIfRewuired();
  locationClient.connect();
}

@override
peotected void onPause(){
super.onPause();
locationClient.connect();

}

private void setupLocationClientRequired(){
   if(locationClient == null){
     locationClient = new LocationClient(this, this, this);
}
}


@override public void onConnectionFailed((ConnectionResult result){

}

@overridepublic void onConnectionFailed((ConnectionResult result){
    location.requestlocationUpdates(request,this);
}

@override
public void onDisconnected(){

}

@override
public void onLocationhanged(Location location) {
     double latitube = location.getLatitube();
     double longitube = location.getLongitube();

     PlantSearchTask plans = new PlantSearchTask();

     plans.execute(latitube, logitube, Range);
}

class PlantSearchTask extends AsyncTask(Double,Integer,List(Plant)) {

  @override
  protected void onPostExecute(List(Plant).result){
    for (Plant plant : result){
       
       Lating position = new Lating(plant.getLatitube(), plant.getLongitube());

       }
}

  @override
  protected List(Plant).doInBackground(Double... parms){
  return null;
}
}

    
}
