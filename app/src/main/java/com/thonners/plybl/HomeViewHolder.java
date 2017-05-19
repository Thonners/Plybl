package com.thonners.plybl;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * ViewHolder for the cards in the home RecyclerView
 *
 * @author M Thomas
 * @since 19/05/17
 */

public class HomeViewHolder extends RecyclerView.ViewHolder {

    private CardView card ;
    private ImageView iv ;
    private TextView mainTV ;

    public HomeViewHolder(View itemView) {
        super(itemView);
        card = (CardView) itemView.findViewById(R.id.card) ;
        iv = (ImageView) itemView.findViewById(R.id.imageView) ;
        mainTV = (TextView) itemView.findViewById(R.id.mainTextView) ;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void setImage(int imageRID) {
        iv.setImageResource(imageRID);
    }
}
