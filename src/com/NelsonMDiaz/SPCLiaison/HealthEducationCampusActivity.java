package com.NelsonMDiaz.SPCLiaison;

/**
 * Created by nelsonmd81 on 1/23/14.
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

public class HealthEducationCampusActivity extends FragmentActivity implements View.OnClickListener, DialogInterface.OnClickListener
{
    GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.health_education_campus);

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
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?saddr=&daddr=27.838509, -82.729822"));
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
        mMap.addMarker(new MarkerOptions().position(new LatLng(27.838509, -82.729822)).title("AD").snippet("Administration").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));

    }
}
