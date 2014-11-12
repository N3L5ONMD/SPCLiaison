package com.N3L5onMDiaz.SPCLiaison;

import android.support.v4.app.FragmentActivity;
/**
 * edited by N3L5ONMD on 10/11/14.
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
