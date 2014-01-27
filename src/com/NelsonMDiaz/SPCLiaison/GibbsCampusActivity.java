package com.NelsonMDiaz.SPCLiaison;

/**
 * Created by nelsonmd81 on 1/23/14.
 */
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GibbsCampusActivity extends FragmentActivity
{
    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gibbs_campus);
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
        // 6

    }
}