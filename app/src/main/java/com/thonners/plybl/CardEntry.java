package com.thonners.plybl;

import android.graphics.drawable.Drawable;

/**
 * Class to hold the details/components needed to populate a card in one of the main views
 *
 * @author M Thomas
 * @since 21/05/17
 */

public class CardEntry {

    private Drawable imageResource ;
    private String mainText ;

    public CardEntry(Drawable imageResource, String mainText) {
        this.imageResource = imageResource;
        this.mainText = mainText;
    }

    public Drawable getImageResource() {
        return imageResource;
    }

    public String getMainText() {
        return mainText;
    }
}
