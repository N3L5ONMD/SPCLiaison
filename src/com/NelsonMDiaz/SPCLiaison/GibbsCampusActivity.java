package com.NelsonMDiaz.SPCLiaison;

/*
 * Created by Nelson on 1/23/14.
 */
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GibbsCampusActivity extends FragmentActivity
        implements View.OnClickListener,
        DialogInterface.OnClickListener,
        LocationListener,
        LocationSource
{
    GoogleMap mMap;

    // Stores the current instantiation of the location client in this object
    private OnLocationChangedListener mListener;

    // A request to connect to Location Services
    private LocationManager locationManager;

    LatLng ADMINISTRATION_GIBBS = new LatLng(27.777523, -82.729470);
    LatLng MUSIC_CENTER_GIBBS = new LatLng(27.777863, -82.729468);
    LatLng LANGUAGE_ARTS_GIBBS = new LatLng(27.777833, -82.731290);
    LatLng BOOK_STORE_GIBBS = new LatLng(27.778157, -82.731195);
    LatLng STUDENT_SERVICES_GIBBS = new LatLng(27.778380, -82.731460);

    LatLng FOOD_SERVICE_GIBBS = new LatLng(27.778596, -82.731557);
    LatLng LIBRARY_GIBBS = new LatLng(27.778825, -82.731713);
    LatLng ETHICS_INSTITUTE_GIBBS = new LatLng(27.777983, -82.731790);
    LatLng HUMANITIES_GIBBS = new LatLng(27.777961, -82.732032);
    LatLng SOCIAL_ARTS_GIBBS = new LatLng(27.777867, -82.731911);

    LatLng MIRA_GIBBS = new LatLng(27.777854, -82.732388);
    LatLng TECHNICAL_GIBBS = new LatLng(27.777781, -82.732550);
    LatLng NATURAL_SCIENCE_WEST_GIBBS = new LatLng(27.778177, -82.733147);
    LatLng NATURAL_SCIENCE_NORTH_GIBBS = new LatLng(27.778384, -82.732517);
    LatLng GYMNASIUM_GIBBS = new LatLng(27.779106, -82.732005);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gibbs_campus);

        // Button for 'Driving Directions' provides users current location to destination via Google Maps app
        Button getDirections = (Button) findViewById(R.id.get_directions_button);
        getDirections.setOnClickListener(this);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        if(locationManager != null)
        {
            boolean gpsIsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            boolean networkIsEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if(gpsIsEnabled)
            {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 100L, 1.5F, this);
            }
            else if(networkIsEnabled)
            {
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 100L, 1.5F, this);
            }

        }

        setUpMapIfNeeded();
    }
        @Override
        public void onClick(View view)
        {
            AlertDialog popUp = new AlertDialog.Builder(this)
                    .setMessage("You are about to leave SPC Liaison and open Google Maps.")
                    .setIcon(R.drawable.ic_launcher)
                    .setTitle("SPC Liaison - BETA")
                    .setPositiveButton("OK", this)
                    .setNegativeButton("Stay", this)
                    .setCancelable(false)
                    .create();

            popUp.show();

        }

        @Override
        public void onClick(DialogInterface dialog, int which)
        {
            switch (which)
            {
                case DialogInterface.BUTTON_POSITIVE:
                    // Take user to Administration building on Gibbs campus
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?saddr=&daddr=27.777523, -82.729470"));
                    intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                    startActivity(intent);
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    // Dismiss Dialog window
                    break;
                default:
                    // nothing
                    break;

            }
        }

    @Override
    public void onPause()
    {
        if(locationManager != null)
        {
            locationManager.removeUpdates(this);
        }

        super.onPause();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        setUpMapIfNeeded();

        if(locationManager != null)
        {
            mMap.setMyLocationEnabled(true);
        }
        else
        {
            Toast.makeText(this, "Getting your location", Toast.LENGTH_LONG).show();
        }
    }

    private void setUpMapIfNeeded()
    {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null)
        {
            // try to obtain the map from the supportmapfragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null)
            {
                setUpMap();
                mMap.setMyLocationEnabled(true);

            }

            // Register the LocationSource
            mMap.setLocationSource(this);
        }
    }

    private void setUpMap()
    {

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ADMINISTRATION_GIBBS, 10));

        mMap.addMarker(new MarkerOptions().position(ADMINISTRATION_GIBBS).title("AD").snippet("Administration").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
        mMap.addMarker(new MarkerOptions().position(MUSIC_CENTER_GIBBS).title("MU").snippet("Music Center").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
        mMap.addMarker(new MarkerOptions().position(LANGUAGE_ARTS_GIBBS).title("LA").snippet("Language Arts").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
        mMap.addMarker(new MarkerOptions().position(BOOK_STORE_GIBBS).title("BK").snippet("Book Store").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
        mMap.addMarker(new MarkerOptions().position(STUDENT_SERVICES_GIBBS).title("SS").snippet("Student Services").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));

        mMap.addMarker(new MarkerOptions().position(FOOD_SERVICE_GIBBS).title("FS").snippet("Food Service").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
        mMap.addMarker(new MarkerOptions().position(LIBRARY_GIBBS).title("LI").snippet("Library").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
        mMap.addMarker(new MarkerOptions().position(ETHICS_INSTITUTE_GIBBS).title("EI").snippet("Ethics Institute").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
        mMap.addMarker(new MarkerOptions().position(HUMANITIES_GIBBS).title("HS").snippet("Humanities").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
        mMap.addMarker(new MarkerOptions().position(SOCIAL_ARTS_GIBBS).title("SA").snippet("Social Arts").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));

        mMap.addMarker(new MarkerOptions().position(MIRA_GIBBS).title("MR").snippet("MIRA").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
        mMap.addMarker(new MarkerOptions().position(TECHNICAL_GIBBS).title("TE").snippet("Technical").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
        mMap.addMarker(new MarkerOptions().position(NATURAL_SCIENCE_WEST_GIBBS).title("SC - West").snippet("Natural Science").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
        mMap.addMarker(new MarkerOptions().position(NATURAL_SCIENCE_NORTH_GIBBS).title("SC - North").snippet("Natural Science").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
        mMap.addMarker(new MarkerOptions().position(GYMNASIUM_GIBBS).title("GM").snippet("Gymnasium").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));

    }

    @Override
    public void activate(LocationSource.OnLocationChangedListener listener)
    {
        mListener = listener;
    }

    @Override
    public void deactivate()
    {
        mListener = null;
    }

    @Override
    public void onLocationChanged(Location location)
    {
        if( mListener != null )
        {
            mListener.onLocationChanged( location );

            //Move the camera to the user's location once it's available!
            mMap.animateCamera(CameraUpdateFactory.newLatLng(new LatLng(location.getLatitude(), location.getLongitude())));
        }
    }

    @Override
    public void onProviderDisabled(String provider) { }

    @Override
    public void onProviderEnabled(String provider) { }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) { }

}