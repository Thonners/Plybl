package com.thonners.plybl;

/**
 * Class to hold all details of a design
 *
 * @author M Thomas
 * @since 22/05/17
 */

public class Design {

    public static final String DESIGN_CATEGORY_INTENT_EXTRA = "com.thonners.plybl.designCategory" ;

    private String title ;
    private int id ;
    private DesignCategory category ;

    /**
     * The category into which the design falls
     */
    public enum DesignCategory {
        UNKNOWN (000, "Unknown Category"),
        CHAIR (100, "Chairs"),
        SHELVING (200, "Shelving"),
        TABLE (300, "Tables"),
        OUTDOOR (400, "Outdoor Furniture");

        private int categoryId;
        private String categoryTitle ;

        DesignCategory(int categoryId, String title) {
            this.categoryId = categoryId;
            this.categoryTitle = title ;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public String getCategoryTitle() {
            return categoryTitle;
        }

        public static DesignCategory getCategoryFromID(int categoryId) {
            for (DesignCategory category : DesignCategory.values()) {
                if (categoryId == category.getCategoryId()) {
                    return category;
                }
            }
            return UNKNOWN ;
        }
    }

    public Design(String title, int id) {
        this.title = title ;
        this.id = id ;
        // TODO: Get this in properly
        this.category = DesignCategory.SHELVING ;
    }

    public String getTitle() {
        return title;
    }

    /**
     * @return Unique identifier for this design
     */
    public int getId() {
        return id;
    }

    public DesignCategory getCategory() {
        return category;
    }
}
