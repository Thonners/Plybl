package com.thonners.plybl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Activity to show order confirmation information
 */
public class OrderConfirmation extends AppCompatActivity {

    private TextView tvOrderNo ;
    private TextView tvETA ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmation);

        // Toolbar admin
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Order Confirmation");

        // Get the views
        tvOrderNo = (TextView) findViewById(R.id.tv_order_no);
        tvETA = (TextView) findViewById(R.id.eta_prompt) ;

        // Update the strings
        tvOrderNo.setText(String.format(getString(R.string.order_conf_order_no), 235711));
        tvETA.setText(String.format(getString(R.string.order_conf_eta), 4));
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

}
