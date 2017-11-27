
 
package papazachos_commit_27.pkg11;

/*
 * @author papazachos
 */

    @Override
       public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_map);
       ButterKnife.bind(this);

       Bundle bundle = getIntent().getExtras();
       userId = bundle.getString("uid");
       _shareButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(TAG2, "ONCLICKKK");
            mFirebaseInstance = FirebaseDatabase.getInstance();
            mFirebaseDatabase = mFirebaseInstance.getReference("locations");

            mFirebaseDatabase.child("locations").addListenerForSingleValueEvent(
            new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get user value
                Log.d(TAG, "ondatachange called");
                // Marker mark

                List<LocationData> locationData = new ArrayList<LocationData>();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                             locationData.add(postSnapshot.getValue(LocationData.class));
                }
                for(int i = 0; i < locationData.size(); i++){
                    LatLng latLng = new LatLng(locationData.get(i).getLatitude(),locationData.get(i).getLongtitude());
                    Marker marker = nGoogleMap.addMarker(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                    Toast.makeText(getApplicationContext(), "lat: " + locationData.get(i).getLatitude()
                            + "long : " + locationData.get(i).getLongtitude(),Toast.LENGTH_LONG).show();

                }

                }

               @Override
                public void onCancelled(DatabaseError databaseError) {
                            System.out.println(databaseError);
                            System.out.println("ERROR DATABASE");

               }
            });
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
            checkLocationPermission();
            }
        }
    });