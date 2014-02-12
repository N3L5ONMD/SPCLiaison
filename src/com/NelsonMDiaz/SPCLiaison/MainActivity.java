package com.NelsonMDiaz.SPCLiaison;

/*
 * Created by Nelson on 1/23/14.
 */
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public final class MainActivity extends ListActivity
{
    private static class CustomArrayAdapter extends ArrayAdapter<SPCCampuses>
    {
        public CustomArrayAdapter(Context context, SPCCampuses[] campuses)
        {
            super(context, R.layout.feature, R.id.campus, campuses);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            FeatureView featureView;
            if (convertView instanceof FeatureView)
            {
                featureView = (FeatureView) convertView;
            } else
            {
                featureView = new FeatureView(getContext());
            }

            SPCCampuses campus = getItem(position);

            featureView.setCampusId(campus.campusId);

            return featureView;
        }
    }

    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ListAdapter adapter = new CustomArrayAdapter(this, CampusListing.campuses);

        setListAdapter(adapter);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        if(locationManager == null)
        {
            boolean gpsIsNotEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

            if(gpsIsNotEnabled)
            {
                    //Show an error dialog that GPS is disabled.
                final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Your GPS seems to be disabled, do you want to enable it?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                        {
                            public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                                startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener()
                        {
                            public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id)
                            {
                                dialog.cancel();
                            }
                        });
                final AlertDialog alert = builder.create();
                alert.show();
            }
        }

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        SPCCampuses campus = (SPCCampuses) getListAdapter().getItem(position);
        startActivity(new Intent(this, campus.activityClass));
    }
}
