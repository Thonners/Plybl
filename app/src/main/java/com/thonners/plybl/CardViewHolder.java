package com.thonners.plybl;

import android.graphics.drawable.Drawable;
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

public class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private CardViewHolderListener mListener ;
    private CardView card ;
    private ImageView iv ;
    private TextView mainTV ;

    public static interface CardViewHolderListener {
        void cardClicked(CardViewHolder cardViewHolder) ;
    }

    public CardViewHolder(View itemView, CardViewHolderListener listener) {
        super(itemView);
        card = (CardView) itemView.findViewById(R.id.card) ;
        iv = (ImageView) itemView.findViewById(R.id.imageView) ;
        mainTV = (TextView) itemView.findViewById(R.id.mainTextView) ;
        this.mListener = listener ;
        card.setOnClickListener(this);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void setImage(Drawable drawable) {
        //iv.setImageResource(imageRID);
        iv.setImageDrawable(drawable);
    }

    public void setMainText(String text) {
        mainTV.setText(text);
    }

    @Override
    public void onClick(View v) {
        mListener.cardClicked(this);
    }
}
