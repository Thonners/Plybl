package com.thonners.plybl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BasketActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        // Toolbar admin
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Basket");

        View buyNowButton = findViewById(R.id.buy_now_button) ;
        buyNowButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buy_now_button:
                Intent loginIntent = new Intent(this, LogInActivity.class) ;
                startActivity(loginIntent);
                break;
        }
    }
}
