package com.thonners.plybl;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class DesignChoiceActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener{

    private final String LOG_TAG = "DesignChoiceActivity" ;

    private ViewPager vp ;
    private TabLayout tabLayout;
    private DesignLibraryManager dlm ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_choice);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Get a design library manager instance
        dlm = new DesignLibraryManager();

        // Get the category from the extra
        int designCategoryID = getIntent().getIntExtra(Design.DESIGN_CATEGORY_INTENT_EXTRA,000) ;
        Log.d(LOG_TAG,"Design.DESIGN_CATEGORY_INTENT_EXTRA = " + designCategoryID) ;
        Design.DesignCategory designCategory = Design.DesignCategory.getCategoryFromID(designCategoryID) ;

        // Set the title
        getSupportActionBar().setTitle(designCategory.getCategoryTitle());

        // Viewpager for the tabbed layout
        vp = (ViewPager) findViewById(R.id.viewpager) ;
        vp.setAdapter(new DesignChoicePagerAdapter(getSupportFragmentManager(), dlm, designCategory));

        // Tab layout itself
        tabLayout = (TabLayout) findViewById(R.id.tabs) ;
        tabLayout.setupWithViewPager(vp);

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        int position = tab.getPosition() ;
        vp.setCurrentItem(position);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
