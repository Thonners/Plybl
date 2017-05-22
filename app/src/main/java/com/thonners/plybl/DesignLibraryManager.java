package com.thonners.plybl;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class to manage available designs
 *
 * @author M Thomas
 * @since 22/05/17
 */

public class DesignLibraryManager {

    private final HashMap<Integer, Design> availableDesigns = new HashMap<>() ;
    private final HashMap<Design.DesignCategory, ArrayList<Design>> availableDesignsCategory = new HashMap<>() ;


    public DesignLibraryManager() {
    }

    /**
     * Update the list of designs available
     */
    public void updateAvailableDesigns() {
        // Just create a few example designs now.
        // TODO: Update this call to download designs from the server
        for (int i = 0 ; i <= 10 ; i++) {
            addDesign(new Design("Shelving design " + i , i));
        }
    }

    /**
     * @param design The design to add to the available design collections
     */
    public void addDesign(Design design) {
        // Add the design to the total list of designs
        availableDesigns.put(design.getId(), design) ;

        // Add the design to the list of available designs in the category
        if (availableDesignsCategory.containsKey(design.getCategory())) {
            availableDesignsCategory.get(design.getCategory()).add(design) ;
        } else {
            ArrayList<Design> newDesignArrayList = new ArrayList<>() ;
            newDesignArrayList.add(design) ;
            availableDesignsCategory.put(design.getCategory(), newDesignArrayList) ;
        }
    }

    /**
     * @param category The primary category
     * @param subcategoryIndex The index of the subcategory - the position of the tab in the selector
     * @return The String title of the subcategory
     */
    public String getSubcategoryTitle(Design.DesignCategory category, int subcategoryIndex) {
        switch (category) {
            case CHAIR:
                return "" ;
            case SHELVING:
                switch (subcategoryIndex) {
                    case 0:
                        return "Most popular" ;
                    case 1:
                        return "Wall Mounted" ;
                    case 2:
                        return "Bookcases" ;
                }
                return "" ;
            case TABLE:
                return "";
            case OUTDOOR:
                return "";
        }
        return "";
    }
}
