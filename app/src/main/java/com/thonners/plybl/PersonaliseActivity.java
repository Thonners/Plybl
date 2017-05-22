package com.thonners.plybl;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;

public class PersonaliseActivity extends AppCompatActivity implements DialogInterface.OnClickListener{

    private CoordinatorLayout cl ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalise);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle(getIntent().getStringExtra("TITLE"));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

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
        showSavePopup() ;
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
}
