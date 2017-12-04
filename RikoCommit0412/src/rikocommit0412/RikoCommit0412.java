package rikocommit0412;

if(mMap != null){
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
}