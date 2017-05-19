package com.thonners.plybl;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Main basis of the views to be added to recyclerviews whenever list items are being shown
 *
 * @author M Thomas
 * @since 18/05/17
 */

public class CardViewDefault extends CardView {

    ImageView iv ;
    TextView tvMain ;

    public CardViewDefault(Context context) {
        super(context);
    }

    public CardViewDefault(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CardViewDefault(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * Create and inflate the chile views and get instances of the ImageView and TextView
     */
    private void initialise(Context context) {
    }

}
