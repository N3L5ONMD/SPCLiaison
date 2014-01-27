package com.NelsonMDiaz.SPCLiaison;

/**
 * Created by nelsonmd81 on 1/23/14.
 */

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
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
            if (convertView instanceof FeatureView) {
                featureView = (FeatureView) convertView;
            } else {
                featureView = new FeatureView(getContext());
            }

            SPCCampuses campus = getItem(position);

            featureView.setCampusId(campus.campusId);

            return featureView;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ListAdapter adapter = new CustomArrayAdapter(this, CampusListing.campuses);

        setListAdapter(adapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        SPCCampuses campus = (SPCCampuses) getListAdapter().getItem(position);
        startActivity(new Intent(this, campus.activityClass));
    }
}
