package com.thonners.plybl;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

/**
 * Pager adapter for displaying available designs
 *
 * @author M Thomas
 * @since 22/05/17
 */

public class DesignChoicePagerAdapter extends FragmentPagerAdapter {

    private final String LOG_TAG = "DesignChoicePA" ;

    private DesignLibraryManager libraryManager ;
    private Design.DesignCategory category ;

    public DesignChoicePagerAdapter(FragmentManager fm, DesignLibraryManager libraryManager, Design.DesignCategory category) {
        super(fm);
        this.libraryManager = libraryManager ;
        this.category = category ;
    }

    @Override
    public Fragment getItem(int position) {
        return DesignChoiceFragment.newInstance(category.getCategoryId(),position);
    }

    @Override
    public int getCount() {
        Log.d(LOG_TAG,"Get count called. CategoryID = " + category.name()) ;
        switch (category) {
            case CHAIR:
                return 2 ;
            case SHELVING:
                return 3 ;
            case TABLE:
                return 3;
            case OUTDOOR:
                return 3;
        }
        return 0;
    }

    /**
     * @param position The tab position index
     * @return The title of the tab
     */
    @Override
    public CharSequence getPageTitle(int position) {
        Log.d(LOG_TAG,"GetPageTitle  called...") ;
        return libraryManager.getSubcategoryTitle(category,position) ;
    }
}
