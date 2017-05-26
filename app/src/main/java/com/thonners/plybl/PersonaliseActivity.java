package com.thonners.plybl;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.SeekBar;

import java.util.Locale;

public class PersonaliseActivity extends AppCompatActivity implements DialogInterface.OnClickListener, View.OnClickListener{

    private static final String LOG_TAG = "PersonaliseActivity" ;

    private Design design ;
    private CoordinatorLayout cl ;
    private FloatingActionButton fab ;

    private PersonaliseActivityFragment1 personaliseActivityFragment1 = null;
    private PersonaliseActivityFragment2 personaliseActivityFragment2 = null;
    private int fragmentPageNo = 1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalise);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle(getIntent().getStringExtra("TITLE"));

        // Fragments
        personaliseActivityFragment1 = (PersonaliseActivityFragment1) getSupportFragmentManager().findFragmentById(R.id.fragment) ;

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);

        // Coordinator layout for snackbar
        cl = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

    }


    /**
     * TODO: Actually implement saving the design
     */
    private void saveDesign(boolean pressBackAfterSave) {
        Snackbar snackbar = Snackbar.make(cl,"Saving design...", Snackbar.LENGTH_SHORT)
                .setAction("CANCEL SAVE", null) ;
        if (pressBackAfterSave) {
            snackbar.addCallback(new Snackbar.Callback() {
                @Override
                public void onDismissed(Snackbar transientBottomBar, int event) {
                    super.onDismissed(transientBottomBar, event);
                    PersonaliseActivity.super.onBackPressed();
                }
            });
        }
        snackbar.show();
    }

    @Override
    public void onBackPressed() {
        // Depending on which fragment we've got loaded, do stuff
        switch (fragmentPageNo) {
            case 1:
                showSavePopup();
                break;
            case 2:
                // Decrement fragment page count
                --fragmentPageNo ;
                // Swap FAB icon back
                fab.setImageResource(R.drawable.ic_arrow_forward_white_24dp);
                super.onBackPressed();
                break;
            default:
                --fragmentPageNo ;
                super.onBackPressed();
                break;
        }
    }

    private void showSavePopup() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this) ;
        builder.setTitle("Would you like to save your design?")
                .setNegativeButton("DON'T SAVE", this)
                .setPositiveButton("SAVE", this);
        AlertDialog dialog = builder.create() ;
        dialog.show();

    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which) {
            case DialogInterface.BUTTON_NEGATIVE:
                // Quit without saving
                super.onBackPressed();
                break ;
            case DialogInterface.BUTTON_POSITIVE:
                // Save the design
                saveDesign(true) ;
                break ;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                loadNextFragment();
                break;
            default:
                Log.d(LOG_TAG, "Unrecognised view clicked. v.id = " + v.getId()) ;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home :
                onBackPressed();
                return true ;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void loadNextFragment() {
        switch (fragmentPageNo) {
            case 1:
                // Ensure there's a fragment instance
                if (personaliseActivityFragment2 == null) {
                    personaliseActivityFragment2 = PersonaliseActivityFragment2.newInstance();
                }
                // Swap fragment
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,personaliseActivityFragment2,"PersonaliseActivityFragment2")
                        .addToBackStack(null)
                        .commit() ;
                // Increment page counter
                ++fragmentPageNo ;
                // Swap FAB icon
                fab.setImageResource(R.drawable.ic_add_shopping_cart_white_24dp);
                break;
        }
    }
}
