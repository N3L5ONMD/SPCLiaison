package com.NelsonMDiaz.SPCLiaison;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by nelsonmd81 on 1/25/14.
 */
public final class FeatureView extends FrameLayout
{
    /*
     * Constructs a feature view by inflating layout/feature.xml
     */
       public FeatureView(Context context)
       {
           super(context);

           LayoutInflater layoutInflater =
                   (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           layoutInflater.inflate(R.layout.feature, this);
       }
    public synchronized void setCampusId(int campusId) {
        ((TextView) (findViewById(R.id.campus))).setText(campusId);
    }

}

