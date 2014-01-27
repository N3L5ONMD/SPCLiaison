package com.NelsonMDiaz.SPCLiaison;


/**
 * Created by nelsonmd81 on 1/24/14.
 */
public final class CampusListing
{
    private CampusListing() {}

    public static final SPCCampuses[] campuses =
            {
                    new SPCCampuses(R.string.allstate_campus_label, AllstateCampusActivity.class),
                    new SPCCampuses(R.string.clearwater_campus_label, ClearwaterCampusActivity.class),
                    new SPCCampuses(R.string.epicenter_campus_label, EpicenterCampusActivity.class),
                    new SPCCampuses(R.string.gibbs_campus_label, GibbsCampusActivity.class),
                    new SPCCampuses(R.string.health_education_campus_label, HealthEducationCampusActivity.class),
                    new SPCCampuses(R.string.seminole_campus_label, SeminoleCampusActivity.class),
                    new SPCCampuses(R.string.spc_downtown_campus_label, SPCDowntownActivity.class),
                    new SPCCampuses(R.string.spc_midtown_campus_label, SPCMidtownActivity.class),
                    new SPCCampuses(R.string.spc_vet_tech_campus_label, SPCVetTechCampusActivity.class),
                    new SPCCampuses(R.string.tarpon_springs_campus_label, TarponSpringsCampusActivity.class),

            };

}
