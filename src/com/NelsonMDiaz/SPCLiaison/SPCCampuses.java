package com.NelsonMDiaz.SPCLiaison;

import android.support.v4.app.FragmentActivity;
/**
 * Created by nelsonmd81 on 1/24/14.
 */
public class SPCCampuses
{
    public final int campusId;

    public final Class<? extends FragmentActivity> activityClass;


    public SPCCampuses(int campusId, Class<? extends FragmentActivity> activityClass)
    {
        this.campusId = campusId;
        this.activityClass = activityClass;

    }
}
