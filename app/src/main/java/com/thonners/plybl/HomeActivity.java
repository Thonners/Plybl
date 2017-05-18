package com.thonners.plybl;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{

    private final String LOG_TAG = "HomeActivity" ;

    private RecyclerView rv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // RecyclerView
        rv = (RecyclerView) findViewById(R.id.recyclerView) ;

        // FABs
        FloatingActionButton fabChairs  = (FloatingActionButton) findViewById(R.id.fab_chairs) ;
        FloatingActionButton fabShelves = (FloatingActionButton) findViewById(R.id.fab_shelves) ;
        FloatingActionButton fabTables  = (FloatingActionButton) findViewById(R.id.fab_tables) ;
        FloatingActionButton fabGarden  = (FloatingActionButton) findViewById(R.id.fab_garden) ;
        // OnClickListeners
        fabChairs.setOnClickListener(this);
        fabShelves.setOnClickListener(this);
        fabTables.setOnClickListener(this);
        fabGarden.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Handle clicks
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.fab_chairs:
                showComingSoonToast("chairs");
                break;
            case R.id.fab_shelves:
                Log.d(LOG_TAG,"fab_shelves clicked") ;
                break;
            case R.id.fab_tables:
                showComingSoonToast("tables");
                break;
            case R.id.fab_garden:
                showComingSoonToast("outdoor things");
                break;
        }
    }

    /**
     * Shows a toast saying 'this isn't yet available'
     * @param whatsComingSoon The 'this' that isn't available
     */
    private void showComingSoonToast(String whatsComingSoon) {
        String message = "Sorry, " + whatsComingSoon + " are not yet available. Please try shelves!";
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
