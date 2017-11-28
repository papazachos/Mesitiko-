
package spyros_example;

public class LocationRemitActivity extends FragmentActivity implements OnMapReadyCallback {
        public static final String EXTRA_NAME = "";
        private static final String TAG = "tag";
        private ClusterManager<StoreLatLng> mClusterManager;
        private GoogleMap mMap;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_remit_location);

            ButterKnife.bind(this);

            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(map);
            mapFragment.getMapAsync(this);


        }

        @Override
        public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap;
            // Marker Cluster
            setUpClusterer();
            mMap.getUiSettings().setIndoorLevelPickerEnabled(false);
        }

        private void setUpClusterer() {
            // Position the map.
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(1.304414, 103.834006), 17));

            // Initialize the manager with the context and the map.
            // (Activity extends context, so we can pass 'this' in the constructor.)
            mClusterManager = new ClusterManager<>(this, mMap);

            // Point the map's listeners at the listeners implemented by the cluster
            // manager.
            mMap.setOnCameraIdleListener(mClusterManager);
            mMap.setOnMarkerClickListener(mClusterManager);
            mMap.setOnInfoWindowClickListener(mClusterManager); //added
            mMap.setInfoWindowAdapter(mClusterManager.getMarkerManager());

            // Listener for Info-Window Click , Parse data to next activity.
            mClusterManager.setOnClusterItemInfoWindowClickListener(new ClusterManager.OnClusterItemInfoWindowClickListener<StoreLatLng>() {
                @Override
                public void onClusterItemInfoWindowClick(StoreLatLng myItem) {
                    Intent intent = new Intent(LocationRemitActivity.this, SelectedStoreDetail.class);
                    intent.putExtra(EXTRA_NAME, myItem.getTitle());
                    intent.putExtra("snippet", myItem.getSnippet());
                    Bundle args = new Bundle();
                    args.putParcelable("latlng", myItem.getPosition());
                    intent.putExtra("bundle", args);
                    startActivity(intent);
                }
            });

            // Setting Cluster On Click ~> Zoom in 1 level .
            mClusterManager.setOnClusterClickListener(new ClusterManager.OnClusterClickListener<StoreLatLng>() {
                @Override
                public boolean onClusterClick(final Cluster<StoreLatLng> cluster) {
    //                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(cluster.getPosition(), (float) Math.floor(mMap.getCameraPosition().zoom + 1)), 300, null);
                    BottomSheetDialogFragment bottomSheetDialog = BottomSheetDialogFragment.getInstance();
                    bottomSheetDialog.show(getSupportFragmentManager(), "Custom Bottom Sheet");
                    return true;
                }
            });

            // Add cluster items (markers) to the cluster manager.
            addItems();
        }


        //

        private void addItems() {

            // Firebase Setup to Retrieve Data
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference();
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        if (postSnapshot.hasChild("Info")) {

                            // Get Data from Firebase (Name , Address , Lat , Lng)
                            String locationName = String.valueOf(postSnapshot.child("Info").child("Name").getValue());
                            String locationAddress = String.valueOf(postSnapshot.child("Info").child("Address").getValue());
                            double locationlat = (double) postSnapshot.child("Info").child("lat").getValue();
                            double locationlng = (double) postSnapshot.child("Info").child("lng").getValue();

                            if (locationName != null && locationAddress != null) {
                                // Create Marker inside MyItem + add markers to mClusterManager
                                StoreLatLng item = new StoreLatLng(locationlat, locationlng, locationName, locationAddress);
                                mClusterManager.addItem(item);
                            }
                        }
                    }
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.w(TAG, "Failed to read value.", error.toException());
                }
            });
