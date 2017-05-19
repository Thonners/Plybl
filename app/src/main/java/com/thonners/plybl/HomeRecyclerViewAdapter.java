package com.thonners.plybl;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Class to manage the recyclerview in the HomeActivity
 *
 * @author M Thomas
 * @since 18/05/17
 */

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeViewHolder> {

    private Context context ;

    public HomeRecyclerViewAdapter(Context context) {
        this.context = context ;
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate and initialise the view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_default_layout, parent, false) ;
        HomeViewHolder holder = new HomeViewHolder(v) ;
        return holder;
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
