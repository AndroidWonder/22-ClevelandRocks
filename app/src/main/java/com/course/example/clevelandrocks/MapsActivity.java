package com.course.example.clevelandrocks;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    //next two variables are part of a test for longPress event
    private long lastTouchTimeDown = -1;
    private long lastTouchTimeUp = -1;
    private static final float zoom = 14.0f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        //center map and set zoom level
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(41.498370, -81.693883), zoom));

        //set markers
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(41.506052,-81.699560))
                .title("Cleveland Browns Stadium")
                .snippet("Football legends since 1946")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(41.496550,-81.688198))
                .title("Quick Loans Arena")
                .snippet("Home of the Cleveland Cavaliers")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(41.495749,-81.685333))
                .title("Progressive Field")
                .snippet("Cleveland Indians Home\nMajor League Baseball since 1900's")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(41.502088,-81.623003))
                .title("Cleveland Clinic")
                .snippet("Top Hospital & Medical Research in the USA")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(41.508421,-81.695540))
                .title("Rock & Roll Hall of Fame")
                .snippet("Preserving for the world \nthe history of RR music")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(41.506106, -81.609615))
                .title("Severance Hall")
                .snippet("Cleveland Orchestra - Best in the World")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(41.508968, -81.611754))
                .title("Cleveland Museum of Art")
                .snippet("Most Distinguished \nOpen Museum in the World")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));


        //set listeners
        mMap.setOnMarkerClickListener(
                new GoogleMap.OnMarkerClickListener() {

                    public boolean onMarkerClick(Marker m) {
                        String title = m.getTitle();
                        String snip = m.getSnippet();
                        Toast.makeText(getApplicationContext(), title + "\n" + snip, Toast.LENGTH_LONG).show();
                        return true;
                    }
                }
        );

        mMap.setOnMapLongClickListener(
                new GoogleMap.OnMapLongClickListener() {
                    public void onMapLongClick(LatLng point) {
                        Toast.makeText(getApplicationContext(), "Long Tap",
                                Toast.LENGTH_LONG).show();
                    }
                }
        );

        mMap.setOnMapClickListener(
                new GoogleMap.OnMapClickListener() {
                    public void onMapClick(LatLng point) {
                        Toast.makeText(getApplicationContext(), "Short Tap", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        //enable a zoom control
        mMap.getUiSettings().setZoomControlsEnabled(true);

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_S) {
            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            return (true);
        }
        else if (keyCode == KeyEvent.KEYCODE_N) {
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            return (true);
        }
        return (super.onKeyDown(keyCode, event));
    }


}

