package com.example.human.maps;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import com.example.human.R;
import com.example.human.PermissionUtils;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.vision.barcode.Barcode;

import java.io.IOException;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import static com.example.human.R.id.map;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback,
        GoogleMap.OnMyLocationButtonClickListener,

        ActivityCompat.OnRequestPermissionsResultCallback {


    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    private GoogleMap mMap;
    private boolean mPermissionDenied = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        LatLng hss = new LatLng(40.713958, -73.984515);
        mMap.addMarker(new MarkerOptions().position(hss).title("Henry St Shelter"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(hss));

        LatLng harlem = new LatLng(40.802994, -73.936658);
        mMap.addMarker(new MarkerOptions().position(harlem).title("Harlem shelter"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(harlem));

        LatLng bx = new LatLng(40.840991, -73.891511);
        mMap.addMarker(new MarkerOptions().position(bx).title("Cartona Park shelter"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bx));

        LatLng bxOneSixNine = new LatLng(40.833165, -73.906319);
        mMap.addMarker(new MarkerOptions().position(bxOneSixNine).title("169th Shelter"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bxOneSixNine));

        LatLng bxGrandC = new LatLng(40.832640, -73.918773);
        mMap.addMarker(new MarkerOptions().position(bxGrandC).title("1130 Grand Concourse Shelter"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bxGrandC));

        LatLng bxJackAve = new LatLng(40.815281, -73.907848);
        mMap.addMarker(new MarkerOptions().position(bxJackAve).title("Bx Jackson Ave Shelter"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bxJackAve));

        LatLng bxGrandC1780 = new LatLng(40.845951, -73.908942);
        mMap.addMarker(new MarkerOptions().position(bxGrandC1780).title("1780 Grand Concourse Shelter"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bxGrandC1780));

        LatLng bkEastPkwy = new LatLng(40.669348, -73.931318);
        mMap.addMarker(new MarkerOptions().position(bkEastPkwy).title("East Pkwy Shelter"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bkEastPkwy));

        LatLng bkFultonSt = new LatLng(40.678601, -73.920123);
        mMap.addMarker(new MarkerOptions().position(bkFultonSt).title("Fulton St Shelter"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bkFultonSt));

        LatLng bkBeaverSt = new LatLng(40.699906, -73.936715);
        mMap.addMarker(new MarkerOptions().position(bkBeaverSt).title("Beaver St Shelter"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bkBeaverSt));

        LatLng bkMyrtleAv = new LatLng(40.699183, -73.916797);
        mMap.addMarker(new MarkerOptions().position(bkMyrtleAv).title("Myrtle Ave Shelter"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bkMyrtleAv));

        LatLng bkE98 = new LatLng(40.663744, -73.921106);
        mMap.addMarker(new MarkerOptions().position(bkE98).title("East 98th St Shelter"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bkE98));

        LatLng bk3060Fulton = new LatLng(40.680656, -73.881692);
        mMap.addMarker(new MarkerOptions().position(bk3060Fulton).title("Beaver St Shelter"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bk3060Fulton));

        Barcode.GeoPoint p1 = getLocationFromAddress("SFO");

        LatLng sydney = new LatLng(p1.lat, p1.lng);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.setOnMyLocationButtonClickListener(this);
        enableMyLocation();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE) {
            return;
        }

        if (PermissionUtils.isPermissionGranted(permissions, grantResults,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
            // Enable the my location layer if the permission has been granted.
            enableMyLocation();
        } else {
            // Display the missing permission error dialog when the fragments resume.
            mPermissionDenied = true;
        }
    }

    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission to access the location is missing.
            PermissionUtils.requestPermission(this, LOCATION_PERMISSION_REQUEST_CODE,
                    Manifest.permission.ACCESS_FINE_LOCATION, true);
        } else if (mMap != null) {
            // Access to the location has been granted to the app.
            mMap.setMyLocationEnabled(true);
        }
    }

    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show();

        Location userLocation = mMap.getMyLocation();
        LatLng myLocation = null;
        if (userLocation != null) {
            myLocation = new LatLng(userLocation.getLatitude(),
                    userLocation.getLongitude());
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myLocation,
                    mMap.getMaxZoomLevel() - 5));
        }
        // LatLng loc = new LatLng (location.getLatitude(), location.getLongitude());
//        map.animateCamera(CameraUpdateFactory.newLatLngZoom(loc, 16.0f));
        // Return false so that we don't consume the event and the default behavior still occurs
        // (the camera animates to the user's current position).
        return true;
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        if (mPermissionDenied) {
            // Permission was not granted, display error dialog.
            showMissingPermissionError();
            mPermissionDenied = false;
        }
    }

    /**
     * Displays a dialog with error message explaining that the location permission is missing.
     */
    private void showMissingPermissionError() {
        PermissionUtils.PermissionDeniedDialog
                .newInstance(true).show(getFragmentManager(), "dialog");

    }

    public Barcode.GeoPoint getLocationFromAddress(String strAddress) {

        Geocoder coder = new Geocoder(this);
        List<Address> address;
        Barcode.GeoPoint p1 = null;

        try {
            address = coder.getFromLocationName(strAddress, 5);
            if (address == null) {
                return null;
            }
            Address location = address.get(0);


            location.getLongitude();

            Double latitude = location.getLatitude() * 1E6;
            Double longitude = location.getLongitude() * 1E6;

            //p1 = new Barcode.GeoPoint(2, latitude, longitude);
            p1 = new Barcode.GeoPoint();


        } catch (IOException e) {
            e.printStackTrace();
        }
        return p1;
    }


//    protected void createLocationRequest() {
//        LocationRequest mLocationRequest = new LocationRequest();
//        mLocationRequest.setInterval(10000);
//        mLocationRequest.setFastestInterval(5000);
//        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
//        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
//                .addLocationRequest(mLocationRequest);
//    }
}
