package spiroscommitdecember4th;

public void loc() throws IOException {
        String editAddress = editaddress.getText().toString().trim();
        Geocoder gc = new Geocoder(this);
        List<Address> list = gc.getFromLocationName(editAddress, 1);
        Address address = list.get(0);
        String locality = address.getLocality();
        lat = address.getLatitude();
        lng = address.getLongitude();

        Toast.makeText(this, locality, Toast.LENGTH_LONG).show();

    }