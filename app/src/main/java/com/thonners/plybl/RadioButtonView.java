package com.thonners.plybl;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author M Thomas
 * @since 26/05/17
 */
public class RadioButtonView extends FrameLayout implements View.OnClickListener {
    public enum Type {
        QUALITY, COLOUR, JOINT;
    }

    private Context context;
    private CardView card;
    private TextView tv;
    private ImageView iv ;
    private Drawable background = null;
    int colourID;
    private String name;
    private boolean isSelected = false;
    private Type type;

    public RadioButtonView(Context context) {
        super(context);
        init();
    }

    @Override
    public void onClick(View v) {

    }

    public Type getType() {
        return type;
    }

    public RadioButtonView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RadioButtonView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public RadioButtonView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public void initialise(Context context, Drawable background, String name, Type type) {
        this.context = context;
//            card = (CardView) findViewById(R.id.card);
//            tv = (TextView) findViewById(R.id.text) ;
        this.background = background;
        this.name = name;
        this.type = type;
        initaliser();
    }

    public void initialise(Context context, View parentView, int colourID, String name, Type type) {
        this.context = context;
//            card = (CardView) parentView.findViewById(R.id.card);
//            tv = (TextView) parentView.findViewById(R.id.text) ;
        this.colourID = colourID;
        this.name = name;
        this.type = type;
        initaliser();
    }

    /**
     * Gets the view instances
     */
    private void init() {
        // Inflate the layout
        inflate(getContext(), R.layout.layout_radio_button, this);
        // Get the child views
        this.card = (CardView) findViewById(R.id.card);
        this.tv = (TextView) findViewById(R.id.text);
        this.iv = (ImageView) findViewById(R.id.imageView) ;
    }

    /**
     * Sets the text once the instance has been assigned
     */
    private void initaliser() {
        // Set the text
        tv.setText(name);
        if (background == null) {
            iv.setBackgroundColor(colourID);
        } else {
            iv.setBackground(background);
        }
    }

    public void setButtonSelected(boolean selected) {
        isSelected = selected;
        if (isSelected) {
            card.animate()
                    .setDuration(300)
                    .setInterpolator(new AccelerateDecelerateInterpolator())
                    .translationZ(context.getResources().getDimensionPixelOffset(R.dimen.fab_pressed_z))
                    .scaleX(1.1f)
                    .scaleY(1.1f)
                    .start();
//            tv.setTextSize(R.dimen.radio_button_text_size_raised);
            tv.setText(Html.fromHtml("<u>" + name + "</u>"),null);
            tv.setTypeface(tv.getTypeface(), Typeface.BOLD);
        } else {
            card.animate()
                    .setDuration(300)
                    .setInterpolator(new AccelerateDecelerateInterpolator())
                    .translationZ(context.getResources().getDimensionPixelOffset(R.dimen.fab_resting_z))
                    .scaleX(1.0f)
                    .scaleY(1.0f)
                    .start();
//            tv.setTextSize(R.dimen.radio_button_text_size_resting);
            tv.setText(name);
            tv.setTypeface(null, Typeface.NORMAL);
        }


    }

}
