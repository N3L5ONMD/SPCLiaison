package com.NelsonMDiaz.SPCLiaison;

/*
 * Created by Nelson on 1/23/14.
 */
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GibbsCampusActivity extends FragmentActivity implements View.OnClickListener, DialogInterface.OnClickListener
{
    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gibbs_campus);

        // Button for 'Driving Directions' provides users current location to destination via Google Maps app
        Button getDirections = (Button) findViewById(R.id.get_directions_button);
        getDirections.setOnClickListener(this);
    }
        @Override
        public void onClick(View view)
        {
            AlertDialog popUp = new AlertDialog.Builder(this)
                    .setMessage("You are about to leave SPC Liaison and open Google Maps.")
                    .setIcon(R.drawable.ic_launcher)
                    .setTitle("SPC Liaison")
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
    protected void onResume()
    {
        super.onResume();
        setUpMapIfNeeded();
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
        }
    }

    private void setUpMap()
    {
        mMap.addMarker(new MarkerOptions().position(new LatLng(27.777523, -82.729470)).title("AD").snippet("Administration").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(27.777863, -82.729468)).title("MU").snippet("Music Center").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(27.777833, -82.731290)).title("LA").snippet("Language Arts").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(27.778157, -82.731195)).title("BK").snippet("Book Store").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(27.778380, -82.731460)).title("SS").snippet("Student Services").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(27.778596, -82.731557)).title("FS").snippet("Food Service").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(27.778825, -82.731713)).title("LI").snippet("Library").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(27.777983, -82.731790)).title("EI").snippet("Ethics Institute").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(27.777961, -82.732032)).title("HS").snippet("Humanities").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(27.777867, -82.731911)).title("SA").snippet("Social Arts").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(27.777854, -82.732388)).title("MR").snippet("MIRA").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(27.777781, -82.732550)).title("TE").snippet("Technical").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(27.778177, -82.733147)).title("SC - West").snippet("Natural Science").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(27.778384, -82.732517)).title("SC - North").snippet("Natural Science").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(27.779106, -82.732005)).title("GM").snippet("Gymnasium").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));

    }

}